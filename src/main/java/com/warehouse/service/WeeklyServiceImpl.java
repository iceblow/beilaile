package com.warehouse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.dao.WeeklyReportDAO;
import com.warehouse.entity.MyStorage;

@Service
public class WeeklyServiceImpl implements WeeklyServices {

	@Autowired
	private WeeklyReportDAO weeklyReportDAO;

	@Override
	public Map<String, Object> getDate(int con, int cdate, String form) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MyStorage> myStorages = new ArrayList<MyStorage>();

		// 1.获取横坐标
		List<String> date = new ArrayList<String>();
		// 得到日期的查询结果
		List<String> dao = this.weeklyReportDAO.getDate(form, cdate);
		// 将日期顺序变为升序
		for (int i = dao.size() - 1; i >= 0; i--) {
			String tt = new String();
			tt = dao.get(i);
			date.add(tt);
		}
		// 拼接得到日期字符串
		String mydate = "";
		for (int i = 0; i < date.size(); i++) {
			mydate = mydate + date.get(i) + ",";
		}
		// 切割日期字符串得到日期数组
		String[] dates = mydate.split(",");
		// 2.获取图例(例如某个厂家或某个员工)
		List<String> factory = this.weeklyReportDAO.getFactory(form);
		String myFactory = "";
		for (int i = 0; i < factory.size(); i++) {
			myFactory = myFactory + factory.get(i) + ",";
		}
		String[] factorys = myFactory.split(",");
		// 3.拼接出图标数据
		List<MyStorage> allList = this.weeklyReportDAO.getAll(form, date.get(0));

		if (con == cdate) {
			for (int i = 0; i < factorys.length; i++) {

				int[] totals = new int[dates.length];

				for (int j = 0; j < dates.length; j++) {
					for (int k = allList.size() - 1; k >= 0; k--) {
						int t = 0;
						if (allList.get(k).getFactory().equals(factorys[i])
								&& allList.get(k).getSdate().equals(dates[j])) {
							t = allList.get(k).getTotal_delivery();
						}
						totals[j] = t;
						if (allList.get(k).getFactory().equals(factorys[i])
								&& allList.get(k).getSdate().equals(dates[j])) {
							// 如果找到符合条件的就跳出当前循环,减少循环的次数
							break;
						}
					}
				}
				MyStorage myStorage = new MyStorage();
				myStorage.setName(factorys[i]);
				myStorage.setData(totals);
				myStorages.add(myStorage);
			}

			// 写入横坐标(日期);
			map.put("date", dates);
			map.put("storage", myStorages);
		}else{
			System.err.println("暂时没写");
		}
		return map;
	}

}
