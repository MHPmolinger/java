package com.neusoft.atm.domain;

import java.util.Date;

public class Account {

	private int id;
	private String cardNo;//银行卡号 
	private String loginPwd;//登录密码
	private String bankName;//所属的银行名称
	private int cardType=0;//银行卡的类型，如0代表普通的存储卡，1代表信用卡
	private Double balance;//银行卡的余额
	private Date createTime;
	private User user;//表示卡所属的用户
	private int bankStatus=0;//卡的当前状态 
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getBankStatus() {
		return bankStatus;
	}
	public void setBankStatus(int bankStatus) {
		this.bankStatus = bankStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account() {
		//1.自动生成一个19位的卡号
		while(true){
			String cardNo=""+System.currentTimeMillis()+(int)(Math.random()*987654321);
			//截取该字符串的后19位
			if(cardNo.length()>19){
				this.cardNo=cardNo.substring(cardNo.length()-19);
				break;
			}
		}
		
		//2.产生一个默认的6为密码
		while(true){
			String number=""+(long)(Math.random()*987654321);
			if(number.length()==6){
				this.loginPwd=number;
				break;
			}
		}
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", cardNo=" + cardNo + ", loginPwd="
				+ loginPwd + ", bankName=" + bankName + ", cardType="
				+ cardType + ", balance=" + balance + ", user=" + user
				+ ", bankStatus=" + bankStatus + "]";
	}
	
	
	
}
