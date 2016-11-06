package com.managesystem.service.impl;

import com.managesystem.dao.AuthDao;
import com.managesystem.model.User;
import com.managesystem.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by cristph on 2016/11/6.
 */

@Transactional
@Service("authService")
public class AuthServiceImpl implements AuthService{

    @Resource
    AuthDao authDao;

    @Override
    public User get() {
        return authDao.get();
    }

    @Override
    public void save(User u) {
        authDao.save(u);
    }

    @Override
    public String isExist(User u) {
        return authDao.isExist(u);
    }
}
