package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.PrintMarkOrderMapper;
import com.warehouse.entity.PrintMarkOrder;

@Service
public class PrintMarkOrderImpl implements PrintMarkOrderService {

	@Resource
	private PrintMarkOrderMapper printMarkOrdermapper;

	/**
	 * sel
	 */
	@Override
	public int selectByCount(PrintMarkOrder record) {
		int count = this.printMarkOrdermapper.selectByCount(record);
		return count;
	}

	@Override
	public List<PrintMarkOrder> selectByPage(PrintMarkOrder record) {
		List<PrintMarkOrder> printMarkOrders = this.printMarkOrdermapper.selectByPage(record);
		return printMarkOrders;
	}

	/**
	 * update
	 */
	@Override
	public int updateByPrimaryKeySelective(PrintMarkOrder record) {
		int flag = this.printMarkOrdermapper.updateByPrimaryKeySelective(record);
		return flag;
	}

	/**
	 * add
	 */
	@Override
	public int insertSelective(PrintMarkOrder record) {
		record.setOrderStatus("1");
		int flag = this.printMarkOrdermapper.insertSelective(record);
		return flag;
	}

	@Override
	public PrintMarkOrder selPrintByID(Integer id) {
		PrintMarkOrder markOrder = this.printMarkOrdermapper.selPrintByID(id);
		return markOrder;
	}

}
