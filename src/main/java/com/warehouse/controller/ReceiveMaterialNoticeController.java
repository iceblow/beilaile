package com.warehouse.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.MobileVerify;
import com.warehouse.entity.ReceiveMaterialNotice;
import com.warehouse.service.MobileVerifyService;
import com.warehouse.service.ReceiveMaterialNoticeSerivce;
import com.warehouse.util.DateUtils;
import com.warehouse.util.Page;
import com.warehouse.util.SmsCheckCodeUtils;

@Controller
public class ReceiveMaterialNoticeController {
	@Resource
	public ReceiveMaterialNoticeSerivce receiveMaterialNoticeSerivce;

	@Resource
	public MobileVerifyService mobileVerifySerivce;

	@RequestMapping(value = "modifyReceiveMaterialNotice.do", method = RequestMethod.POST)
	@ResponseBody
	public int modifyReceiveMaterialNotice(ReceiveMaterialNotice receiveMaterialNotice, HttpServletRequest request) {
		int result = receiveMaterialNoticeSerivce.modifyReceiveMaterialNotice(receiveMaterialNotice, request);
		return result;
	}

	@RequestMapping(value = "delReceiveMaterialNoticeById.do", method = RequestMethod.POST)
	@ResponseBody
	public int delReceiveMaterialNoticeById(ReceiveMaterialNotice receiveMaterialNotice, HttpServletRequest request) {
		int result = receiveMaterialNoticeSerivce.delReceiveMaterialNoticeById(receiveMaterialNotice, request);
		return result;
	}

	@RequestMapping(value = "getReceiveMaterialNoticeByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<ReceiveMaterialNotice> getReceiveMaterialNoticeByPageCount(Map<String, Object> anyVal) {
		int result = receiveMaterialNoticeSerivce.getReceiveMaterialNoticeByPageCount(anyVal);
		Page<ReceiveMaterialNotice> page = new Page<ReceiveMaterialNotice>(result, 1);
		// page.setRecordList(list);
		return page;
	}

	@RequestMapping(value = "findConditionReceiveMaterialNoticeByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<ReceiveMaterialNotice> findConditionReceiveMaterialNoticeByPage(
			@RequestParam Map<String, Object> anyVal) {
		List<ReceiveMaterialNotice> list = receiveMaterialNoticeSerivce
				.findConditionReceiveMaterialNoticeByPage(anyVal);
		return list;
	}

	@RequestMapping(value = "getReceiveMaterialNoticeById.do", method = RequestMethod.POST)
	@ResponseBody
	public ReceiveMaterialNotice getReceiveMaterialNoticeById(Integer id) {
		ReceiveMaterialNotice receiveMaterialNotice = receiveMaterialNoticeSerivce.getReceiveMaterialNoticeById(id);
		return receiveMaterialNotice;
	}

	@RequestMapping(value = "EailAlertById.do", method = RequestMethod.POST)
	@ResponseBody
	public int EailAlertById(Integer id, HttpServletRequest request) {
		ReceiveMaterialNotice receiveMaterialNotice = receiveMaterialNoticeSerivce.getReceiveMaterialNoticeById(id);
		receiveMaterialNotice.setIssuedStatus("邮件发送");
		int result = receiveMaterialNoticeSerivce.modifyReceiveMaterialNotice(receiveMaterialNotice, request);
		return result;
	}

	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "SMSAlertById.do", method = RequestMethod.POST)
	@ResponseBody
	public int SMSAlertById(Integer id, HttpServletRequest request) {
		// 根据id查询数据
		ReceiveMaterialNotice receiveMaterialNotice = receiveMaterialNoticeSerivce.getReceiveMaterialNoticeById(id);
		// 保存发送实体
		MobileVerify mobileVerify = new MobileVerify();
		// 调用短信操作
		try {
			// 接收map结果集
			Map<String, Object> map = SmsCheckCodeUtils.smsRemind("18268188578", receiveMaterialNotice.getWave(),
					receiveMaterialNotice.getExpectedReceiveMaterialDate(), receiveMaterialNotice.getFactoryPicking());
			mobileVerify.setMobile((String) map.get("phone"));
			mobileVerify.setContent((String) map.get("smsText"));
			mobileVerify.setWave(receiveMaterialNotice.getWave());
			mobileVerify.setSendTime(DateUtils.formateDate(new Date()));
			mobileVerify.setReminderType("领料通知");
			// 保存内容
			mobileVerifySerivce.addMobileVerify(mobileVerify, request);
			// 保存提醒
			receiveMaterialNotice.setIssuedStatus("短信发送");
		} catch (HTTPException | IOException e1) {
			e1.printStackTrace();
		}
		int result = receiveMaterialNoticeSerivce.modifyReceiveMaterialNotice(receiveMaterialNotice, request);
		return result;
	}

}
