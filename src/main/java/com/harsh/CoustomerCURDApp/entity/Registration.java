package com.harsh.CoustomerCURDApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REGISTRATION")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "registration_id",referencedColumnName = "id")
    private List<Address> addresses;

    @Column(name = "EMAIL")
    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;
    @Pattern(regexp = "^\\d{10}$")
    @Column(name = "PHONE_NO")
    private String phoneNo;
}
