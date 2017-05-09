package com.warehouse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.BuildProgressWeeklyReportDAO;
import com.warehouse.entity.BuildProgressReport;

@Service
public class BuildProgressWeeklyReportServiceImpl implements BuildProgressWeeklyReportService {

	@Resource
	private BuildProgressWeeklyReportDAO buildProgressWeeklyReportDAO;

	@Override
	public Map<String, Object> getCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BuildProgressReport> buildProgressReports = new ArrayList<BuildProgressReport>();

		// 1.获取横坐标
		List<String> date = new ArrayList<String>();
		// 得到日期的查询结果
		List<String> dao = this.buildProgressWeeklyReportDAO.getDate();
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
		List<String> nameType = this.buildProgressWeeklyReportDAO.getNameType();
		String myNameType = "";
		for (int i = 0; i < nameType.size(); i++) {
			myNameType = myNameType + nameType.get(i) + ",";
		}
		String[] nameTypes = myNameType.split(",");
		// 3.拼接出图标数据
		List<BuildProgressReport> allList = this.buildProgressWeeklyReportDAO.getAll(date.get(0));
		for (int i = 0; i < nameTypes.length; i++) {
			int[] totals = new int[dates.length];
			for (int j = 0; j < dates.length; j++) {
				for (int k = allList.size() - 1; k >= 0; k--) {
					int t = 0;
					if (allList.get(k).getStatistics_date().equals(dates[j])
							&& allList.get(k).getName_type().equals(nameTypes[i])) {
						t = allList.get(k).getTotal();
					}
					totals[j] = t;
					if (allList.get(k).getStatistics_date().equals(dates[j])
							&& allList.get(k).getName_type().equals(nameTypes[i])) {
						allList.remove(allList.get(k));
						break;
					}
				}
			}
			BuildProgressReport buildProgressReport = new BuildProgressReport();
			buildProgressReport.setName(nameTypes[i]);
			buildProgressReport.setData(totals);
			buildProgressReports.add(buildProgressReport);
		}
		// 写入横坐标(日期);
		map.put("date", dates);
		map.put("storage", buildProgressReports);
		return map;
	}

	/**
	 * 获取订单数量
	 */
	@Override
	public Map<String, Object> getSum() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BuildProgressReport> buildProgressReports = new ArrayList<BuildProgressReport>();

		// 1.获取横坐标
		List<String> date = new ArrayList<String>();
		// 得到日期的查询结果
		List<String> dao = this.buildProgressWeeklyReportDAO.getDate();
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
		List<String> nameType = this.buildProgressWeeklyReportDAO.getNameType();
		String myNameType = "";
		for (int i = 0; i < nameType.size(); i++) {
			myNameType = myNameType + nameType.get(i) + ",";
		}
		String[] nameTypes = myNameType.split(",");

		// 3.拼接出图标数据
		List<BuildProgressReport> allList = this.buildProgressWeeklyReportDAO.getAll(date.get(0));

		for (int i = 0; i < nameTypes.length; i++) {

			int[] totals = new int[dates.length];

			for (int j = 0; j < dates.length; j++) {
				for (int k = allList.size() - 1; k >= 0; k--) {
					int t = 0;

					if (allList.get(k).getStatistics_date().equals(dates[j])
							&& allList.get(k).getName_type().equals(nameTypes[i])) {
						t = allList.get(k).getNumber();
					}

					totals[j] = t;

					if (allList.get(k).getStatistics_date().equals(dates[j])
							&& allList.get(k).getName_type().equals(nameTypes[i])) {
						allList.remove(allList.get(k));
						break;
					}
				}
			}
			BuildProgressReport buildProgressReport = new BuildProgressReport();
			buildProgressReport.setName(nameTypes[i]);
			buildProgressReport.setData(totals);

			buildProgressReports.add(buildProgressReport);
		}

		// 写入横坐标(日期);
		map.put("date", dates);
		map.put("storage", buildProgressReports);
		// 返回map
		return map;
	}

}
