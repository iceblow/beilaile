package com.warehouse.controller;

import java.text.ParseException;
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

import com.warehouse.entity.OutsideDaily;
import com.warehouse.entity.SewingFactoryPickingOrder;
import com.warehouse.entity.SewingInformation;
import com.warehouse.entity.SewingPickingOrder;
import com.warehouse.service.OutsideDailyService;
import com.warehouse.service.SewingFactoryPickingOrderService;
import com.warehouse.service.SewingInformationService;
import com.warehouse.service.SewingPickingOrderService;
import com.warehouse.util.PageUtil;

@RequestMapping("SewingPickingOrder")
@Controller
public class SewingPickingOrderControll {

	@Resource
	private SewingPickingOrderService pickingOrderService;
	@Resource
	private SewingFactoryPickingOrderService factoryPickingOrderService;
	@Resource
	private SewingInformationService informationService;
	@Resource
	private OutsideDailyService dailyService;

	private Logger log = LoggerFactory.getLogger(SewingInformationController.class);

	/**
	 * 查询裁床工厂信息
	 * 
	 * @param record
	 * @param page
	 * @return
	 */
	@RequestMapping("selSewingPickingOrder")
	@ResponseBody
	public Map<String, Object> selSewingPickingOrder(SewingPickingOrder record, PageUtil page) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageSize(15);
		page.setTotolCount(this.pickingOrderService.getCountBySewing(record));
		List<SewingPickingOrder> pickingOrders = this.pickingOrderService.selectByPrimaryKey(
				new SewingPickingOrder(page.getReqult()[0], page.getReqult()[1], record.getSewingFactory()));
		map.put("pageUtil", page);
		map.put("dataList", pickingOrders);
		return map;
	}

	/**
	 * 新增工厂
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("addSewingPickingOrder")
	@ResponseBody
	public int addSewingPickingOrder(SewingPickingOrder record) {
		int flag = 0;
		flag = this.pickingOrderService.insertSelective(record);
		log.debug("添加裁床工厂信息");
		return flag;
	}

	/**
	 * 打单/发料/撤销
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("uppSewingPickingOrder")
	@ResponseBody
	public int uppSewingPickingOrder(SewingPickingOrder record) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		int flag = 0;
		if (record.getOrderStatus().equals("2")) {
			record.setOrderTime(sdf.format(new Date()));
			print(record.getOrderId());
		} else if (record.getOrderStatus().equals("3")) {
			record.setDeliveryTime(sdf.format(new Date()));
			delivery(record.getOrderId());
		} else if (record.getOrderStatus().equals("4")) {
			record.setRevokedTime(sdf.format(new Date()));
			revoked(record.getOrderId());
		}
		flag = this.pickingOrderService.updateByPrimaryKeySelective(record);
		log.debug("修改状态值---打单/发料/撤销");
		return flag;
	}

	/**
	 * 撤销
	 * 
	 * @param orderId
	 */
	private void revoked(Integer orderId) {
		// 裁片外发
		List<OutsideDaily> dailies = this.dailyService.selDaily(orderId);
		for (int i = 0; i < dailies.size(); i++) {
			dailies.get(i).setDelb(1);
			dailyService.updateOutsideDaily(dailies.get(i));
		}
		// 裁片信息
		List<SewingInformation> informations = this.informationService.selInformation(orderId);
		for (int i = 0; i < informations.size(); i++) {
			informations.get(i).setSewingStatus("0");
			informationService.updateByPrimaryKeySelective(informations.get(i));
		}
		// 裁片详情
		List<SewingFactoryPickingOrder> pickingOrders = this.factoryPickingOrderService.factoryPickingOrders(orderId);
		for (int i = 0; i < pickingOrders.size(); i++) {
			pickingOrders.get(i).setSewingStatus("1");
			factoryPickingOrderService.updateByPrimaryKeySelective(pickingOrders.get(i));
		}
	}

	/**
	 * 打单
	 * 
	 * @param orderId
	 */
	private void print(Integer orderId) {
		// 裁片信息
		List<SewingInformation> informations = this.informationService.selInformation(orderId);
		for (int i = 0; i < informations.size(); i++) {
			informations.get(i).setSewingStatus("2");
			informationService.updateByPrimaryKeySelective(informations.get(i));
		}
	}

	/**
	 * 发料
	 * 
	 * @param orderId
	 */
	private void delivery(Integer orderId) {
		// 裁片信息
		List<SewingInformation> informations = this.informationService.selInformation(orderId);
		for (int i = 0; i < informations.size(); i++) {
			informations.get(i).setSewingStatus("3");
			informationService.updateByPrimaryKeySelective(informations.get(i));
		}
		// 裁片详情
		List<SewingFactoryPickingOrder> pickingOrders = this.factoryPickingOrderService.factoryPickingOrders(orderId);
		for (int i = 0; i < pickingOrders.size(); i++) {
			pickingOrders.get(i).setSewingStatus("2");
			factoryPickingOrderService.updateByPrimaryKeySelective(pickingOrders.get(i));
		}
	}

	/**
	 * 查询要打印的信息
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("selSewingFactory")
	@ResponseBody
	public List<SewingFactoryPickingOrder> selSewingFactory(SewingFactoryPickingOrder record) {
		List<SewingFactoryPickingOrder> orders = this.factoryPickingOrderService
				.factoryPickingOrders(record.getOrderId());
		SewingPickingOrder pickingOrder = this.pickingOrderService.selSewingByOrderId(record.getOrderId());
		pickingOrder.setOrderStatus("2");
		uppSewingPickingOrder(pickingOrder);
		log.info("查询要打印的信息");
		return orders;
	}

	/**
	 * 双击修改
	 * 
	 * @param detailedOrder
	 * @return
	 */
	@RequestMapping("dbuppSewingPickingOrder")
	@ResponseBody
	public int dbuppSewingPickingOrder(SewingPickingOrder record) {
		int flag = 0;
		flag = this.pickingOrderService.updateByPrimaryKeySelective(record);
		log.debug("双击修改备注");
		return flag;
	}

	@RequestMapping("listSewingPickingOrderAll")
	public void listSewingPickingOrderAll() {
		List<SewingPickingOrder> list = pickingOrderService.listSewingPickingOrderAll();
		for (int j = 0; j < list.size(); j++) {
			SewingPickingOrder record = new SewingPickingOrder();
			record.setOrderId(list.get(j).getOrderId());
			// 添加时间
			try {
				if (list.get(j).getAddTime() != null && !"".equals(list.get(j).getAddTime())) {
					record.setAddTime(autoGenericTime(list.get(j).getAddTime()).toString());
					pickingOrderService.updateByPrimaryKeySelective(record);
				}
				// 发料时间
				if (list.get(j).getDeliveryTime() != null && !"".equals(list.get(j).getDeliveryTime())) {
					record.setDeliveryTime(autoGenericTime(list.get(j).getDeliveryTime()).toString());
					pickingOrderService.updateByPrimaryKeySelective(record);
				}
				// 打单时间
				if (list.get(j).getOrderTime() != null && !"".equals(list.get(j).getOrderTime())) {
					record.setOrderTime(autoGenericTime(list.get(j).getOrderTime()).toString());
					pickingOrderService.updateByPrimaryKeySelective(record);
				}
				// 撤单时间
				if (list.get(j).getRevokedTime() != null && !"".equals(list.get(j).getRevokedTime())) {
					record.setRevokedTime(autoGenericTime(list.get(j).getRevokedTime()).toString());
					pickingOrderService.updateByPrimaryKeySelective(record);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 转化时间格式
	 * 
	 * @param createTime
	 *            传入的时间
	 * @return
	 * @throws ParseException
	 */
	public StringBuilder autoGenericTime(String createTime) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("DD");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
		String create = createTime.substring(8, 11);// 截取到时间的位数
		Date dt = sdf.parse(create);// 转成date格式
		String time = sdf.format(dt);// 格式化
		Date d = sdf1.parse(time);// 转成date格式
		String times = sdf1.format(d);// 再格式化
		// 替换字符串
		StringBuilder sb = new StringBuilder(createTime);
		if (times.length() == 2) {
			sb.replace(8, 11, times + " ");
		} else {
			sb.replace(8, 11, times);
		}
		return sb;
	}
}
