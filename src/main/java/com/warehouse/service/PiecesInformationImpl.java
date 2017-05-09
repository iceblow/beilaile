package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.PiecesInformationMapper;
import com.warehouse.entity.PiecesInformation;

@Service
public class PiecesInformationImpl implements PiecesInformationService {
	@Resource
	private PiecesInformationMapper piecesInformationmapper;

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

	/**
	 * 分页查询
	 */
	@Override
	public int selectByCount(PiecesInformation record) {
		int flag = this.piecesInformationmapper.selectByCount(record);
		return flag;
	}

	@Override
	public List<PiecesInformation> selectByPage(PiecesInformation record) {
		List<PiecesInformation> piecesInformation = this.piecesInformationmapper.selectBypage(record);
		return piecesInformation;
	}

	/**
	 * 添加到订单
	 */
	@Override
	public int uppPiecesInformation(PiecesInformation record) {
		record.setAddToOrderTime(sdf.format(new Date()));
		int flag = this.piecesInformationmapper.updateByPrimaryKeySelective(record);
		return flag;
	}

	/**
	 * 根据订单号查询
	 */
	@Override
	public List<PiecesInformation> selInformation(Integer orderId) {
		List<PiecesInformation> informations = this.piecesInformationmapper.selInformation(orderId);
		return informations;
	}

}
