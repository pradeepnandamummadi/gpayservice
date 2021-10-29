package com.mpn.service;

import com.mpn.dto.AmountTransferRequest;
import com.mpn.exception.UserDefinedException;

public interface AmountTransferService {
	String fundTransfer( AmountTransferRequest fundTransferRequest) throws UserDefinedException;
	//List<GetStatementRequest> getMonthlyStatement(long accountNo, int month, int year) throws UserDefinedException;

}
