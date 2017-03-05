package com.myhexin.service.impl;

import com.myhexin.entity.Message;
import com.myhexin.service.IMessageService;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

    @KSession("message_ksession")
    private KieSession kSessions;

    public void sendMsg() {

        Message message = new Message();
        message.setMessage("test message");
        message.setStatus(Message.HELLO);
//
//        System.out.println("====Message.message=" + message.getMessage());
//        System.out.println("====Message.status =" + message.getStatus());
//
//        KieServices ks = KieServices.Factory.get();
//
//        //工作kieService加载默认路径下的kmodule.xml 得到kContainer场所
//        KieContainer kContainer = ks.getKieClasspathContainer();
//
//        //kContainer得到一个会话
//        KieSession kSession = kContainer.newKieSession("ksession-rules");

        if (null != kSessions) {
            System.out.println("spring drools successed");
        }

        kSessions.insert(message);
        kSessions.fireAllRules();
    }

}
