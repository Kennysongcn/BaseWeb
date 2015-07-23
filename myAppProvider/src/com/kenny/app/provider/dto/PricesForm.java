package com.kenny.app.provider.dto;

/**
 * 费用填写表单属性
 * @author Administrator
 *
 */
public class PricesForm {
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
}
