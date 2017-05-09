package com.warehouse.dao;

import java.util.List;
import java.util.Map;

import com.warehouse.entity.DistributionDealerDelivery;
import com.warehouse.entity.FabricCodeProcessInformation;

public interface FabricCodeProcessInformationMapper {

	int getFabricCodeProcessInfoBpcnt(Map<String, Object> param);

	List<FabricCodeProcessInformation> findFabricCodeProcessInfoCndbp(Map<String, Object> param);

	List<FabricCodeProcessInformation> exportCurrentFabricCodeProcessData(
			Map<String, Object> anyVal);


}