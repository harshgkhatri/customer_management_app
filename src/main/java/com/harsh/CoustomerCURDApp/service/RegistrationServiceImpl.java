package com.harsh.CoustomerCURDApp.service;

import com.harsh.CoustomerCURDApp.entity.Address;
import com.harsh.CoustomerCURDApp.entity.Registration;
import com.harsh.CoustomerCURDApp.repository.AddressRepository;
import com.harsh.CoustomerCURDApp.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Registration saveDetails(Registration registration) {
        boolean email = registration.getEmail().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        boolean phone = registration.getPhoneNo().matches("^\\d{10}$");
        int sizee=registration.getAddresses().size();
        if(sizee>6 || sizee==0)
            throw new RuntimeException("Please Enter the address at most 5 , less then 5 addresses and more then 1 are allowed");
        if (!email || !phone)
            throw new RuntimeException("Email or phone number not valid");

        int matched=registration.getAddresses().stream().filter(r->r.getIsMain().equals(true)).collect(Collectors.toList()).size();
        if(matched >1 || matched<1)
            throw new RuntimeException("Please Enter the attlist 1 address or select 1 address as your main address");

        registrationRepository.save(registration);
        return registration;

    }

    @Override
    public Page<Registration> getAllCoustomer(int size, int page) {
        return registrationRepository.findAll(PageRequest.of(page,size, Sort.by(Sort.Direction.ASC,"firstName")));
    }

    @Override
    public Registration getCustomerById(Long id) {
        return registrationRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteCustomerById(Long id) {
         registrationRepository.deleteById(id);
        return id+" Number Customer is deleted.";
    }

    @Override
    public String deleteAllCustomer() {
        registrationRepository.deleteAll();
        return "All Customer is Deleted";
    }

    @Override
    public Registration dl(Registration registration) {

        Optional<Registration> registrationOptional = registrationRepository.findById(registration.getId());
        if(!registrationOptional.isPresent()){
            throw new RuntimeException("id is not present");
        }
        Registration registrationOrg = registrationOptional.get();
        List<Long> addressIdList = registrationOrg.getAddresses().stream().map(Address::getId).collect(Collectors.toList());
        addressRepository.deleteAllById(addressIdList);

        addressRepository.deleteById(addressIdList.get(0));

        addressRepository.deleteAll();


        return null;
    }

    @Override
    public Registration update(Long id, Registration registration) {
        Optional<Registration> reg=registrationRepository.findById(id);
            if(reg.isPresent()){
                Registration regi=reg.get();

                if(registration.getFirstName()!=null)
                    regi.setFirstName(registration.getFirstName());

                if(registration.getLastName()!=null)
                    regi.setLastName(registration.getLastName());

                if(registration.getAddresses()!=null)
                    regi.setAddresses(registration.getAddresses());

                if(registration.getEmail()!=null)
                    regi.setEmail(registration.getEmail());

                if(registration.getPhoneNo()!=null)
                    regi.setPhoneNo(registration.getPhoneNo());

                return registrationRepository.save(regi);
            }
            else {
                throw new RuntimeException("Error while update customer");
            }
    }
}
