package com.warehouse.dao;

import java.util.List;

import com.warehouse.entity.ProblemNotGrant;

public interface ProblemNotGrantMapper {
	//假删除
    int deleteByProblemNotGrantId(ProblemNotGrant problemNotGrant);

    //模糊查询
    int getCountByProblemNotGrantLike(ProblemNotGrant problemNotGrant);
    
    List<ProblemNotGrant> ProblemNotGrantbylike(ProblemNotGrant problemNotGrant);
    
    //双击修改
   	int updateByText(ProblemNotGrant problemNotGrant);
}