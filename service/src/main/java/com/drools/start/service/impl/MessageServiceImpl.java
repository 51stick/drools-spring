package com.drools.start.service.impl;

import com.drools.start.entity.Message;
import com.drools.start.entity.User;
import com.drools.start.service.IMessageService;
import com.drools.start.service.UserService;
import org.kie.api.cdi.KSession;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements IMessageService {

    @KSession("message_ksession")
    private KieSession ksession;

//    @KSession("message_ksession2")
//    private KieSession ksession2;

//    // 方法二
//    @KContainer
//    private KieContainer kContainer;

    @Autowired
    UserService userService;



    public Message handleMessage(Message message) throws TestException {

        // 方法二
//        KieSession ksession =  kContainer.newKieSession("message_ksession");

        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        ksession.insert(message);
        ksession.fireAllRules();

//        ksession2.addEventListener(new DebugAgendaEventListener());
//        ksession2.addEventListener(new DebugRuleRuntimeEventListener());
//
//        ksession2.insert(message);
//        ksession2.fireAllRules();

        return message;
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    public int test() throws TestException {
        User user = new User();
        user.setAddress("123");
        user.setName("n123");
        user.setAge(2);
        user.setAge(2);
        int count =  userService.insert(user);
        System.out.println("count:" + count);

        User user2 = new User();
        user2.setAddress("123");
        user2.setName(null);
        int count2 =  userService.insert(user2);

        return count;
    }


}
