package com.cbp.sanctions.models;


public class PaymtTransaction {
	

String ref;


String payeeName;


String payerName;


String payerAccNo;


String payeeAccNo;


String date;


public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
double amount;


String valid;


String sanctioned;

long id;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getValid() {
	return valid;
}
public void setValid(String valid) {
	this.valid = valid;
}
public String getSanctioned() {
	return sanctioned;
}
public void setSanctioned(String sanctioned) {
	this.sanctioned = sanctioned;
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

public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
}
