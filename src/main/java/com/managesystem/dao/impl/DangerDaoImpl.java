package com.managesystem.dao.impl;

import com.managesystem.dao.DangerDao;
import com.managesystem.model.Danger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristph on 2016/11/6.
 */


@Repository
public class DangerDaoImpl implements DangerDao {

    @Resource
    protected SessionFactory sessionFactory;


    @Override
    public void save(Danger danger) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(danger);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public List<Danger> getDangerList(String tracer) {
        Session session=sessionFactory.openSession();
        String hql="from Danger where tracer=?";
        Query query=session.createQuery(hql);
        query.setString(0,tracer);
        List list=query.list();
        if(list.size()>0){
            return (List<Danger>)list;
        }
        return new ArrayList<Danger>();
    }

    @Override
    public List<Danger> getPostedDangerList(String poster) {
        Session session=sessionFactory.openSession();
        String hql="from Danger where poster=?";
        Query query=session.createQuery(hql);
        query.setString(0,poster);
        List list=query.list();
        if(list.size()>0){
            return (List<Danger>)list;
        }
        return new ArrayList<Danger>();
    }

    @Override
    public Danger get(int did) {
        Session session=sessionFactory.openSession();
        String hql="from Danger where did=?";
        Query query=session.createQuery(hql);
        query.setInteger(0,did);
        if(query.list().size()>0){
            Danger danger=(Danger)query.list().get(0);
            return danger;
        }
        return null;
    }

    @Override
    public void update(int did, String condespt, String desp) {
        Session session=sessionFactory.openSession();
        String hql="Update Danger set conditiondescription=? , description=? where did=?";
        Query query=session.createQuery(hql);
        query.setString(0,condespt);
        query.setString(1,desp);
        query.setInteger(2,did);
        query.executeUpdate();
    }

}
