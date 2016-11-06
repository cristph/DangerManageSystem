package com.managesystem.dao;

import com.managesystem.model.User;

/**
 * Created by cristph on 2016/11/6.
 */
public interface AuthDao{
    public User get();

    public void save(User u);

    public String isExist(User u);
}
