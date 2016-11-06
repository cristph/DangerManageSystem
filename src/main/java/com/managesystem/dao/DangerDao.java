package com.managesystem.dao;

import com.managesystem.model.Danger;

import java.util.List;

/**
 * Created by cristph on 2016/11/6.
 */
public interface DangerDao {

    public void save(Danger danger);

    public List<Danger> getDangerList(String tracer);

    public List<Danger> getPostedDangerList(String poster);

    public Danger get(int did);

    public void update(int did,String condespt,String desp);
}
