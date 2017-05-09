package com.warehouse.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.FabricCodeProcessInformationMapper;
import com.warehouse.entity.FabricCodeProcessInformation;
import com.warehouse.entity.FabricSourcing;
@Service
public class FabricCodeProcessInformationServiceImpl implements
		FabricCodeProcessInformationService {
	@Resource
	FabricCodeProcessInformationMapper fabricCodeProcessInformationMapper;
	@Override
	public int getFabricCodeProcessInfoBpcnt(Map<String, Object> param) {

		return fabricCodeProcessInformationMapper.getFabricCodeProcessInfoBpcnt(param);
	}

	@Override
	public List<FabricCodeProcessInformation> findFabricCodeProcessInfoCndbp(
			Map<String, Object> param) {
		int pageNow = Integer.parseInt(param.get("pageNow").toString());
		int pageSize = Integer.parseInt(param.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		param.put("pageNow", pageNow);
		param.put("pageSize", pageSize);
		return fabricCodeProcessInformationMapper.findFabricCodeProcessInfoCndbp(param);
	}

	@Override
	public List<FabricCodeProcessInformation> exportCurrentFabricCodeProcessData(
			Map<String, Object> anyVal) {
		List<FabricCodeProcessInformation> list = fabricCodeProcessInformationMapper.exportCurrentFabricCodeProcessData(anyVal);
		return list;
	}

}
