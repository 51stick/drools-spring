package com.drools.start.service;


import com.drools.start.entity.Message;

public interface IMessageService {

    /**
     * 消息处理
     *
     * @param message
     * @return
     */
    Message handleMessage(Message message);

}
