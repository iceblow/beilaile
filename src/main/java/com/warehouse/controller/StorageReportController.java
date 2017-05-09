package com.warehouse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.MyStorage;
import com.warehouse.service.StorageReportService;

@Controller
@RequestMapping("storageReport")
public class StorageReportController {

	@Autowired
	private StorageReportService storageReportService;

	// -----------------未使用--------------------
	@RequestMapping("getStorage")
	@ResponseBody
	public Map<String, Object> getStorage() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MyStorage> myStorages = new ArrayList<MyStorage>();
		// 1.获取横坐标,最近三十天的日期拼接成一个String数组
		List<String> date = this.storageReportService.getDate();
		String mydate = "";
		for (int i = 0; i < date.size(); i++) {
			mydate = mydate + date.get(i) + ",";
		}
		String[] dates = mydate.split(",");

		// 2.获取小标头(每个生产厂家的名字)
		List<String> factory = this.storageReportService.getFactory();
		String myFactory = "";
		for (int i = 0; i < factory.size(); i++) {
			myFactory = myFactory + factory.get(i) + ",";
		}
		String[] factorys = myFactory.split(",");
		// 3.根据厂家和日期来获取到每个厂家每天的生产量
		for (int i = 0; i < factorys.length; i++) {
			String mytotal = "";
			int[] totals = new int[dates.length];
			for (int j = 0; j < dates.length; j++) {
				int t = this.storageReportService.getSumTotal(factorys[i], dates[j]);
				totals[j] = t;
			}
			MyStorage myStorage = new MyStorage();
			myStorage.setName(factorys[i]);
			myStorage.setData(totals);

			// 将对象写入数据集合中
			myStorages.add(myStorage);
		}
		// 写入横坐标(日期);
		map.put("date", dates);
		map.put("storage", myStorages);

		return map;
	}

	// ----------------------------------------------
	@RequestMapping("myGetStorage")
	@ResponseBody
	public Map<String, Object> myGetStorage() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MyStorage> myStorages = new ArrayList<MyStorage>();
		// 1.获取横坐标
		List<String> date = this.storageReportService.getDate();
		String mydate = "";
		for (int i = 0; i < date.size(); i++) {
			mydate = mydate + date.get(i) + ",";
		}
		String[] dates = mydate.split(",");

		// 2.获取图例(例如某个厂家或某个员工)
		List<String> factory = this.storageReportService.getFactory();
		String myFactory = "";
		for (int i = 0; i < factory.size(); i++) {
			myFactory = myFactory + factory.get(i) + ",";
		}
		String[] factorys = myFactory.split(",");
		// 3.拼接出图标数据
		List<MyStorage> allList = this.storageReportService.getAll(date.get(0));

		for (int i = 0; i < factorys.length; i++) {

			int[] totals = new int[dates.length];

			for (int j = 0; j < dates.length; j++) {
				for (int k = allList.size() - 1; k >= 0; k--) {
					int t = 0;
					if (allList.get(k).getFactory().equals(factorys[i]) && allList.get(k).getSdate().equals(dates[j])) {
						t = allList.get(k).getTotal_delivery();
					}
					totals[j] = t;
					if (allList.get(k).getFactory().equals(factorys[i]) && allList.get(k).getSdate().equals(dates[j])) {
						// 如果找到符合条件的就跳出当前循环,减少循环的次数
						break;
					}
				}
			}
			MyStorage myStorage = new MyStorage();
			myStorage.setName(factorys[i]);
			myStorage.setData(totals);

			// 将对象写入数据集合中
			myStorages.add(myStorage);
		}

		// 写入横坐标(日期);
		map.put("date", dates);
		map.put("storage", myStorages);

		return map;
	}

}
