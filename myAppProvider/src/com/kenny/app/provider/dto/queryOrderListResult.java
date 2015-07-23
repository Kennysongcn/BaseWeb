package com.kenny.app.provider.dto;

import java.sql.Date;

public class queryOrderListResult {
	/*运单id*/
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
	   
	/*用户详细id*/
	private String USER_ID;
	private String USER_NAME;
	private String PASSWORDS;
	private String USER_TYPE;
	private String USER_MOBILE;	
	private String USER_STATE;
	
	/*
	 * 柜号表
	 * */
	private String CABINET_ID;   //
	/*
	 * 柜好
	 * */
	private String CABINET_NO;  // 
	/*
	 * 封条好
	 * */
	private String SEAL_NO;   //
	
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

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getPASSWORDS() {
		return PASSWORDS;
	}

	public void setPASSWORDS(String pASSWORDS) {
		PASSWORDS = pASSWORDS;
	}

	public String getUSER_TYPE() {
		return USER_TYPE;
	}

	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}

	public String getUSER_MOBILE() {
		return USER_MOBILE;
	}

	public void setUSER_MOBILE(String uSER_MOBILE) {
		USER_MOBILE = uSER_MOBILE;
	}

	public String getUSER_STATE() {
		return USER_STATE;
	}

	public void setUSER_STATE(String uSER_STATE) {
		USER_STATE = uSER_STATE;
	}

	public String getCABINET_ID() {
		return CABINET_ID;
	}

	public void setCABINET_ID(String cABINET_ID) {
		CABINET_ID = cABINET_ID;
	}

	public String getCABINET_NO() {
		return CABINET_NO;
	}

	public void setCABINET_NO(String cABINET_NO) {
		CABINET_NO = cABINET_NO;
	}

	public String getSEAL_NO() {
		return SEAL_NO;
	}

	public void setSEAL_NO(String sEAL_NO) {
		SEAL_NO = sEAL_NO;
	}
	
}
