package com.cbp;

import java.util.regex.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
		return (isValidAccNo(transaction.payeeAccNo) && isValidAccNo(transaction.payerAccNo) &&
				isValidName(transaction.payeeName) && isValidName(transaction.payerName) &&
				isValidRef(transaction.ref) && isValidAmt(String.valueOf(transaction.amount)) &&
				isValidDate(String.valueOf(transaction.date)));
	}
}
