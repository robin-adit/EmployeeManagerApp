package com.robin.empmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;



@Builder
//@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phoneNumber;
    private String imageUrl;
    @Column(nullable = false,updatable = false)
    private String employeeCode;
}
