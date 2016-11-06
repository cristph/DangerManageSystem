package com.managesystem.service.impl;

import com.managesystem.dao.DangerDao;
import com.managesystem.model.Danger;
import com.managesystem.service.DangerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2016/11/6.
 */

@Transactional
@Service("dangerService")
public class DangerServiceImpl implements DangerService{

    @Resource
    DangerDao dangerDao;

    @Override
    public void save(Danger danger) {
        dangerDao.save(danger);
    }

    @Override
    public List<Danger> getDangerList(String tracer) {
        return dangerDao.getDangerList(tracer);
    }

    @Override
    public Danger get(int did) {
        return dangerDao.get(did);
    }

    @Override
    public void update(int did, String condespt, String desp) {
        dangerDao.update(did,condespt,desp);
    }

    @Override
    public List<Danger> getPostedDangerList(String poster) {
        return dangerDao.getPostedDangerList(poster);
    }
}
