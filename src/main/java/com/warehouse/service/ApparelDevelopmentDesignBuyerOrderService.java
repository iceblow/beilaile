package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.ApparelDevelopmentDesignBuyerOrder;
import com.warehouse.util.Page;

public interface ApparelDevelopmentDesignBuyerOrderService {
	//查询总条数
	Page<ApparelDevelopmentDesignBuyerOrder> getPageCount(ApparelDevelopmentDesignBuyerOrder order,String pageNow,String pageSize);
	//删除
	int deleteById(Integer id);
	//添加
    int addApparelDevelopmentDesignBuyerOrder(MultipartFile file1,ApparelDevelopmentDesignBuyerOrder record,HttpServletRequest request);
    //查询
    List<ApparelDevelopmentDesignBuyerOrder> select(Map<String, Object> params);
    //修改
    int updateApparelDevelopmentDesignBuyerOrder(MultipartFile file1,ApparelDevelopmentDesignBuyerOrder record, HttpServletRequest request);
    //无文件上传的修改
    public int updateOrderOntForm(ApparelDevelopmentDesignBuyerOrder record);
    //根据id查询
    ApparelDevelopmentDesignBuyerOrder selectById(Integer id);
}
