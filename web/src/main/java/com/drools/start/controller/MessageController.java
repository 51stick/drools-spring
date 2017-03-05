package com.drools.start.controller;

import com.drools.start.entity.Message;
import com.drools.start.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    /**
     * 处理消息
     *
     * @return
     */
    @RequestMapping(value = "/handle")
    @ResponseBody
    public Message handleMessage() {

        Message message = new Message();
        message.setStatus(Message.HELLO);
        message.setMessage("This is a init message");

        return messageService.handleMessage(message);
    }
}
