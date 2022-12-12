package com.harsh.CoustomerCURDApp.service;

import com.harsh.CoustomerCURDApp.entity.Registration;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RegistrationService {


    Registration saveDetails(Registration registration);

    Page<Registration> getAllCoustomer(int size, int page);

    Registration getCustomerById(Long id);

    String deleteCustomerById(Long id);

    String deleteAllCustomer();

//    Registration updateCustomerById(Registration registration);

    Registration dl(Registration registration);

    Registration update(Long id, Registration registration);
}
