package com.mpn.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpn.dto.RegisterRequest;
import com.mpn.entity.GooglePay;
import com.mpn.exception.UserDefinedException;
import com.mpn.respositry.GooglePayRepository;
import com.mpn.service.GooglePayRegisterService;

@Service
public class GooglePayRegisterServiceImpl implements GooglePayRegisterService {

	@Autowired
	public GooglePayRepository payeeRepository;

	@Override
	public String register(RegisterRequest[] registerRequest) throws UserDefinedException{

		for(int i=0; i < registerRequest.length ; i++) {


			GooglePay payee = new GooglePay();

			if (payeeRepository.findByPhoneNumber(registerRequest[i].getPhoneNumber()) == null) {

				payee.setFirstName(registerRequest[i].getFirstName());
				payee.setLastName(registerRequest[i].getLastName());
				payee.setEmailId(registerRequest[i].getEmailId());
				payee.setPhoneNumber(registerRequest[i].getPhoneNumber());

				payeeRepository.save(payee);

			}
			else {
				throw new UserDefinedException("This Phone Number is already registered :"+registerRequest[i].getPhoneNumber() );
			}
		}
		return "Payees registered successfully";
	}

}