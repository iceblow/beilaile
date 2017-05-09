package com.warehouse.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.warehouse.entity.ApparelDevelopmentDesignBuyerOrder;
import com.warehouse.service.ApparelDevelopmentDesignBuyerOrderService;
import com.warehouse.util.Page;

@Controller
@RequestMapping("/ApparelDevelopmentDesignBuyerOrder")
public class ApparelDevelopmentDesignBuyerOrderController {

	@Autowired
	private ApparelDevelopmentDesignBuyerOrderService apparelDevelopmentDesignBuyerOrderService;
	/**
	 * 查询总条数
	 */
	@RequestMapping("/getPageCount.do")
	@ResponseBody
	public Page<ApparelDevelopmentDesignBuyerOrder> getAccessoryMaterialByPageCount(ApparelDevelopmentDesignBuyerOrder order,String pageNow,String pageSize) {
		return apparelDevelopmentDesignBuyerOrderService.getPageCount(order, pageNow, pageSize);
	}
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public int deleteById(ApparelDevelopmentDesignBuyerOrder record) {
		return apparelDevelopmentDesignBuyerOrderService.updateOrderOntForm(record);
	}

	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	@ResponseBody
	public int addApparelDevelopmentDesignBuyerOrder(MultipartFile file1,ApparelDevelopmentDesignBuyerOrder record, HttpServletRequest request) {
		return apparelDevelopmentDesignBuyerOrderService.addApparelDevelopmentDesignBuyerOrder(file1,record,request);
	}

	/**
	 * 查询
	 */
	@RequestMapping("/select.do")
	@ResponseBody
	public List<ApparelDevelopmentDesignBuyerOrder> select(@RequestParam Map<String, Object> map) {
		return apparelDevelopmentDesignBuyerOrderService.select(map);
	}
	
	/**
	 * 修改(提交表单的修改)
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public int updateApparelDevelopmentDesignBuyerOrder(MultipartFile file1,ApparelDevelopmentDesignBuyerOrder record, HttpServletRequest request) {
		return apparelDevelopmentDesignBuyerOrderService.updateApparelDevelopmentDesignBuyerOrder(file1,record,request);
	}
	
	/**
	 * 修改（前段不是提交表单的那种修改，之所以分开写两个修改，是因为有的修改不是提交表单那种，
	 * 如果不分开就报 org.springframework.web.multipart.MultipartException: The current request is not a multipart request] with root cause这个错误）
	 */
	@RequestMapping("/updateontform.do")
	@ResponseBody
	public int updateOrderOntForm(ApparelDevelopmentDesignBuyerOrder record){
		return apparelDevelopmentDesignBuyerOrderService.updateOrderOntForm(record);
	}
	/**
	 * 根据id查询
	 */
	@RequestMapping("/selectById.do")
	@ResponseBody
	public ApparelDevelopmentDesignBuyerOrder selectById(Integer id){
		return apparelDevelopmentDesignBuyerOrderService.selectById(id);
	}
}
