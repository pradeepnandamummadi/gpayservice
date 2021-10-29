package com.mpn.respositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpn.entity.GooglePay;

public interface GooglePayRepository extends JpaRepository<GooglePay,Long>{
GooglePay findByPhoneNumber(String phoneNumber);
}
