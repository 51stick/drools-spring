package com.drools.start.controller;

import com.drools.start.entity.Book;
import com.drools.start.entity.Message;
import com.drools.start.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 处理消息
     *
     * @return
     */
    @RequestMapping(value = "/price")
    @ResponseBody
    public Book handleBookPrice() {
        Book book = new Book();
        book.setBasePrice(120.50);
        book.setClz("computer");
        book.setName("C plus programing");
        book.setSalesArea("China");
        book.setYears(2);

        bookService.getBookSalePrice(book);

        return book;
    }
}
