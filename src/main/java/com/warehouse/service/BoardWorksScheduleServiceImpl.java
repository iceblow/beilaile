package com.warehouse.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.warehouse.dao.BoardWorksScheduleDAO;
import com.warehouse.entity.AuxiliaryFabric;
import com.warehouse.entity.BoardWorksSchedule;

@Service
public class BoardWorksScheduleServiceImpl implements BoardWorksScheduleService {

	@Resource
	private BoardWorksScheduleDAO boardWorksScheduleDAO;

	@Override
	public int getCount(BoardWorksSchedule boardWorksSchedule) {
		return this.boardWorksScheduleDAO.getAllCount(boardWorksSchedule);
	}

	@Override
	public List<BoardWorksSchedule> getAllByPage(BoardWorksSchedule boardWorksSchedule) {
		return this.boardWorksScheduleDAO.getDataByPage(boardWorksSchedule);
	}
	
}
