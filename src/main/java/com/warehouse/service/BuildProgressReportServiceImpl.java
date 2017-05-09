package com.warehouse.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.BuildProgressReportDAO;
import com.warehouse.entity.BuildProgressReport;

@Service
public class BuildProgressReportServiceImpl implements BuildProgressReportService {

	@Resource
	private BuildProgressReportDAO buildProgressReportDAO;

	//测试
	public Map<String,Object> test(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<BuildProgressReport> buildProgressReports = new ArrayList<BuildProgressReport>();
		
		// 1.获取横坐标,日期的查询结果,转为数组
		List<String> dateList = buildProgressReportDAO.getDate();
		//时间集合倒叙
		Collections.reverse(dateList);
		
		//2.得到数据类型的数组
		List<String> nameType = buildProgressReportDAO.getNameType();
		//3.得到所有类型对应的total数组
		for(int i=0;i<nameType.size();i++){
			int[] totals = new int[dateList.size()];
			//得到对应类型的
			List<Integer> totalList;
			if(nameType.get(i) != null){
				totalList = buildProgressReportDAO.getTotal(nameType.get(i));
				//集合倒叙
				Collections.reverse(totalList);
				//转成数组
				totals = toIntegerArray(totalList);
			}
			//封装到实体类里
			BuildProgressReport buildProgressReport = new BuildProgressReport();
			buildProgressReport.setName(nameType.get(i)); //类型
			buildProgressReport.setData(totals);	  	  //total数组
			buildProgressReports.add(buildProgressReport);
		}
		// 写入横坐标(日期);
		map.put("date", toStringArray(dateList));
		map.put("storage", buildProgressReports);
		return map;
	}

	
	//工具类,集合转数组
	public static String[] toStringArray(List<String> strList){
		String[] array = new String[strList.size()];
		strList.toArray(array);
		return array;
	}
	//工具类,集合转数组
	public static int[] toIntegerArray(List<Integer> intList){
		int[] array = new int[intList.size()];
		
		for(int j=0;j<intList.size();j++){
			if(intList.get(j) == null){
				array[j]=0;
			}else{
				array[j]=intList.get(j);
			}
		}
		return array;
	}
	
	@Override
	public Map<String, Object> getCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BuildProgressReport> buildProgressReports = new ArrayList<BuildProgressReport>();

		// 1.获取横坐标
		List<String> date = new ArrayList<String>();
		// 得到日期的查询结果
		List<String> dao = this.buildProgressReportDAO.getDate();
		// 将日期顺序变为升序,因为要查最近的30条，只能先倒叙，再正序
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
		List<String> nameType = this.buildProgressReportDAO.getNameType();
		String myNameType = "";
		for (int i = 0; i < nameType.size(); i++) {
			myNameType = myNameType + nameType.get(i) + ",";
		}
		String[] nameTypes = myNameType.split(",");
		// 3.拼接出图标数据
		List<BuildProgressReport> allList = this.buildProgressReportDAO.getAll(date.get(0));
		for (int i = 0; i < nameTypes.length; i++) {
			
			int[] totals = new int[dates.length];
			
			for (int j = 0; j < dates.length; j++) {//通过这层循环把totals赋值一遍
				for (int k = allList.size() - 1; k >= 0; k--) {
					int t = 0;
					if (allList.get(k).getStatistics_date().equals(dates[j])&& allList.get(k).getName_type().equals(nameTypes[i])) {
						t = allList.get(k).getTotal();//得到总数
					}
					totals[j] = t;//设置总数
					if (allList.get(k).getStatistics_date().equals(dates[j])&& allList.get(k).getName_type().equals(nameTypes[i])) {
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
		List<String> dao = this.buildProgressReportDAO.getDate();
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
		List<String> nameType = this.buildProgressReportDAO.getNameType();
		String myNameType = "";
		for (int i = 0; i < nameType.size(); i++) {
			myNameType = myNameType + nameType.get(i) + ",";
		}
		String[] nameTypes = myNameType.split(",");

		// 3.拼接出图标数据
		List<BuildProgressReport> allList = this.buildProgressReportDAO.getAll(date.get(0));

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
