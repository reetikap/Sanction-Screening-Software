package com.cbp.sanctions.constants;

public class SqlConstants {
	public static String INSERT_STMT_TRANSACTION = "INSERT INTO transactions (ref,dt,payerName,payerAccNo,payeeName,payeeAccNo,amount,valid,sanctioned) VALUES (:ref,:date,:payerName,:payerAccNo,:payeeName,:payeeAccNo,:amount,:valid,:sanctioned)";
	public static String VIEW_RECORDS = "SELECT transaction_id,dt,payerName,payeeName,amount,valid,sanctioned FROM transactions";
	public static String INSERT_STMT_USER = "INSERT INTO users(username,email,password) VALUES(?,?,?)";
}
