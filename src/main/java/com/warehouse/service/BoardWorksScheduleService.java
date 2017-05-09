package com.warehouse.service;

import java.util.List;

import com.warehouse.entity.AuxiliaryFabric;
import com.warehouse.entity.BoardWorksSchedule;

public interface BoardWorksScheduleService {

	int getCount(BoardWorksSchedule boardWorksSchedule);

	List<BoardWorksSchedule> getAllByPage(BoardWorksSchedule boardWorksSchedule);

}
