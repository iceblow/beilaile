package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.FactoryBacklog;

    /**
     * Created by admin on 2017/1/10.
     */
    public interface FactoryBacklogService {


        // 带条件查询总条数
        int getFactoryBacklogByPageCount(Map<String, Object> anyVal);

        // 带条件分页查询
        List<FactoryBacklog> findConditionFactoryBacklogByPage(Map<String, Object> anyVal);

        // 修改获取数据根据id
        FactoryBacklog getFactoryBacklogById(@Param("id") Integer id);

        FactoryBacklog confirmBacklogCompleted(Integer amId, HttpServletRequest request);


    }

