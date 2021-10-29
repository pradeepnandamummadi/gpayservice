package com.mpn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpn.entity.Transaction;
import com.mpn.exception.UserDefinedException;
import com.mpn.respositry.TransactionRepository;
import com.mpn.service.StatementService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class StatementServiceImpl implements StatementService {


	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Transaction> getStatement(int pageNo, int pageSize) throws UserDefinedException {
		
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Transaction> pagedResult = transactionRepository.findAll(paging);

        return pagedResult.toList();
		
	}	
}