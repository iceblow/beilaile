package com.warehouse.service;

import java.util.Map;

public interface WeeklyServices {

	/**
	 * if{
	 * 	阶段==天数
	 * }else{
	 * 	阶段*7==天数
	 * }
	 * @param con 显示几个阶段
	 * @param date 查询多少天的数据
	 * @param form 查询的表名
	 * @return
	 */
	Map<String, Object> getDate(int con, int date, String form);

}
