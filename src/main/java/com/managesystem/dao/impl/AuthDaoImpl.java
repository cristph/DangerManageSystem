package com.managesystem.dao.impl;

import com.managesystem.dao.AuthDao;
import com.managesystem.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2016/11/6.
 */
@Repository
public class AuthDaoImpl implements AuthDao{
    @Resource
    protected SessionFactory sessionFactory;

    @Override
    public User get() {
        Session session=sessionFactory.openSession();
        String hql="from User where  uid=?";
        Query query=session.createQuery(hql);
        query.setInteger(0,1);
        if(query.list().size()>0){
            List list=query.list();
            User user=(User) list.get(0);
            System.out.println(user.toString());
            return user;
        }
        return null;
    }

    @Override
    public void save(User u) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(u);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public String isExist(User u) {
        Session session=sessionFactory.openSession();
        String hql="from User where name=? and pswd=? and identity=?";
        Query query=session.createQuery(hql);
        query.setString(0,u.getName());
        query.setString(1,u.getPswd());
        query.setString(2,u.getIdentity());
        if(query.list().size()>0){
            return "true";
        }
        return "false";
    }
}
