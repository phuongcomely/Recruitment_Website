package com.example.recruitment_website.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "employers")
public class Employer {
//    EmployerID INT [primary key]
//    AccountID INT
//    Name VARCHAR(255)
//    Sex VARCHAR(255)
//    Position VARCHAR(255)//chức vụ
//    Phone INT
//    Address VARCHAR(255)
//    CompanyID INT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
    Integer id;

    String name;
    String sex;
    String position;
    Integer phone;
    String address;


    @OneToMany(mappedBy = "id")
    private List<Account> accounts;

    @Column(name = "account_id") // Thêm cột account_id để lưu trữ id của tài khoản trong bảng Admin
    private Integer accountId;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company comany;

}