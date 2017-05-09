package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.dao.OrderMemoDAO;
import com.warehouse.entity.OrderMemoDemo;
import com.warehouse.util.Pagess;

@Service
public class OrderMemoServiceImpl implements OrderMemoService {

	@Autowired
	private OrderMemoDAO orderMemoDAO;

	//得到数据量
	@Override
	public int getAllCount() {
		return this.orderMemoDAO.getAllCount();
	}
	//分页查询
	@Override
	public List<OrderMemoDemo> getAllByPage(Pagess pagess) {

		List<OrderMemoDemo> ar = this.orderMemoDAO.getAllByPage(pagess);
		//将其中为null的字段改为空字符串
		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i).getB_id() == null) {
				ar.get(i).setB_id("");
			}
			if (ar.get(i).getDate() == null) {
				ar.get(i).setDate("");
			}
			if (ar.get(i).getConsigneeMan() == null) {
				ar.get(i).setConsigneeMan("");
			}
			if (ar.get(i).getColor() == null) {
				ar.get(i).setColor("");
			}
			if (ar.get(i).getG0() == null) {
				ar.get(i).setG0("");
			}
			if (ar.get(i).getG1() == null) {
				ar.get(i).setG1("");
			}
			if (ar.get(i).getG2() == null) {
				ar.get(i).setG2("");
			}
			if (ar.get(i).getG3() == null) {
				ar.get(i).setG3("");
			}
			if (ar.get(i).getG4() == null) {
				ar.get(i).setG4("");
			}
			if (ar.get(i).getG5() == null) {
				ar.get(i).setG5("");
			}
			if (ar.get(i).getG6() == null) {
				ar.get(i).setG6("");
			}
			if (ar.get(i).getG7() == null) {
				ar.get(i).setG7("");
			}
			if (ar.get(i).getG8() == null) {
				ar.get(i).setG8("");
			}
			if (ar.get(i).getG9() == null) {
				ar.get(i).setG9("");
			}
			if (ar.get(i).getG10() == null) {
				ar.get(i).setG10("");
			}
			if (ar.get(i).getG11() == null) {
				ar.get(i).setG11("");
			}
			if (ar.get(i).getG_num() == null) {
				ar.get(i).setG_num("");
			}
			if (ar.get(i).getHorse() == null) {
				ar.get(i).setHorse("");
			}

		}

		return ar;
	}

	@Override
	public void update(OrderMemoDemo order) {
		//数据修改
		this.orderMemoDAO.update(order);
	}

	@Override
	public void add(OrderMemoDemo order) {
		//添加数据
		this.orderMemoDAO.add(order);
	}

	@Override
	public void trueDel(int id) {
		//真删除数据
		this.orderMemoDAO.trueDel(id);
	}
	
	@Override
	public void fakeDel(OrderMemoDemo order) {
		//假删除数据
		this.orderMemoDAO.fakeDel(order);
	}

}
