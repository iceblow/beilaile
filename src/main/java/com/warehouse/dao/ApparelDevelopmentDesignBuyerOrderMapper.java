package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.ApparelDevelopmentDesignBuyerOrder;

public interface ApparelDevelopmentDesignBuyerOrderMapper {

	// 查询总条
	int getPageCount(ApparelDevelopmentDesignBuyerOrder order);
	//删除
	int deleteById(Integer id);
	//添加
    int addApparelDevelopmentDesignBuyerOrder(ApparelDevelopmentDesignBuyerOrder record);
    //查询
    List<ApparelDevelopmentDesignBuyerOrder> select(Map<String, Object> params);
    //修改
    int updateApparelDevelopmentDesignBuyerOrder(ApparelDevelopmentDesignBuyerOrder record);
    //根据id查询
    ApparelDevelopmentDesignBuyerOrder selectById(Integer id);
    //匹配重复订单
    void buyerAndCancel();
}