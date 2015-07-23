package com.kenny.app.provider.dto;

public class queryPricesListResult {
	/**
	 * 价格ID
	 */
	private int cid;
	/**
	 * 价格
	 */
	private String prices;
	/**
	 * 总价
	 */
	private String pricesTotal;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 数量
	 */
	private String packAgeQty;
	/**
	 * 费用类型
	 */
	private String pricesName;
	/**
	 * 运单号
	 */
	private String jobno;
	
	private String vno ;
	private String userName;
	private String cname;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPrices() {
		return prices;
	}
	public void setPrices(String prices) {
		this.prices = prices;
	}
	public String getPricesTotal() {
		return pricesTotal;
	}
	public void setPricesTotal(String pricesTotal) {
		this.pricesTotal = pricesTotal;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPackAgeQty() {
		return packAgeQty;
	}
	public void setPackAgeQty(String packAgeQty) {
		this.packAgeQty = packAgeQty;
	}
	public String getPricesName() {
		return pricesName;
	}
	public void setPricesName(String pricesName) {
		this.pricesName = pricesName;
	}
	public String getJobno() {
		return jobno;
	}
	public void setJobno(String jobno) {
		this.jobno = jobno;
	}
	public String getVno() {
		return vno;
	}
	public void setVno(String vno) {
		this.vno = vno;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
