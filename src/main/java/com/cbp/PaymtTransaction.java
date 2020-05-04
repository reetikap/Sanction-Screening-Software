package com.cbp;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
public class PaymtTransaction {
	
//@Id
String ref;

//@Column(name="Payee Name")
String payeeName;

//@Column(name="Payer Name")
String payerName;

//@Column(name="Payer Acc No")
String payerAccNo;

//@Column(name="Payee Acc No")
String payeeAccNo;

//@Column(name="Date")
int date;

//@Column(name="Amount")
double amount;

//@Column(name="Validation status")
String v;

//@Column(name="Sanction screening status")
String s;

public String getV() {
	return v;
}
public void setV(String v) {
	this.v = v;
}
public String getS() {
	return s;
}
public void setS(String s) {
	this.s = s;
}

public String getRef() {
	return ref;
}
public void setRef(String ref) {
	this.ref = ref;
}
public String getPayeeName() {
	return payeeName;
}
public void setPayeeName(String payeeName) {
	this.payeeName = payeeName;
}
public String getPayerName() {
	return payerName;
}
public void setPayerName(String payerName) {
	this.payerName = payerName;
}
public String getPayerAccNo() {
	return payerAccNo;
}
public void setPayerAccNo(String payerAccNo) {
	this.payerAccNo = payerAccNo;
}
public String getPayeeAccNo() {
	return payeeAccNo;
}
public void setPayeeAccNo(String payeeAccNo) {
	this.payeeAccNo = payeeAccNo;
}
public int getDate() {
	return date;
}
public void setDate(int date) {
	this.date = date;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
}
