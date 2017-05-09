package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.OutsideProcesMapper;
import com.warehouse.entity.Outsideproces;
import com.warehouse.util.Pagess;

/**
 * 
 * @author admin
 *
 */
@Service
public class OutsideProcesServiceImpl implements OutsideProcesService {

	@Resource
	private OutsideProcesMapper outsideprocesMapper;

	// 添加
	@Override
	public void addProces(Outsideproces outsideproces) {

		this.outsideprocesMapper.addproces(outsideproces);
	}

	// 修改
	@Override
	public void uppProces(Outsideproces outsideproces) {

		this.outsideprocesMapper.uppProce(outsideproces);
	}

	// 删除
	@Override
	public void delProces(Integer bid) {
		this.outsideprocesMapper.delProce(bid);
	}

	// 模糊查询
	@Override
	public int getCountByOutsideLike(String girard) {
		Integer count = this.outsideprocesMapper.getCountByOutsideLike(girard);
		return count;
	}

	@Override
	public List<Outsideproces> OutsideProcesByLike(Pagess page) {
		List<Outsideproces> outsideproces = this.outsideprocesMapper.OutsideProcesByLike(page);
		return outsideproces;
	}

	
	/**
	 * 
	 */
	// 根据波次查询数据
	@Override
	public List<Outsideproces> getDistinct(Outsideproces outsideproces) {
		List<Outsideproces> getDistinctproce = this.outsideprocesMapper.getDistinct(outsideproces);
		return getDistinctproce;
	}

	// 修改件数
	@Override
	public void uppNum(Integer bid, Integer bnumber) {
		this.outsideprocesMapper.uppNum(bid, bnumber);
	}

}
