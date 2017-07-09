package com.drools.start.service.impl;

import com.drools.start.entity.Book;
import com.drools.start.service.BookService;
import org.kie.api.cdi.KSession;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @KSession("book_price_ksession")
    private KieSession ksession;

    public double getBookSalePrice(Book book) {
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        if (book == null) {
            throw new NullPointerException("Book can not be null.");
        }

        ksession.insert(book);
        ksession.fireAllRules();

        return book.getSalesPrice();
    }
}
