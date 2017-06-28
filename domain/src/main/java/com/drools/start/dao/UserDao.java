package com.drools.start.dao;

import com.drools.start.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
public interface UserDao {

    int insert(User user);

    List<User> listUser();
}
