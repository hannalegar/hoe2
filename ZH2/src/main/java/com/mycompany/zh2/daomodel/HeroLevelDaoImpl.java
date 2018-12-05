/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zh2.daomodel;

import com.mycompany.zh2.model.HeroLevel;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@RequestScoped
public class HeroLevelDaoImpl implements BaseDao<HeroLevel>{
    private static final Logger log = Logger.getLogger("HeroLevelDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("unit").createEntityManager();
 
    public HeroLevelDaoImpl() {log.info("create new instance");}
    
    
    @Override
    public List<HeroLevel> getAll() {
        return em.createNamedQuery("HeroLevel.all").getResultList();
        //return em.createQuery("SELECT u FROM VehicleAccessory u").getResultList();
    }

    @Override
    public HeroLevel getById(long pId) {
        return em.find(HeroLevel.class, pId);
    }

    @Override
    public HeroLevel getByName(String pName) {
        return em.createNamedQuery("HeroLevel.name",HeroLevel.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public HeroLevel create(HeroLevel pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public HeroLevel modify(HeroLevel pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public HeroLevel delete(long pId) {
        HeroLevel vehicleaccessory = getById(pId);
        em.getTransaction().begin();
        em.remove(vehicleaccessory);
        em.getTransaction().commit();
        return vehicleaccessory;
    }
    
}
