package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.warehouse.dao.ColorCardMapper;
import com.warehouse.entity.ColorCard;

@Service
public class ColorCardServiceImpl implements ColorCardService {
	@Resource
	public ColorCardMapper colorCardMapper;

	@Override
	public int addColorCard(ColorCard colorCard) {
		int reslut = colorCardMapper.addColorCard(colorCard);
		return reslut;

	}

	@Override
	public List<ColorCard> findColorCardByAll() {
		List<ColorCard> list = colorCardMapper.findColorCardByAll();
		return list;
	}

	@Override
	public List<ColorCard> findColorCardByColorCardName(ColorCard colorCard) {
		List<ColorCard> list = colorCardMapper.findColorCardByColorCardName(colorCard);
		return list;
	}

	@Override
	public int modifyColorCard(ColorCard colorCard, HttpServletRequest request) {
		int reslut = colorCardMapper.modifyColorCard(colorCard);
		return reslut;
	}

	@Override
	public int getColorCardByPageCount(Map<String, Object> anyVal) {
		int reslut = colorCardMapper.getColorCardByPageCount(anyVal);
		return reslut;
	}

	@Override
	public List<ColorCard> findConditionColorCardByPage(Map<String, Object> anyVal) {
		List<ColorCard> list = colorCardMapper.findConditionColorCardByPage(anyVal);
		return list;
	}

	@Override
	public ColorCard findColorCardById(Integer id) {
		ColorCard colorCard = colorCardMapper.findColorCardById(id);
		return colorCard;
	}

	@Override
	public Integer findColorCardByColorCardCode(ColorCard colorCard) {
		colorCard.setColorCardCode(colorCard.getSupplierCode() + colorCard.getCardCode());
		int reslut = colorCardMapper.findColorCardByColorCardCode(colorCard);
		return reslut;
	}

	@Override
	public List<ColorCard> findColorCardBySupplierCode(String supplierCode) {
		List<ColorCard> list = colorCardMapper.findColorCardBySupplierCode(supplierCode);
		return list;
	}

	@Override
	public ColorCard getColorCardByColorCardCode(String ColorCardCode) {
		ColorCard colorCard = colorCardMapper.getColorCardByColorCardCode(ColorCardCode);
		return colorCard;
	}

}
