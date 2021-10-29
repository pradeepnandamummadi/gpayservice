package com.mpn.respositry;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mpn.entity.Transaction;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
	
}
