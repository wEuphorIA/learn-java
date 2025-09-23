package com.itheima.task;

import com.itheima.mapper.EmpMapper;
import com.itheima.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class FileCleanTask {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    /**
     * 定时清理垃圾文件
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void clean() throws Exception {
        log.info("定时清理文件开始...");
        //1. 查询数据库中的文件(有效文件)
        List<String> urlList = empMapper.listFiles();
        List<String> dbFileList = urlList.stream().map(url -> {
            try {
                return new URL(url).getPath().substring(1);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }).toList();

        //2. 查询阿里云OSS中的文件(全部文件)
        List<String> ossFileList = aliyunOSSOperator.listFiles();

        //3. 计算出垃圾文件, 然后清理垃圾文件 (在 ossFileList 中存在， 但是在 dbFileList 中不存在的文件)
        ossFileList.removeAll(dbFileList);
        if(!CollectionUtils.isEmpty(ossFileList)){
            ossFileList.stream().forEach(file -> {
                try {
                    log.info("删除垃圾文件: {}", file);
                    aliyunOSSOperator.deleteFile(file);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }else {
            log.info("没有垃圾文件...");
        }
        log.info("定时清理文件结束...");
    }

}