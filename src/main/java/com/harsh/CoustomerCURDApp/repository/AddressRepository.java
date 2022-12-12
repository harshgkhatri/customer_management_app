package com.harsh.CoustomerCURDApp.repository;

import com.harsh.CoustomerCURDApp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
