/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zh2.service;

import java.util.List;

public interface BaseService<T> {
    public List<T> getAll();
    public T getById(long pId);
    public T create(T pData) throws BusinessException;
    public T modify(long pId,T pData) throws BusinessException;
    public T delete(long pId);    
    
}
