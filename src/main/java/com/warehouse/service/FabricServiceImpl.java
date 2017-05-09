package com.warehouse.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricDAO;
import com.warehouse.entity.FabricDemo;
import com.warehouse.util.Pagess;

@Service
public class FabricServiceImpl implements FabricService {

	@Autowired
	private FabricDAO fabricDAO;
	
	//添加方法
	@Override
	public void add(FabricDemo fabricDemo) {
		
		fabricDemo.setAddtime(this.getDate());
		
		this.fabricDAO.add(fabricDemo);
	}
	//修改方法
	@Override
	public void update(FabricDemo fabricDemo) {
		this.fabricDAO.update(fabricDemo);
	}
	//分页查询先得到所有不重复的波次号和工厂
	@Override
	public List<FabricDemo> getBidAndFabric(Pagess page) {
		return this.fabricDAO.getBidAndFabric(page);
	}
	//得到数据量
	@Override
	public int getAllCountByBidAndFabric() {
		return this.fabricDAO.getAllCountByBidAndFabric();
	}
	//得到面料及用量等数据
	@Override
	public List<FabricDemo> getConsumptionByBidAndFabric(String b_id, String fabric) {
		
		List<FabricDemo> ar=this.fabricDAO.getConsumptionByBidAndFabric(b_id,fabric);
		
		return ar;
	}

	@Override
	public void delete(FabricDemo fabric) {
		// (假)删除用料日报表数据
		this.fabricDAO.delete(fabric);
	}
	//波次号模糊查询的数据量
	@Override
	public int getCountByBid(String bid) {
		return this.fabricDAO.getCountByBid(bid);
	}
	//根据波次号进行模糊查询
	@Override
	public List<FabricDemo> getAllByBid(Pagess page) {
		return this.fabricDAO.getAllByBid(page);
	}
	//根据波次号修改日期
	@Override
	public void updateDateByBid(FabricDemo fa) {
		this.fabricDAO.updateDateByBid(fa);
	}
	
	//得到当前系统时间
	public String getDate(){
		Date date = new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		
		return time;
	}
	//根据id查询单条信息
	@Override
	public FabricDemo getOne(int id) {
		return this.fabricDAO.getOne(id);
	}

}
