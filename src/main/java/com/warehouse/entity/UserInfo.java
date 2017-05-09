package com.warehouse.entity;

public class UserInfo {

	private int uid;
	private String username; // 账号
	private String password; // 密码
	private String trueName;// 真实姓名
	private String department; // 部门
	private String position; // 职位
	private String birthday; // 生日
	private String usex; // 性别
	private String uimg; // 头像
	private String email; // E-mail
	private String phone; // 电话
	private String remark; // 备注
	private String delb; // 删除标识
	private String PC_IP; // IP地址
	private String operation; // 管理
	private String ADD_TIME; // 注册时间
	private String UPDATE_TIME; // 修改时间
	private String DEL_TIME; // 删除时间
	private String LOGIN_TIME; // 最近登录时间

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUimg() {
		return uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDelb() {
		return delb;
	}

	public void setDelb(String delb) {
		this.delb = delb;
	}

	public String getPC_IP() {
		return PC_IP;
	}

	public void setPC_IP(String pC_IP) {
		PC_IP = pC_IP;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getADD_TIME() {
		return ADD_TIME;
	}

	public void setADD_TIME(String aDD_TIME) {
		ADD_TIME = aDD_TIME;
	}

	public String getUPDATE_TIME() {
		return UPDATE_TIME;
	}

	public void setUPDATE_TIME(String uPDATE_TIME) {
		UPDATE_TIME = uPDATE_TIME;
	}

	public String getDEL_TIME() {
		return DEL_TIME;
	}

	public void setDEL_TIME(String dEL_TIME) {
		DEL_TIME = dEL_TIME;
	}

	public String getLOGIN_TIME() {
		return LOGIN_TIME;
	}

	public void setLOGIN_TIME(String lOGIN_TIME) {
		LOGIN_TIME = lOGIN_TIME;
	}

	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", username=" + username + ", password=" + password + ", trueName=" + trueName
				+ ", department=" + department + ", position=" + position + ", birthday=" + birthday + ", usex=" + usex
				+ ", uimg=" + uimg + ", email=" + email + ", phone=" + phone + ", remark=" + remark + ", delb=" + delb
				+ ", PC_IP=" + PC_IP + ", operation=" + operation + ", ADD_TIME=" + ADD_TIME + ", UPDATE_TIME="
				+ UPDATE_TIME + ", DEL_TIME=" + DEL_TIME + ", LOGIN_TIME=" + LOGIN_TIME + "]";
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
