package com.neusoft.mybatis.one2one.domain;
//身份证实体
public class IdCard {
   private int cid;//是主键
   private String cardNo;//身份证号码
   private Person person;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}
@Override
public String toString() {
	return "IdCard [cid=" + cid + ", cardNo=" + cardNo + ", person=" + person
			+ "]";
}
   
   
}
