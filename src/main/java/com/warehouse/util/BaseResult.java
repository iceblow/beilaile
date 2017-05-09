package com.warehouse.util;

import java.io.Serializable;

/** 
 *  
 * 
 */
public class BaseResult implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6673395649748854442L;

	/**
	 * 请求唯一ID
	 */
	private String requestId;
	/**
	 * 成功标记
	 */
	private boolean success;
	/**
	 * 操作结果代码
	 * 
	 * @see com.aliyun.youhui.enums.YuhuiCode
	 */
	private String code;

	/**
	 * 操作消息
	 */
	private String message;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
