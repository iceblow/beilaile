package com.warehouse.dao;

import com.warehouse.entity.Etrack;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface EtrackDao {
    List<Etrack> queryEtrack();
    int exportEtrack(List<Etrack> etrack);
    Etrack findById(int id);
}
