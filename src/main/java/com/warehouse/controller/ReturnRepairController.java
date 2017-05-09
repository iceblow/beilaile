package com.warehouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ReturnRepair;
import com.warehouse.entity.ReturnRepairDoucuments;
import com.warehouse.service.ReturnRepairDoucumentsService;
import com.warehouse.service.ReturnRepairService;
import com.warehouse.util.CharacterUtils;
import com.warehouse.util.FileUpload;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("ReturnRepair")
public class ReturnRepairController {
	
@Resource
private ReturnRepairService returnrepairdoucumentsService;

private Logger log = LoggerFactory.getLogger(InputStorageController.class);
/**
 * 添加
 * 
 * @param returnrepairdoucuments
 * @return
 */
	@RequestMapping("addReturnRepairDoucuments")
	@ResponseBody
	public int addReturnRepairDoucuments(ReturnRepair retur){
	int flag = 0;
	//总量
	Integer count = retur.getCode100()+retur.getCode110()+retur.getCode120()+retur.getCode130()+retur.getCode160()
					+retur.getCode170()+retur.getCode52()+retur.getCode59()+retur.getCode66()+retur.getCode73()
					+retur.getCode80()+retur.getCode90();
	retur.setTotal(count);
//	String imageUrl = "";
//	if (!imageFile.isEmpty()) {
//		imageUrl = FileUpload.addFilePath(imageFile, request, folderNmae,
//				CharacterUtils.getUpperCase(boardRoom.getWave()));
//	}
	if(retur.getGirard()==""){
		return 0;
	}else if( this.returnrepairdoucumentsService.girardcount(retur.getGirard())>0){
		return 10;
	}	
	flag = this.returnrepairdoucumentsService.insert(retur);
	log.debug("添加返修开单");
	return flag;		
	}
	/**
	 * 删除
	 * 
	 * @param returnrepairdoucuments
	 * @return
	 */
	@RequestMapping("deleteReturnRepairDoucuments")
	@ResponseBody
	public int deleteReturnRepairDoucuments(ReturnRepair record){
		int flag = 0;
		flag=this.returnrepairdoucumentsService.deleteByPrimaryKey(record);
		log.debug("删除返修入库");
		return flag;		
	}
	
	/**
	 * 修改前查询
	 * 
	 * @param returnrepairdoucuments
	 * @return
	 */
	@RequestMapping("selectByPrimaryKey")
	@ResponseBody
	public ReturnRepair selectByPrimaryKey(Integer sid){
		ReturnRepair retur = this.returnrepairdoucumentsService.selectByPrimaryKey(sid);
		return retur;	
	}
	
	/**
	 * 查询波次号是否重复
	 * 
	 * @param returnrepairdoucuments
	 * @return
	 */
	@RequestMapping("selectBygirard")
	@ResponseBody
	public int selectByWave(String girard){
		int retur = this.returnrepairdoucumentsService.girardcount(girard);
		return retur;	
	}
	
	
	/**
	 * 修改
	 * 
	 * @param returnrepairdoucuments
	 * @return
	 */
	@RequestMapping("updateReturnRepairDoucuments")
	@ResponseBody
	public int updateReturnRepairDoucuments(ReturnRepair retur){
	
		Integer count = retur.getCode100()+retur.getCode110()+retur.getCode120()+retur.getCode130()+retur.getCode160()
		+retur.getCode170()+retur.getCode52()+retur.getCode59()+retur.getCode66()+retur.getCode73()
		+retur.getCode80()+retur.getCode90();
		retur.setTotal(count);
		int flag  = this.returnrepairdoucumentsService.updateByPrimaryKeySelective(retur);
		log.debug("修改返修入库");
		return flag;		
	}
	
	/**
	 * 模糊查询
	 * 
	 * @param returnrepairdoucuments
	 * @return
	 */
	@RequestMapping("bylikeReturnRepairDoucuments")
	@ResponseBody
	public Map<String, Object> bylikeReturnRepairDoucuments(ReturnRepair retur, PageUtil page){
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);// 每页显示的数据量
		page.setTotolCount(this.returnrepairdoucumentsService.getCountByOutsideLike(retur));// 总共有多少条数据
		// map对象中存的数据
		List<ReturnRepair> returnrepairdoucuments = this.returnrepairdoucumentsService
				.ReturnRepairDoucumentsbylike((new ReturnRepair(page.getReqult()[0]
				,page.getReqult()[1]
				,retur.getVendorCode()
				,retur.getCommoditycCode()
				,retur.getGirard(),retur.getFactory())));
		map.put("pageUtil", page); // 在map中写入数据对象
		map.put("dataList",returnrepairdoucuments);
		log.info("查看返修入库信息");
		return map;
		
	}
}
