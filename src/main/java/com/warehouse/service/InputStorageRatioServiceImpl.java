package com.warehouse.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.InputStorageRatioDAO;
import com.warehouse.entity.InputStorageRadio;

@Service
public class InputStorageRatioServiceImpl implements InputStorageRatioService {

	@Resource
	private InputStorageRatioDAO inputStorageRatiodao;

	//入库比例
	public Map<String,Object> getRatioIn(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<InputStorageRadio> inputStorageRadios = new ArrayList<InputStorageRadio>();
		
		// 1.获取横坐标,日期的查询结果,转为数组
		List<String> dateList = inputStorageRatiodao.getDate();
		//时间集合倒叙
		Collections.reverse(dateList);
		
		//2.得到数据类型的数组
		List<String> nameType = inputStorageRatiodao.getNameType();
		//3.得到所有类型对应的total数组
		for(int i=0;i<nameType.size();i++){
			double[] totals = new double[dateList.size()];
			//得到对应类型的
			List<Double> totalList;
			if(nameType.get(i) != null){
				totalList = inputStorageRatiodao.getRatioIn(nameType.get(i));
				//集合倒叙
				Collections.reverse(totalList);
				//转成数组
				totals = toDoubleArray(totalList);
			}
			//封装到实体类里
			InputStorageRadio inputstorageradio = new InputStorageRadio();
			inputstorageradio.setName(nameType.get(i)); //类型
			inputstorageradio.setData(totals);	  	    //total数组
			inputStorageRadios.add(inputstorageradio);
		}
		// 写入横坐标(日期);
		map.put("date", toStringArray(dateList));
		map.put("storage", inputStorageRadios);
		return map;
	}

	//入库比例
	public Map<String,Object> getRatioNot(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<InputStorageRadio> inputStorageRadios = new ArrayList<InputStorageRadio>();
		
		// 1.获取横坐标,日期的查询结果,转为数组
		List<String> dateList = inputStorageRatiodao.getDate();
		//时间集合倒叙
		Collections.reverse(dateList);
		
		//2.得到数据类型的数组
		List<String> nameType = inputStorageRatiodao.getNameType();
		//3.得到所有类型对应的total数组
		for(int i=0;i<nameType.size();i++){
			double[] totals = new double[dateList.size()];
			//得到对应类型的
			List<Double> totalList;
			if(nameType.get(i) != null){
				totalList = inputStorageRatiodao.getRatioNot(nameType.get(i));
				//集合倒叙
				Collections.reverse(totalList);
				//转成数组
				totals = toDoubleArray(totalList);
			}
			//封装到实体类里
			InputStorageRadio inputstorageradio = new InputStorageRadio();
			inputstorageradio.setName(nameType.get(i)); //类型
			inputstorageradio.setData(totals);	  	    //total数组
			inputStorageRadios.add(inputstorageradio);
		}
		// 写入横坐标(日期);
		map.put("date", toStringArray(dateList));
		map.put("storage", inputStorageRadios);
		return map;
	}
	
	//工具类,集合转数组
	public static String[] toStringArray(List<String> strList){
		String[] array = new String[strList.size()];
		strList.toArray(array);
		return array;
	}
	//工具类,集合转数组
	public static double[] toDoubleArray(List<Double> intList){
		double[] array = new double[intList.size()];
		
		for(int j=0;j<intList.size();j++){
			if(intList.get(j) == null){
				array[j]=0;
			}else{
				array[j]=intList.get(j);
			}
		}
		return array;
	}
	
	

}
