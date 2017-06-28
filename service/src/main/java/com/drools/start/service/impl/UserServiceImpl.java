package com.drools.start.service.impl;

import com.drools.start.dao.UserDao;
import com.drools.start.entity.User;
import com.drools.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    public int insert(User user) {
        return userDao.insert(user);
    }

    public List<User> listUser() {
        return userDao.listUser();
    }

}
