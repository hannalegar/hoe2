/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zh2.service;

import com.mycompany.zh2.daomodel.HeroLevelDaoImpl;
import com.mycompany.zh2.model.HeroLevel;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@ApplicationScoped
public class HeroLevelServiceImpl implements BaseService<HeroLevel>{
    private static final Logger log = Logger.getLogger("HeroLevelDaoImpl");

    @Inject
    protected HeroLevelDaoImpl dao;

    public HeroLevelServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<HeroLevel> getAll() {return dao.getAll();}

    @Override
    public HeroLevel getById(long pId) {return dao.getById(pId);}


    @Override
    public HeroLevel create(HeroLevel pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public HeroLevel modify(long pId, HeroLevel pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            HeroLevel species = dao.getById(pId);
            if(pData.getName()!=null) species.setName(pData.getName());
            return dao.modify(species);
        }
    }

    @Override
    public HeroLevel delete(long pId) {
        return dao.delete(pId);
    }
 
}

