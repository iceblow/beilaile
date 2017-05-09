package com.warehouse.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.warehouse.entity.NotStorageRecord;
import com.warehouse.service.NotStorageRecordService;
import com.warehouse.util.PageUtil;

@Controller
@RequestMapping("notStorageRecord")
public class NotStorageRecordController {

	@Resource
	private NotStorageRecordService notStorageRecordService;

	@RequestMapping("getDataByPage.do")
	@ResponseBody
	public Map<String, Object> selectPageConut(PageUtil page, NotStorageRecord notStorageRecord) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<>();
		page.setPageSize(15);// 每页显示数据量
		page.setTotolCount(notStorageRecordService.selectPage(notStorageRecord));// 总数据条数
		List<NotStorageRecord> myList = this.notStorageRecordService.getDataByPage(new NotStorageRecord(page.getReqult()[0], page.getReqult()[1], notStorageRecord));// 得到分页查询的数据
		map.put("pageUtil", page);// 前台接收的分页信息
		map.put("dataList", myList);// 显示数据详细信息
		for(int a=0;a<myList.size();a++){                 //得到俩日期之间相差的时间天数
			 String ddd=myList.get(a).getMaterialTime();
			 SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			 Date dd = new Date();
			 String nowTime=ft.format(dd);
			 long day = 0;
			 try {
				Date date1 = ft.parse(ddd);
				Date date2 = ft.parse(nowTime );
				day =  date2.getTime() - date1.getTime();
				day = day / 1000 / 60 / 60 / 24;
				myList.get(a).setMaterialDays((int)day);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	//双击修改
	@RequestMapping("updateByText.do")
	@ResponseBody
	public int updateByText(NotStorageRecord notStorageRecord){
		return notStorageRecordService.updateByText(notStorageRecord);
	}
	
	//问题解决
	@RequestMapping("updateAndTime.do")
	@ResponseBody
	public int updateAndTime(NotStorageRecord notStorageRecord){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		notStorageRecord.setProblemSolvingTime(df.format(new Date()));
		notStorageRecord.setProblemState("已解决");
		System.out.println(notStorageRecord.getProblemState());
		return notStorageRecordService.updateByText(notStorageRecord);
	}
	
	//数据假删除
	@RequestMapping("falseDelete.do")
	@ResponseBody
	public int falseDalete(NotStorageRecord notStorageRecord){
		notStorageRecord.setDataState("2");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		notStorageRecord.setDeleteTime(df.format(new Date()));
		return notStorageRecordService.updateByText(notStorageRecord);
	}
}
