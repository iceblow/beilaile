package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.ColorCard;

public interface ColorCardMapper {
	// 添加
	int addColorCard(ColorCard colorCard);

	// 查询所有
	List<ColorCard> findColorCardByAll();

	int findColorCardByColorCardCode(ColorCard colorCard);

	List<ColorCard> findColorCardBySupplierCode(ColorCard colorCard);

	// 查询名称
	List<ColorCard> findColorCardByColorCardName(ColorCard colorCard);

	// 修改对象
	int modifyColorCard(ColorCard colorCard);

	// 带条件查询总条数
	int getColorCardByPageCount(Map<String, Object> anyVal);

	// 带条件分页查询
	List<ColorCard> findConditionColorCardByPage(Map<String, Object> anyVal);

	ColorCard findColorCardById(Integer id);

	ColorCard getColorCardByColorCardCode(String ColorCardCode);

	List<ColorCard> findColorCardBySupplierCode(String supplierCode);

}