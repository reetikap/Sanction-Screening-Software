package com.cbp.sanctions.util;

import java.util.regex.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cbp.sanctions.models.PaymtTransaction;
import com.sun.tools.sjavac.Log;

@Service
public class Validation {
	
	public static boolean isValidAccNo(String s)
    {
    Pattern p = Pattern.compile("^\\d{9,12}$");
    Matcher m = p.matcher(s);
    return (m.find() && m.group().equals(s));
    }
	public static boolean isValidName(String s)
	{

	Pattern p = Pattern.compile("^\\w*$");
	Matcher m = p.matcher(s);
	return (m.find() && m.group().equals(s));
	}
	public static boolean isValidRef(String s)
	{

	Pattern p = Pattern.compile("^\\w*$");
	Matcher m = p.matcher(s);
	return(m.find() && m.group().equals(s));
	}
	public static boolean isValidAmt(String s)
	{

	Pattern p = Pattern.compile("^(?!$)\\d{0,10}(?:\\.\\d{1,2})?$");

	Matcher m = p.matcher(s);
	return (m.find() && m.group().equals(s));
	}
	public static boolean isValidDate(String s)
	{
		String str=String.valueOf(java.time.LocalDate.now());
    	String currDate=str.substring(8,10)+str.substring(5,7)+str.substring(0,4);
    	return s.equals(currDate);
	}
	public boolean isValid(PaymtTransaction transaction) 
	{
		return (isValidAccNo(transaction.getPayeeAccNo()) && isValidAccNo(transaction.getPayerAccNo()) &&
				isValidName(transaction.getPayeeName()) && isValidName(transaction.getPayerName()) &&
				isValidRef(transaction.getRef()) && isValidAmt(String.valueOf(transaction.getAmount())) &&
				isValidDate(String.valueOf(transaction.getDate())));
	}
}
