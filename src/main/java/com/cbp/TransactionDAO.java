package com.cbp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
  
@Repository
public class TransactionDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
  
    @Transactional(readOnly=true)
    public List<PaymtTransaction> view() {
    	List<PaymtTransaction> list=new ArrayList();
    	String sql = "SELECT transaction_id,dt,payerName,payeeName,amount,valid,sanctioned FROM transactions";
    	 
        list = jdbcTemplate.query(sql,
        		new TransactionRowMapper());
    
        return list;
    }
    @Transactional(readOnly=true)
    public boolean searchRef(String ref) {
    	String sql = "SELECT * FROM transactions WHERE ref="+"'"+ref+"'";
   	 
        List<PaymtTransaction> list = jdbcTemplate.query(sql,
        		new TransactionRowMapper());
     
        return list.isEmpty();
    }
}
class TransactionRowMapper implements RowMapper<PaymtTransaction>
{
    @Override
    public PaymtTransaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        PaymtTransaction transaction = new PaymtTransaction();
        transaction.setId(rs.getInt("transaction_id"));
        transaction.setDate(rs.getInt("dt"));
        transaction.setPayerName(rs.getString("payerName"));
        transaction.setPayeeName(rs.getString("payeeName"));
        transaction.setAmount(rs.getInt("amount"));
        transaction.setValid(rs.getString("valid"));
        transaction.setSanctioned(rs.getString("sanctioned"));
        return transaction;
    }
}
