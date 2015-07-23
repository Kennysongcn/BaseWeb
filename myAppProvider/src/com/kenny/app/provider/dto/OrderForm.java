package com.kenny.app.provider.dto;

import java.sql.Date;

/**
 * 费用填写表单属性
 * @author Administrator
 *
 */
public class OrderForm {
	
	private int ORDER_ID;
	private String ORDER_NO;
	private String DIC_NO;
	private String DIRVER_NAME;
	private String CAR_NO;
	
	private String DRIVER_MOBILE;
	private String UNCABINET_ADDRESS;
	private String CABINET_ADDRESS;
	private Date  BOOKING_TIME;
	private String DELIVERY_ADDRESS;
	
	private String DECLEAR_CUSTOM;
	private String GOODS_VOLUME;
	private String GOODS_WEIGHT;
	private String GOODS_QUANTITY;
	public int getORDER_ID() {
		return ORDER_ID;
	}
	public void setORDER_ID(int oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}
	public String getORDER_NO() {
		return ORDER_NO;
	}
	public void setORDER_NO(String oRDER_NO) {
		ORDER_NO = oRDER_NO;
	}
	public String getDIC_NO() {
		return DIC_NO;
	}
	public void setDIC_NO(String dIC_NO) {
		DIC_NO = dIC_NO;
	}
	public String getDIRVER_NAME() {
		return DIRVER_NAME;
	}
	public void setDIRVER_NAME(String dIRVER_NAME) {
		DIRVER_NAME = dIRVER_NAME;
	}
	public String getCAR_NO() {
		return CAR_NO;
	}
	public void setCAR_NO(String cAR_NO) {
		CAR_NO = cAR_NO;
	}
	public String getDRIVER_MOBILE() {
		return DRIVER_MOBILE;
	}
	public void setDRIVER_MOBILE(String dRIVER_MOBILE) {
		DRIVER_MOBILE = dRIVER_MOBILE;
	}
	public String getUNCABINET_ADDRESS() {
		return UNCABINET_ADDRESS;
	}
	public void setUNCABINET_ADDRESS(String uNCABINET_ADDRESS) {
		UNCABINET_ADDRESS = uNCABINET_ADDRESS;
	}
	public String getCABINET_ADDRESS() {
		return CABINET_ADDRESS;
	}
	public void setCABINET_ADDRESS(String cABINET_ADDRESS) {
		CABINET_ADDRESS = cABINET_ADDRESS;
	}
	public Date getBOOKING_TIME() {
		return BOOKING_TIME;
	}
	public void setBOOKING_TIME(Date bOOKING_TIME) {
		BOOKING_TIME = bOOKING_TIME;
	}
	public String getDELIVERY_ADDRESS() {
		return DELIVERY_ADDRESS;
	}
	public void setDELIVERY_ADDRESS(String dELIVERY_ADDRESS) {
		DELIVERY_ADDRESS = dELIVERY_ADDRESS;
	}
	public String getDECLEAR_CUSTOM() {
		return DECLEAR_CUSTOM;
	}
	public void setDECLEAR_CUSTOM(String dECLEAR_CUSTOM) {
		DECLEAR_CUSTOM = dECLEAR_CUSTOM;
	}
	public String getGOODS_VOLUME() {
		return GOODS_VOLUME;
	}
	public void setGOODS_VOLUME(String gOODS_VOLUME) {
		GOODS_VOLUME = gOODS_VOLUME;
	}
	public String getGOODS_WEIGHT() {
		return GOODS_WEIGHT;
	}
	public void setGOODS_WEIGHT(String gOODS_WEIGHT) {
		GOODS_WEIGHT = gOODS_WEIGHT;
	}
	public String getGOODS_QUANTITY() {
		return GOODS_QUANTITY;
	}
	public void setGOODS_QUANTITY(String gOODS_QUANTITY) {
		GOODS_QUANTITY = gOODS_QUANTITY;
	}
}
