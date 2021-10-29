package com.mpn.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpn.dto.AmountTransferRequest;
import com.mpn.exception.UserDefinedException;
import com.mpn.service.AmountTransferService;

@RestController
@RequestMapping("/fundtransfer")
public class AmountTransferController {

	@Autowired
	private AmountTransferService transactionService;  
	
	@PostMapping
	public ResponseEntity<String> fundTransfer(@Valid @RequestBody AmountTransferRequest fundTransferRequestDTO)
			throws UserDefinedException {
		String response = transactionService.fundTransfer(fundTransferRequestDTO);

		 return new ResponseEntity<String>(response,HttpStatus.OK);

	}
}
