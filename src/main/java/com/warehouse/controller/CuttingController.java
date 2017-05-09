package com.warehouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.Cutting;
import com.warehouse.service.CuttingService;
import com.warehouse.util.PageUtil;
import com.warehouse.util.Pagess;

/**
 * 裁床日报表的后台方法
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/cutting")
public class CuttingController {

	@Autowired
	private CuttingService cuttingService;
	private final Logger logger = LoggerFactory.getLogger(CuttingController.class);

	// 2.添加
	@RequestMapping("/add")
	public String add(Cutting cut) {

		// 如果传入的一些数据为空值需要在后台将他们改为0
		if (cut.getS52() == null) {
			cut.setS52(0);
		}
		if (cut.getS59() == null) {
			cut.setS59(0);
		}
		if (cut.getS66() == null) {
			cut.setS66(0);
		}
		if (cut.getS73() == null) {
			cut.setS73(0);
		}
		if (cut.getS80() == null) {
			cut.setS80(0);
		}
		if (cut.getS90() == null) {
			cut.setS90(0);
		}
		if (cut.getS100() == null) {
			cut.setS100(0);
		}
		if (cut.getS110() == null) {
			cut.setS110(0);
		}
		if (cut.getS120() == null) {
			cut.setS120(0);
		}
		if (cut.getS130() == null) {
			cut.setS130(0);
		}
		if (cut.getS160() == null) {
			cut.setS160(0);
		}
		if (cut.getS170() == null) {
			cut.setS170(0);
		}
		if (cut.getOneCursumption().length() == 0) {
			cut.setOneCursumption("0");
		}

		// 此处计算总量
		int number = cut.getS52() + cut.getS59() + cut.getS66() + cut.getS73() + cut.getS80() + cut.getS90() + cut.getS100()
				+ cut.getS110() + cut.getS120() + cut.getS130() + cut.getS160() + cut.getS170();
		cut.setNum(number);

		// 执行添加方法
		this.cuttingService.add(cut);

		logger.info("裁床日报表:添加-" + cut.toString());

		return "redirect:" + "/cuttingMain.html";// 添加成功,返回主页面
	}

	// 3.修改信息
	@RequestMapping("update")
	public String update(Cutting cut) {

		// 如果传入的一些数据为空值需要在后台将他们改为0
		if (cut.getS52() == null) {
			cut.setS52(0);
		}
		if (cut.getS59() == null) {
			cut.setS59(0);
		}
		if (cut.getS66() == null) {
			cut.setS66(0);
		}
		if (cut.getS73() == null) {
			cut.setS73(0);
		}
		if (cut.getS80() == null) {
			cut.setS80(0);
		}
		if (cut.getS90() == null) {
			cut.setS90(0);
		}
		if (cut.getS100() == null) {
			cut.setS100(0);
		}
		if (cut.getS110() == null) {
			cut.setS110(0);
		}
		if (cut.getS120() == null) {
			cut.setS120(0);
		}
		if (cut.getS130() == null) {
			cut.setS130(0);
		}
		if (cut.getS160() == null) {
			cut.setS160(0);
		}
		if (cut.getS170() == null) {
			cut.setS170(0);
		}
		if (cut.getOneCursumption().length() == 0) {
			cut.setOneCursumption("0");
		}

		
		// 此处计算总量
		int number = cut.getS52() + cut.getS59() + cut.getS66() + cut.getS73() + cut.getS80() + cut.getS90() + cut.getS100()
		+ cut.getS110() + cut.getS120() + cut.getS130() + cut.getS160() + cut.getS170();
		cut.setNum(number);
		// 执行修改方法
		this.cuttingService.update(cut);

		logger.info("裁床日报表:修改-" + cut.toString());

		return "redirect:" + "/cuttingMain.html";// 返回添加成功页面
	}

	// 4.所有数据量的分页查询
	@RequestMapping(value = "/getAllByPage")
	@ResponseBody
	public Map<String, Object> getAllByPage(PageUtil page) {
		// 分页查询所有的裁床日报表
		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(10);// 每页显示的数据量
		page.setTotolCount(this.cuttingService.getCutCounts());// 总共有多少条数据

		// map对象中存的数据
		List<Cutting> cutList = this.cuttingService.getAllByPage(new Pagess(page.getReqult()[0], page.getReqult()[1]));
		// 在map中写入分页对象
		map.put("pageUtil", page);
		// 在map中写入数据对象
		map.put("dataList", cutList);

		return map;

	}

	// 5.删除某条信息
	@RequestMapping("del")
	public String del(int id) {

		// 根据id删除某条数据
		this.cuttingService.delCut(id);

		return "redirect:" + "/cuttingMain.html";// 返回添加成功页面
	}

	// 6.根據傳入bid的條件查詢
	@RequestMapping("getAllByBid")
	@ResponseBody
	public Map<String, Object> getAllByBid(PageUtil page, Cutting cutting) {

		// System.out.println("需要查詢的Bid" + bid);

		// 传送至前台的map对象
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(10);// 每页显示的数据量
		page.setTotolCount(this.cuttingService.getCutCountByBid(cutting));//

		// map对象中存的数据
		List<Cutting> cutList = this.cuttingService
				.getAllByBid(new Cutting(page.getReqult()[0], page.getReqult()[1], cutting));
		// 在map中写入分页对象
		map.put("pageUtil", page);
		// 在map中写入数据对象
		map.put("dataList", cutList);

		return map;
	}

	/**
	 * 根据id查询单条数据
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("getOne")
	@ResponseBody
	public Cutting getOne(int id) {

		Cutting cutting = this.cuttingService.getOne(id);

		return cutting;
	}

	/**
	 * 完成方法
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("complete")
	@ResponseBody
	public int complete(int id) {
		return this.cuttingService.complete(id);
	}

	/**
	 * 导出信息成excle表格
	 * 
	 * @param cutting(导出信息的条件)
	 * @return
	 */
	public int exportExcle(Cutting cutting) {

		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = workbook.createSheet("裁床数据");
		sheet.createRow(0).setHeight((short) (20 * 20));
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = workbook.createCellStyle();
		// style.set
		// 第五步，写入实体数据 实际应用中这些数据从数据库得到
		// 选择下载路径弹出框
		return 1;
	}

}
