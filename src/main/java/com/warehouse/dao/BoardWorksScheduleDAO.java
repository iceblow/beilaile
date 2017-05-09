package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.AuxiliaryFabric;
import com.warehouse.entity.BoardWorksSchedule;

public interface BoardWorksScheduleDAO {

	int getAllCount(BoardWorksSchedule boardWorksSchedule);

	List<BoardWorksSchedule> getDataByPage(BoardWorksSchedule boardWorksSchedule);

}
