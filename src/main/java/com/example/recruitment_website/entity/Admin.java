package com.example.recruitment_website.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "admins")
public class Admin {
//    AdminID int [primary key]
//    AccountID int
//    Name varchar(255)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;


//    @OneToMany(mappedBy = "id")
//    List<Account> accounts;
//
//    @Column(name = "account_id") // Thêm cột account_id để lưu trữ id của tài khoản trong bảng Admin
//    private Integer accountId;


}
