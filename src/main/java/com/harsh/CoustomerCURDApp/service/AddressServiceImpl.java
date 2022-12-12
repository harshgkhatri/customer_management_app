package com.harsh.CoustomerCURDApp.service;

import com.harsh.CoustomerCURDApp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;

}
