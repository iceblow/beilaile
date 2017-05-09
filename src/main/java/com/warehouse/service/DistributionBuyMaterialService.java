package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.DistributionBuyMaterial;

public interface DistributionBuyMaterialService {
	/**
	 * 查询总条数
	 * @param order
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	int getPageCount(Map<String, Object> param);

	/**
	 * 添加
	 * @param productImgFile
	 * @param record
	 * @param request
	 * @return
	 */
    int addDistributionBuyMaterial(MultipartFile productImgFile,DistributionBuyMaterial DistributionBuyMaterial,HttpServletRequest request);
    /**
     * 查询
     * @param params
     * @return
     */
    List<DistributionBuyMaterial> select(Map<String, Object> params);
    /**
     * 修改
     * @param productImgFile
     * @param record
     * @param request
     * @return
     */
    int updateDistributionBuyMaterial(MultipartFile productImgFile,DistributionBuyMaterial DistributionBuyMaterial, HttpServletRequest request);
    /**
     * 无文件上传的修改
     * @param record
     * @return
     */
    public int updateDistributionBuyMaterialForm(DistributionBuyMaterial DistributionBuyMaterial);
    
}
