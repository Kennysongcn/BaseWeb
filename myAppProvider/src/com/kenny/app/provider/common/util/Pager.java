package com.kenny.app.provider.common.util;

import java.util.List;

public class Pager<T> {

	/**
	 * 
	 */
	private List<T> datas;
	/**
	 * 
	 */
	private int offset;
	/**
	 * 
	 */
	private int size;
	/**
	 * 总大小
	 */
	private int totalSize;
	/**
	 * 总数量
	 */
	private long total;
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	
}
