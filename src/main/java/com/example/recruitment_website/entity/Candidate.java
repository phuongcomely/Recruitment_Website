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
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
    Integer id;

    String name;
    String sex;
    Date birthday;
    String address;
    Integer phone;
    String job;
    String experience;
    String Academic;
    String desiredJob;


    @Column(columnDefinition = "TEXT")
    String descirbe;

    @OneToMany(mappedBy = "id")
    private List<Account> accounts;
    @Column(name = "account_id") // Thêm cột account_id để lưu trữ id của tài khoản trong bảng Admin
    private Integer accountId;

}
