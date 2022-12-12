package com.harsh.CoustomerCURDApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "HOUSE_NO")
    private String houseNo;
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Column(name = "STREET_ADDRESS2")
    private String streetAddress2;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "IS_MAIN")
    private Boolean isMain = Boolean.FALSE;

}
