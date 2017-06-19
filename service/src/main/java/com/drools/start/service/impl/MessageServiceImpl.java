package com.drools.start.service.impl;

import com.drools.start.entity.Message;
import com.drools.start.service.IMessageService;
import org.kie.api.cdi.KContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

    @KSession("message_ksession")
    private KieSession ksession;

//    @KSession("message_ksession2")
//    private KieSession ksession2;

//    // 方法二
//    @KContainer
    private KieContainer kContainer;

    public Message handleMessage(Message message) {

//        // 方法二
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

}
