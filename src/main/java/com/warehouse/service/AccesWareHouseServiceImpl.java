package com.warehouse.service;

import com.warehouse.dao.AccesWareHouseMapper;
import com.warehouse.entity.AccesWareHouse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by chiayich on 2017/1/20.
 *
 */
@Service
public class AccesWareHouseServiceImpl implements AccesWareHouseService {

    @Resource
    private AccesWareHouseMapper accesWareHouseMapper;

    @Override
    public int getAccesWareHouseBpcnt(Map<String, Object> param) {
        int countNum = accesWareHouseMapper.getAccesWareHouseBpcnt(param);
        return countNum;
    }

    @Override
    public List<AccesWareHouse> findAccesWareHouseCndbp(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesWareHouse> list = accesWareHouseMapper.findAccesWareHouseCndbp(param);
        return list;
    }

    @Override
    public AccesWareHouse getAccesWareHouseBid(Integer id, HttpServletRequest request) {
        AccesWareHouse accesWareHouse = accesWareHouseMapper.selectByPrimaryKey(id);
        return accesWareHouse;
    }


}
