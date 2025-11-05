package com.itheima.common.rabbitmq.dao.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.itheima.common.rabbitmq.dao.FailMsgDao;
import com.itheima.common.rabbitmq.dao.mapper.FailMsgMapper;
import com.itheima.common.rabbitmq.domain.FailMsg;
import com.itheima.common.rabbitmq.utils.CollUtils;
import com.itheima.common.rabbitmq.utils.DateUtils;
import com.itheima.common.rabbitmq.utils.JsonUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

//@Repository
@ConditionalOnProperty(prefix = "rabbit-mq", name = "persistence.enable", havingValue = "true")
public class FailMsgDaoImpl implements FailMsgDao {

    private final FailMsgMapper failMsgMapper;

    public FailMsgDaoImpl(FailMsgMapper failMsgMapper) {
        this.failMsgMapper = failMsgMapper;
    }

    /**
     * 集合名称
     */
    private static final String COLLECTION_NAME = "fail_msg";
    private static final String FAIL_CONSUMER_MSG = "fail_consumer_msg";

    private static final String FIELD_NAME_NEXT_EXECUTE_TIME = "next_execute_time";
    private static final String FIELD_NAME_EXCHANGE = "exchange";
    private static final String FIELD_NAME_QUEUE = "queue";
    private static final String FIELD_NAME_ROUTING_KEY = "routing_key";
    private static final String FIELD_NAME_MSG = "msg";
    private static final String FIELD_NAME_REASON = "reason";

    /**
     * 保存失败消息
     *
     * @param failMsg 失败消息
     */
    @Override
    public void save(FailMsg failMsg) {

        List<FailMsg> failMsgs = failMsgMapper.queryById(failMsg.getId());
        if (CollUtils.isEmpty(failMsgs)) {
            failMsgMapper.insert(failMsg);
        } else {
            failMsgMapper.updateById(failMsg);
        }
    }


    @Override
    public void save(String id, String exchange, String routingKey, Object msg, Integer delay, Integer nextFetchTime, String failMessage) {
        //如果id为空则用雪花算法生成id
        if (StrUtil.isBlank(id)) {
            id = IdUtil.getSnowflakeNextIdStr();
        }
        //更新下次执行时间
        FailMsg failMsg = FailMsg.builder().id(id)
                .exchange(exchange)
                .routingKey(routingKey)
                .msg(JsonUtils.toJsonStr(msg))
                .delayMsgExecuteTime(DateUtils.getCurrentTime() + (delay!=null?delay:0))
                .nextFetchTime(nextFetchTime)
                .reason(failMessage)
                .createTime(LocalDateTime.now())
                .build();

        failMsgMapper.insert(failMsg);
    }


    @Override
    public List<FailMsg> fetch(Integer limit) {

        List<FailMsg> failMsgs = failMsgMapper.fetch(DateUtils.getCurrentTime(), 100);
        if (CollUtils.isNotEmpty(failMsgs)) {
            failMsgMapper.batchUpdateExecuteTime(10, failMsgs.stream().map(FailMsg::getId).collect(Collectors.toList()));
        }
        return failMsgs;
    }

    /**
     * 根据id删除
     *
     * @param id 失败消息id
     */
    @Override
    public void removeById(String id) {
        failMsgMapper.deleteById(id);
    }
}
