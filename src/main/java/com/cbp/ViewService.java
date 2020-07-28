package com.cbp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewService {
	@Autowired
	TransactionDAO dao;
	public List<PaymtTransaction> view() {
		return dao.view();
	}
}
