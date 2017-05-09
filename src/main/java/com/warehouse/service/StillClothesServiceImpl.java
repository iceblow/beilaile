package com.warehouse.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.StillClothesMapper;
import com.warehouse.entity.StillClothes;
import com.warehouse.util.CharacterUtils;
import com.warehouse.util.DateUtils;

@Service
public class StillClothesServiceImpl implements StillClothesService {
	@Resource
	public StillClothesMapper stillClothesMapper;

	@Override
	public int addStillClothes(StillClothes stillClothes) {
		stillClothes.setCreatedTime(DateUtils.formateDaTime(new Date()));
		stillClothes.setAddDate(DateUtils.formateDate(new Date()));
		stillClothes.setWave(CharacterUtils.getUpperCase(stillClothes.getWave()));
		stillClothes.setMarkDel("1");
		int result = stillClothesMapper.addStillClothes(stillClothes);
		return result;
	}

	@Override
	public int modifyStillClothes(StillClothes stillClothes) {
		stillClothes.setCreatedTime(DateUtils.formateDaTime(new Date()));
		stillClothes.setWave(CharacterUtils.getUpperCase(stillClothes.getWave()));
		int result = stillClothesMapper.modifyStillClothes(stillClothes);
		return result;
	}

	@Override
	public int delStillClothesById(StillClothes stillClothes) {
		stillClothes.setCreatedTime(DateUtils.formateDaTime(new Date()));
		stillClothes.setMarkDel("0");
		int result = stillClothesMapper.delStillClothesById(stillClothes);
		return result;
	}

	@Override
	public int getStillClothesByPageCount(Map<String, Object> anyVal) {
		int result = stillClothesMapper.getStillClothesByPageCount(anyVal);
		return result;
	}

	@Override
	public List<StillClothes> findConditionStillClothesByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<StillClothes> list = stillClothesMapper.findConditionStillClothesByPage(anyVal);
		return list;
	}

	@Override
	public StillClothes getStillClothesById(Integer id) {
		StillClothes stillClothes = stillClothesMapper.getStillClothesById(id);
		return stillClothes;
	}

}
