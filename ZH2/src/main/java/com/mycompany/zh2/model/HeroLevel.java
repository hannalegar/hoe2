/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zh2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(
    name = "heroLevel", 
    indexes = {
        @Index(name = "heroLevel_id", columnList = "id", unique = true),
        @Index(name = "heroLevel_name", columnList = "name", unique = true)     
    })
@NamedQueries({
    @NamedQuery(name = "HeroLevel.all", query = "SELECT u FROM VehicleAccessory u "),
    @NamedQuery(name = "HeroLevel.name", query = "SELECT u FROM VehicleAccessory u WHERE u.name=:name ")
})
public class HeroLevel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "fromLevel")
    private int fromlevel;
    @Column(name = "untilLevel")
    private int untilLevel;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the fromlevel
     */
    public int getFromlevel() {
        return fromlevel;
    }

    /**
     * @param fromlevel the fromlevel to set
     */
    public void setFromlevel(int fromlevel) {
        this.fromlevel = fromlevel;
    }
    
    /**
     * @return the untilLevel
     */
    public int getUntillevel() {
        return untilLevel;
    }

    /**
     * @param untilLevel the untilLevel to set
     */
    public void setUntillevel(int untilLevel) {
        this.untilLevel = untilLevel;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HeroLevel)) {
            return false;
        }
        HeroLevel other = (HeroLevel) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
