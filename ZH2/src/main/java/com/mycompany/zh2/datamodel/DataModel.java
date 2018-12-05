/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zh2.datamodel;

import com.mycompany.zh2.model.HeroLevel;
import com.mycompany.zh2.service.HeroLevelServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Boldi
 */
@ManagedBean(name = "datamodel")
@SessionScoped
public class DataModel {
    
    private static int id = 100;
    private ArrayList<HeroLevel> allLevel;
    private HeroLevel heroLevel;
    
    @Inject
    HeroLevelServiceImpl HeroLevelService;

    public DataModel(){
        allLevel = new ArrayList<>();
    }
    
    /**
     * @return the accessories
     */
    public ArrayList<HeroLevel> getAccessories() {
        return allLevel;
    }
    
    @PostConstruct
    public void init(){
        heroLevel = new HeroLevel();
    }
    
    public String submit(){
        heroLevel.setId(id);
        id++;
        HeroLevelService.create(heroLevel);
        heroLevel = new HeroLevel();
        return "index";
    }

    /**
     * @return the accessory
     */
    public HeroLevel getAccessory() {
        return heroLevel;
    }
    
    public List<HeroLevel> test() {
       
     //VehicleAccessoryDaoImpl dao = new VehicleAccessoryDaoImpl();
     //List<VehicleAccessory> lista = accessoryService.getAll();     
     List<HeroLevel> lista = HeroLevelService.getAll();
     return lista;
    }
    
}

