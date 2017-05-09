package com.warehouse.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.DistributeDetailedOrder;
import com.warehouse.entity.GetEmbroider;
import com.warehouse.entity.PiecesInformation;
import com.warehouse.entity.PrintMarkOrder;
import com.warehouse.service.DistributeDetailedOrderService;
import com.warehouse.service.GetEmbroiderService;
import com.warehouse.service.PiecesInformationService;
import com.warehouse.service.PrintMarkOrderService;
import com.warehouse.util.PageUtil;

@RequestMapping("printMarkOrder")
@Controller
public class PrintMarkOrderController {

	private Logger log = LoggerFactory.getLogger(PrintMarkOrderController.class);
	@Resource
	private PrintMarkOrderService printMarkOrderService;
	@Resource
	private DistributeDetailedOrderService detailedOrderService;
	@Resource
	private GetEmbroiderService getEmbroiderService;
	@Resource
	private PiecesInformationService informationService;

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");

	/**
	 * 分页查询
	 * 
	 * @param record
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("printMarkOrderBypage")
	public Map<String, Object> printMarkOrderBypage(PrintMarkOrder record, PageUtil page) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);
		page.setTotolCount(this.printMarkOrderService.selectByCount(record));
		List<PrintMarkOrder> piecesInformations = this.printMarkOrderService.selectByPage(
				new PrintMarkOrder(page.getReqult()[0], page.getReqult()[1], record.getPrintingFactory()));
		map.put("dataList", piecesInformations);
		map.put("pageUtil", page);
		return map;
	}

	/**
	 * 添加工厂
	 * 
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addPrintMarkOrder")
	public int addPrintMarkOrder(PrintMarkOrder record) {
		int flag = 0;
		record.setAddTime(sdf.format(new Date()));// 添加时间
		flag = this.printMarkOrderService.insertSelective(record);
		log.debug("添加领料工厂");
		return flag;
	}

	/**
	 * 打单
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping("detailedOrders")
	@ResponseBody
	public List<DistributeDetailedOrder> detailedOrders(Integer orderId) {
		List<DistributeDetailedOrder> detailedOrders = this.detailedOrderService.selectByorderId(orderId);
		PrintMarkOrder markOrder = this.printMarkOrderService.selPrintByID(orderId);
		markOrder.setOrderStatus("2");// 打单状态值
		uppStatus(markOrder);// 打单
		log.debug("打印工厂领料单");
		return detailedOrders;
	}

	/**
	 * 打单/发料/撤销
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("uppStatus")
	@ResponseBody
	public int uppStatus(PrintMarkOrder record) {
		int flag = 0;
		if ("2".equals(record.getOrderStatus())) {
			record.setOrderTime(sdf.format(new Date()));// 打单
			print(record.getOrderId());
		} else if ("3".equals(record.getOrderStatus())) {
			record.setDeliveryTime(sdf.format(new Date()));// 发料
			delivery(record.getOrderId());
		} else if ("4".equals(record.getOrderStatus())) {
			record.setRevokedTime(sdf.format(new Date()));// 撤回
			revoked(record.getOrderId());
		}
		flag = this.printMarkOrderService.updateByPrimaryKeySelective(record);
		return flag;
	}

	/**
	 * 撤销
	 * 
	 * @param orderId
	 */
	private void revoked(Integer orderId) {
		// 获取片印领料数据
		List<GetEmbroider> getEmbroiders = this.getEmbroiderService.selEmbroider(orderId);
		for (int i = 0; i < getEmbroiders.size(); i++) {
			getEmbroiders.get(i).setDelb(1);// 设置状态值为1(删除)
			getEmbroiderService.updateEmbroider(getEmbroiders.get(i));// 修改状态值
		}
		// 片印信息
		List<PiecesInformation> informations = this.informationService.selInformation(orderId);
		for (int i = 0; i < informations.size(); i++) {
			informations.get(i).setStatus("0");
			informationService.uppPiecesInformation(informations.get(i));
		}
		// 片印详单表
		List<DistributeDetailedOrder> detailedOrders = this.detailedOrderService.selectByorderId(orderId);
		for (int i = 0; i < detailedOrders.size(); i++) {
			detailedOrders.get(i).setStatus("1");
			detailedOrderService.updateByPrimaryKeySelective(detailedOrders.get(i));
		}
		log.debug("撤销工厂领料订单");
	}

	/**
	 * 打单
	 * 
	 * @param orderId
	 */
	private void print(Integer orderId) {
		// 片印信息
		List<PiecesInformation> informations = this.informationService.selInformation(orderId);
		for (int i = 0; i < informations.size(); i++) {
			informations.get(i).setStatus("2");
			informationService.uppPiecesInformation(informations.get(i));
		}
		log.debug("更改片印信息表的状态值");
	}

	/**
	 * 发料
	 * 
	 * @param orderId
	 */
	private void delivery(Integer orderId) {
		// 片印信息
		List<PiecesInformation> informations = this.informationService.selInformation(orderId);
		for (int i = 0; i < informations.size(); i++) {
			informations.get(i).setStatus("3");
			informationService.uppPiecesInformation(informations.get(i));
		}
		// 片印详单表
		List<DistributeDetailedOrder> detailedOrders = this.detailedOrderService.selectByorderId(orderId);
		for (int i = 0; i < detailedOrders.size(); i++) {
			detailedOrders.get(i).setStatus("2");
			detailedOrderService.updateByPrimaryKeySelective(detailedOrders.get(i));
		}
		log.debug("改变片印信息和详单的状态！");
	}

	/**
	 * 双击修改
	 * 
	 * @param detailedOrder
	 * @return
	 */
	@RequestMapping("dbuppPrintMarkOrder")
	@ResponseBody
	public int dbuppPrintMarkOrder(PrintMarkOrder markOrder) {
		int flag = 0;
		flag = this.printMarkOrderService.updateByPrimaryKeySelective(markOrder);
		log.debug("双击修改工厂领料信息（备注）");
		return flag;
	}

}
