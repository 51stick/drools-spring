package com.drools.start.service;

import com.drools.start.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
public interface UserService {

    int insert(User user);

    List<User> listUser();

}
