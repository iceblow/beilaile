package com.warehouse.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.ApparelDevelopmentReturn;
import com.warehouse.entity.DistributionProduction;

public interface DistributionProductionService {
	
	
	
	//------2017-04-21修改----------------------------
	//查询总条数
	int selectAllCount(DistributionProduction distributionProduction);
	
	//分页返回到结果
	List<DistributionProduction> getDistributionProductionPage(DistributionProduction distributionProduction);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);
	/**
	 * 添加
	 * @param productImgFile
	 * @param record
	 * @param request
	 * @return
	 */
    int addDistributionProduction(MultipartFile productImgFile,DistributionProduction distributionProduction,HttpServletRequest request);
    /**
     * 查询
     * @param params
     * @return
     */
    int updateDistributionProduction(MultipartFile productImgFile,DistributionProduction distributionProduction, HttpServletRequest request);
    /**
     * 无文件上传的修改
     * @param record
     * @return
     */
    public int updateDistributionProductionForm(DistributionProduction distributionProduction);
    /**
     * 根据id查询
     * @param id
     * @return
     */
    DistributionProduction selectById(Integer id);
    
    // 根据时间生成excel
 	int toExcelNum(DistributionProduction distributionProduction);

 	List<DistributionProduction> toExcel(DistributionProduction distributionProduction);
    
    
}
