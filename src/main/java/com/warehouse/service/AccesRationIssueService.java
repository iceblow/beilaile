package com.warehouse.service;

import com.warehouse.entity.AccesRationIssue;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by chiayich on 2017/2/9.
 */


public interface AccesRationIssueService {

    //==================== 辅料配发 ========================
    int getAccesOrderIssueBpcnt(Map<String, Object> param);

    List<AccesRationIssue> findAccesOrderIssueCndbp(Map<String, Object> param);

    AccesRationIssue issueDone(Integer amId, HttpServletRequest request);

    AccesRationIssue savaRemarkIssue(AccesRationIssue am, HttpServletRequest request);

    List<AccesRationIssue> printIssueSheet(String param, HttpServletRequest request);

    List<AccesRationIssue> printHTPaper(String param, HttpServletRequest request);
}
