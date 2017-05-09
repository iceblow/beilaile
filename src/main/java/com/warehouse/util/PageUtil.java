package com.warehouse.util;

import java.util.List;

public class PageUtil {

	// 表数据的总条数
	private int totolCount;

	public int getTotolCount() {
		return totolCount;
	}

	public void setTotolCount(int totolCount) {
		this.totolCount = totolCount;
		this.pageCount = totolCount % this.pageSize == 0 ? totolCount / this.pageSize : totolCount / this.pageSize + 1;

	}

	// 总页数
	private int pageCount;

	// 设置每页的条数
	private int pageSize = 5;

	// 上一页
	private int firstPageSize;

	// 下一页
	private int nextPageSize;

	// 本页
	private int pageIndex;

	// 封装结果集
	private List list;

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;

	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstPageSize() {
		return firstPageSize;
	}

	public void setFirstPageSize(int firstPageSize) {
		this.firstPageSize = firstPageSize;
	}

	public int getNextPageSize() {
		return nextPageSize;
	}

	public void setNextPageSize(int nextPageSize) {
		this.nextPageSize = nextPageSize;
	}

	public int getPageIndex() {

		return pageIndex;
	}

	// 开始分页 设置本页的下标
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
		if (pageIndex <= 1) {
			this.firstPageSize = 1;
		} else {
			this.firstPageSize = pageIndex - 1;
		}
		if (pageIndex >= this.pageCount) {
			this.nextPageSize = this.pageCount;
		} else {
			this.nextPageSize = pageIndex + 1;
		}
	}

	// 获得结果集
	public int[] getReqult() {
		int[] nums = { ((this.pageIndex - 1) * this.pageSize), this.pageSize };
		return nums;

	}

	public static void main(String[] args) {

		// 在action中声明的属性
		PageUtil pageUtil = new PageUtil();

		// 在action中设置每页5个
		pageUtil.setPageSize(11);

		// 一共存在多少数据
		pageUtil.setTotolCount(50);
		pageUtil.setPageIndex(3);

		System.out.println("上一页:" + pageUtil.getFirstPageSize());
		System.out.println("本页:" + pageUtil.getPageIndex());
		System.out.println("下一页:" + pageUtil.getNextPageSize());

		System.err.println("00--" + pageUtil.getReqult()[0]);
		System.err.println("11--" + pageUtil.getReqult()[1]);
	}

}
