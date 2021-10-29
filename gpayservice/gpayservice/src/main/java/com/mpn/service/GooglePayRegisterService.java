package com.mpn.service;


import com.mpn.dto.RegisterRequest;
import com.mpn.exception.UserDefinedException;

public interface GooglePayRegisterService {

	String register( RegisterRequest[] RegisterRequest) throws UserDefinedException;
}
