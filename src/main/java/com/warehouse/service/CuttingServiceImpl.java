package com.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.dao.CuttingDAO;
import com.warehouse.entity.Cutting;
import com.warehouse.util.Pagess;

@Service
public class CuttingServiceImpl implements CuttingService {

	@Autowired
	private CuttingDAO cuttingDAO;

	@Override
	public void add(Cutting cut) {
		this.cuttingDAO.add(cut);
	}

	@Override
	public void update(Cutting cut) {
		this.cuttingDAO.update(cut);
	}

	// 查询总的数据量
	@Override
	public int getCutCounts() {

		int num = this.cuttingDAO.getCutCounts();

		return num;
	}

	// 所有数据的分页查询
	@Override
	public List<Cutting> getAllByPage(Pagess page) {

		List<Cutting> cuttings = this.cuttingDAO.getAllByPage(page);
		// 将所有为null的数量显示成0
		for (int i = 0; i < cuttings.size(); i++) {

			if (cuttings.get(i).getS59() == null) {
				cuttings.get(i).setS59(0);
			}
			if (cuttings.get(i).getS66() == null) {
				cuttings.get(i).setS66(0);
			}
			if (cuttings.get(i).getS73() == null) {
				cuttings.get(i).setS73(0);
			}
			if (cuttings.get(i).getS80() == null) {
				cuttings.get(i).setS80(0);
			}
			if (cuttings.get(i).getS90() == null) {
				cuttings.get(i).setS90(0);
			}
			if (cuttings.get(i).getOneCursumption() == null) {
				cuttings.get(i).setOneCursumption(new String("0"));
			}

		}

		return cuttings;
	}

	// 根据编号删除裁床信息
	@Override
	public void delCut(int id) {
		this.cuttingDAO.delCut(id);
	}

	// 模糊查询的时候查询数量
	@Override
	public int getCutCountByBid(Cutting cutting) {
		return this.cuttingDAO.getCutCountByBid(cutting);
	}

	// 根据波次号模糊查询
	@Override
	public List<Cutting> getAllByBid(Cutting cutting) {
		return this.cuttingDAO.getAllByBid(cutting);
	}

	// 根据id查询单条数据
	@Override
	public Cutting getOne(int id) {
		return this.cuttingDAO.getOne(id);
	}

	// 完成方法
	@Override
	public int complete(int id) {
		return this.cuttingDAO.complete(id);
	}
}
