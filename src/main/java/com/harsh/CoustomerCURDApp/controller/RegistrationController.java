package com.harsh.CoustomerCURDApp.controller;

import com.harsh.CoustomerCURDApp.entity.Registration;
import com.harsh.CoustomerCURDApp.repository.RegistrationRepository;
import com.harsh.CoustomerCURDApp.service.AddressService;
import com.harsh.CoustomerCURDApp.service.AddressServiceImpl;
import com.harsh.CoustomerCURDApp.service.RegistrationService;
import com.harsh.CoustomerCURDApp.service.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Registration")
//@Validated
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private AddressService addressService;
    @Autowired
    private RegistrationRepository registrationRepository;


    @PostMapping("/")
    public Registration saveDetails(@Valid @RequestBody Registration registration){
        System.out.println("from save Datails");
        return registrationService.saveDetails(registration);
    }

    @GetMapping("/get")
    public Page<Registration> getAllCustomer(@RequestParam(defaultValue = "2",required = false)int size, @RequestParam(defaultValue = "0",required = false) int page){
        return registrationService.getAllCoustomer(size,page);
    }

    @GetMapping("get/{id}")
    public Registration getCustomerById(@PathVariable Long id){
        return registrationService.getCustomerById(id);
    }


    @PutMapping("/{id}")
    public Registration update(@PathVariable Long id, @RequestBody Registration registration) {
        return registrationService.update(id, registration);
    }


    @DeleteMapping("dl")
    public Registration dl(@RequestBody Registration registration){
        return registrationService.dl(registration);
    }


    @DeleteMapping("delete")
    public String deleteAllCustomer(){
        return registrationService.deleteAllCustomer();
    }
    @DeleteMapping("delete/{id}")
    public String deleteCustomerById(@PathVariable Long id){
        return registrationService.deleteCustomerById(id);
    }


}
