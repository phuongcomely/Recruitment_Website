package com.example.recruitment_website.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "companies")
public class Company {
//    CompanyID int [primary key]
//    Logo VARCHAR(255)
//    CompanyName VARCHAR(255)
//    CompanyEmail VARCHAR(255)
//    CompanyPhone INT
//    Website  VARCHAR(255)
//    Field  VARCHAR(255) //Lĩnh vực
//    PersonnelSize VARCHAR(255) //quy mô hđ
//    Address VARCHAR(255)
//    TaxCode int //mã thuế
//    TaxDate date
//    PlaceOfTax VARCHAR(255)
//    Video VARCHAR(255)
//    Describe VARCHAR(255)
//    EmployerID int
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
     Integer id;
    String logo;
    String companyName;
    String companyEmail;
    Integer companyPhone;
    String companyWebsite;
    String field;
    String personnelSize;
    String address;
    Integer taxCode;
    Date taxDate;
    String placeOfTax;
    String video;

    @OneToMany(mappedBy = "id")
    private List<Employer> employers;

    @Column(name = "employer_id") // Thêm cột account_id để lưu trữ id của tài khoản trong bảng Admin
    private Integer employerId;
}
