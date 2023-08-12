package com.cbp.sanctions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbp.sanctions.models.PaymtTransaction;
import com.cbp.sanctions.repository.TransactionDAO;

@Service
public class ViewService {
	@Autowired
	TransactionDAO dao;
	public List<PaymtTransaction> view() {
		return dao.view();
	}
}
