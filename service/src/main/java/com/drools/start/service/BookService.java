package com.drools.start.service;

import com.drools.start.entity.Book;

/**
 * Created by hcb on 2017-7-9.
 */
public interface BookService {

    /**
     * 获取图书售卖价格
     * @param book
     * @return
     */
    double getBookSalePrice(Book book);

}
