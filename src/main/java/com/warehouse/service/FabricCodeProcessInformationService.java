package com.warehouse.service;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.FabricCodeProcessInformation;
import com.warehouse.entity.FabricSourcing;

public interface FabricCodeProcessInformationService {
	int getFabricCodeProcessInfoBpcnt(Map<String, Object> param);

	List<FabricCodeProcessInformation> findFabricCodeProcessInfoCndbp(Map<String, Object> param);

	List<FabricCodeProcessInformation> exportCurrentFabricCodeProcessData(
			Map<String, Object> anyVal);

	

}
