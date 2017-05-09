package com.warehouse.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.PieceProcessCase;
import com.warehouse.service.PieceProcessCaseService;
import com.warehouse.util.PageUtil;

/**
 * 片印加工情况
 * @author admin
 *
 */
@Controller
@RequestMapping("pieceProcessCase")
public class PieceProcessCaseController {

	@Autowired
	private PieceProcessCaseService pieceProcessCaseService;
	
	/**
	 * 分页查询控制器
	 * @param pageUtil
	 * @param pieceProcessCase
	 * @return
	 */
	@RequestMapping("getDataByPage")
	@ResponseBody
	public Map<String, Object> getDataByPage(PageUtil pageUtil,PieceProcessCase pieceProcessCase){
		//pieceProcessCase.getPieceOfPrintingOut();
		return this.pieceProcessCaseService.getDataByPage(pageUtil,pieceProcessCase);
	}
	
	/**
	 * 片印领料控制器
	 * @param pieceProcessCase
	 * @return
	 */
	@RequestMapping("pieceOfPrintingOut")
	@ResponseBody
	public int pieceOfPrintingOut(PieceProcessCase pieceProcessCase){
		return this.pieceProcessCaseService.pieceOfPrintingOut(pieceProcessCase);
	}
	
	/**
	 * 片印回料控制器
	 * @param pieceProcessCase
	 * @return
	 */
	@RequestMapping("pieceOfPrintingIn")
	@ResponseBody
	public int pieceOfPrintingIn(PieceProcessCase pieceProcessCase){
		return this.pieceProcessCaseService.pieceOfPrintingIn(pieceProcessCase);
	}
	
}
