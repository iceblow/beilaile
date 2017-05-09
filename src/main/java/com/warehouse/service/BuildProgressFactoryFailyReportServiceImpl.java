package com.warehouse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.BuildProgressFactoryFailyReportDAO;
import com.warehouse.entity.BuildProgressFactoryDailyReport;

@Service
public class BuildProgressFactoryFailyReportServiceImpl implements BuildProgressFactoryFailyReportService {

	@Resource
	private BuildProgressFactoryFailyReportDAO dao;
	
	@Override
	public Map<String, Object> getFactoryProduction() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BuildProgressFactoryDailyReport> buildProgressFactoryDailyReports = new ArrayList<BuildProgressFactoryDailyReport>();

		// 1.获取横坐标
		List<String> date = new ArrayList<String>();
		// 得到日期的查询结果
		List<String> dao = this.dao.getDate();
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
		List<String> nameType = this.dao.getNameType();
		String myNameType = "";
		for (int i = 0; i < nameType.size(); i++) {
			myNameType = myNameType + nameType.get(i) + ",";
		}
		String[] nameTypes = myNameType.split(",");
		// 3.拼接出图标数据
		List<BuildProgressFactoryDailyReport> allList = this.dao.getAll(date.get(0));
		for (int i = 0; i < nameTypes.length; i++) {
			int[] totals = new int[dates.length];
			for (int j = 0; j < dates.length; j++) {
				for (int k = allList.size() - 1; k >= 0; k--) {
					int t = 0;
					if (allList.get(k).getReport_date().equals(dates[j])
							&& allList.get(k).getFactory().equals(nameTypes[i])) {
						t = allList.get(k).getReport_number();
					}
					totals[j] = t;
					if (allList.get(k).getReport_date().equals(dates[j])
							&& allList.get(k).getFactory().equals(nameTypes[i])) {
						allList.remove(allList.get(k));
						break;
					}
				}
			}
			BuildProgressFactoryDailyReport buildProgressFactoryDailyReport = new BuildProgressFactoryDailyReport();
			buildProgressFactoryDailyReport.setName(nameTypes[i]);
			buildProgressFactoryDailyReport.setData(totals);
			buildProgressFactoryDailyReports.add(buildProgressFactoryDailyReport);
		}
		// 写入横坐标(日期);
		map.put("date", dates);
		map.put("storage", buildProgressFactoryDailyReports);
		return map;
	}

}
