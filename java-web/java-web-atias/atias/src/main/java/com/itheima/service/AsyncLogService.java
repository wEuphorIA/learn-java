package com.itheima.service;

import com.itheima.domain.pojo.OperateLog;
import com.itheima.mapper.OperateLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    /**
     * 异步记录操作日志
     * @param operateLog 日志实体
     */
    @Async("taskExecutor") // 指定线程池，也可以不指定则使用默认的
    public void asyncInsertOperateLog(OperateLog operateLog) {
        try {
            operateLogMapper.insert(operateLog);
            log.debug("操作日志记录成功。");
        } catch (Exception e) {
            // 异步方法的异常需要单独捕获处理，否则会丢失
            log.error("异步记录操作日志时发生异常: {}", e.getMessage(), e);
            // 这里可以根据需要决定是否要重试或进行其他补偿操作
        }
    }
}