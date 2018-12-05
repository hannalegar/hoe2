/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zh2.daomodel;

import java.util.List;

public interface BaseDao<T> {
    public List<T> getAll();
    public T getById(long pId);
    public T getByName(String pName);
    public T create(T pData);
    public T modify(T pData);
    public T delete(long pId);    
    
}
