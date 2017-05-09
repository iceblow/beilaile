package com.warehouse.dao;

/**
 * Created by admin on 2017/1/17.
 */


import com.warehouse.entity.FactoryBacklog;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
public interface FactoryBacklogMapper {


    // 带条件查询总条数
    int getFactoryBacklogByPageCount(Map<String, Object> anyVal);

    // 带条件分页查询
    List<FactoryBacklog> findConditionFactoryBacklogByPage(Map<String, Object> anyVal);

    // 修改获取数据根据id
    FactoryBacklog getFactoryBacklogById(@Param("id") Integer id);


    int updateBacklogCompletionStatus(FactoryBacklog factoryBacklog);
}
