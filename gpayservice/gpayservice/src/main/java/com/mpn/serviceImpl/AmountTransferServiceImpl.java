package com.mpn.serviceImpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpn.dto.AmountTransferRequest;
import com.mpn.entity.GooglePay;
import com.mpn.entity.Transaction;
import com.mpn.exception.UserDefinedException;
import com.mpn.respositry.GooglePayRepository;
import com.mpn.respositry.TransactionRepository;
import com.mpn.service.AmountTransferService;

@Service
public class AmountTransferServiceImpl implements AmountTransferService {


	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private GooglePayRepository payeeRepository;

	@Override
	public String fundTransfer(AmountTransferRequest fundTransferRequest) throws UserDefinedException {

		GooglePay fromPayee = payeeRepository.findByPhoneNumber(fundTransferRequest.getFromPhoneNumber());
		if(fromPayee == null) {
			return "From Phonumber is not a valid number";
		}
		GooglePay toPayee = payeeRepository.findByPhoneNumber(fundTransferRequest.getToPhoneNumber());
		if(toPayee == null) {
			return "To Phonumber is not a valid number";
		}

		Transaction transaction = new Transaction();
		// to set local time
		java.util.Date date = new java.util.Date();
		long time = date.getTime();
		Timestamp transactiondate = new Timestamp(time);
		transaction.setTransactionDate(transactiondate);
		transaction.setAmount(fundTransferRequest.getAmount());
		transaction.setFromPhoneNumber(fundTransferRequest.getFromPhoneNumber());
		transaction.setToPhoneNumber(fundTransferRequest.getToPhoneNumber());	
		transaction.setComments(fundTransferRequest.getComments());	
		transactionRepository.save(transaction);

		return "Fund transfer is succesful";
	}
}