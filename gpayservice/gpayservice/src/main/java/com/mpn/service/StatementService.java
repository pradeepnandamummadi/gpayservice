package com.mpn.service;



import java.util.List;

import com.mpn.entity.Transaction;
import com.mpn.exception.UserDefinedException;

public interface StatementService {
	List<Transaction> getStatement(int pageNo, int pageSize) throws UserDefinedException;
}
