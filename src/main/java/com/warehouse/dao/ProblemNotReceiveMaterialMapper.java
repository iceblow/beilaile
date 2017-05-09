package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.ProblemNotReceiveMaterial;

public interface ProblemNotReceiveMaterialMapper {
	//假删除
    int deleteByProblemNotReceiveMaterialId(ProblemNotReceiveMaterial problemNotReceiveMaterial);
    
   //模糊查询
    int getCountByProblemNotReceiveMaterialLike(ProblemNotReceiveMaterial problemNotReceiveMaterial);
    
    List<ProblemNotReceiveMaterial> ProblemNotReceiveMaterialbylike(ProblemNotReceiveMaterial problemNotReceiveMaterial);
    //双击修改
	int updateByText(ProblemNotReceiveMaterial problemNotReceiveMaterial);
}