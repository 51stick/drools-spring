package com.myhexin.web;

import com.myhexin.service.IMessageService;
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
     * 购买一本书
     *
     * @return
     */
    @RequestMapping(value = "/send")
    @ResponseBody
    public void orderOneBook() {
        System.out.println("=======MessageController=============");

        messageService.sendMsg();
    }
}
