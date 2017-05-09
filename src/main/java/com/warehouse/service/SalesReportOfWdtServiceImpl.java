package com.warehouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.SalesReportOfWdtDAO;
import com.warehouse.entity.SalesReportOfWdt;
import com.warehouse.util.PageUtil;

@Service
public class SalesReportOfWdtServiceImpl implements SalesReportOfWdtService {

	@Resource
	private SalesReportOfWdtDAO salesReportOfWdtDAO;

	@Override
	public Map<String, Object> getAllByPage(PageUtil pageUtil, SalesReportOfWdt salesReportOfWdt) {
		Map<String, Object> map = new HashMap<>();
		pageUtil.setPageSize(15);
		pageUtil.setTotolCount(this.salesReportOfWdtDAO.getCountByPage(salesReportOfWdt));

		List<SalesReportOfWdt> dataList = this.salesReportOfWdtDAO.getDataByPage(
				new SalesReportOfWdt(pageUtil.getReqult()[0], pageUtil.getReqult()[1], salesReportOfWdt));

		map.put("pageUtil", pageUtil);
		map.put("dataList", dataList);

		return map;
	}

	@Override
	public int delSelective() {
		int result = this.salesReportOfWdtDAO.delSelective();
		return result;
	}

	@Override
	public int insertSelective(SalesReportOfWdt salesReportOfWdt) {
		int result = this.salesReportOfWdtDAO.insertSelective(salesReportOfWdt);
		return result;
	}

	@Override
	public int insertSelectives(String form) {
		int result = this.salesReportOfWdtDAO.insertSelectives(form);
		return result;
	}

}
