/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import java.util.List;

/**
 *
 * @author ASUS
 */
abstract public class QLKSDAO<E,K> {
    abstract public void insert(E entity);
    abstract public void update(E entity);
    abstract public void delete(K key);
    abstract public E selectById(K key);
    abstract public List<E>selectAll();
    abstract protected List<E>selectBySql(String sql, Object...args);
}
