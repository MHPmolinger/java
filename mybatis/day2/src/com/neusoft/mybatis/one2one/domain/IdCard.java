package com.neusoft.mybatis.one2one.domain;
//���֤ʵ��
public class IdCard {
   private int cid;//������
   private String cardNo;//���֤����
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
