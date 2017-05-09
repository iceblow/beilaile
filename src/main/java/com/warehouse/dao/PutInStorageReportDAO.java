package com.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.warehouse.entity.MyStorage;

public interface PutInStorageReportDAO {

	List<String> getDate(@Param(value="form")String form, @Param(value="cdate")int cdate);

	List<String> getFactory(@Param(value="form")String form);

	List<MyStorage> getAll(@Param(value="form")String form,@Param(value="date")String date);

}
