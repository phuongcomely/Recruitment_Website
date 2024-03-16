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
@Table(name = "jobPostings")
public class JobPosting {
//    JobPostingID INT [primary key]
//    CompanyID int
//    Title VARCHAR(255)
//    Job VARCHAR(255)
//    Specialized VARCHAR(255) //chuyên ngành cụ thể
//    Quantity INT
//    TypeOfWork VARCHAR(255) //có fulltime, partime, bán thời gian
//    LocationID INT
//    Sex VARCHAR(255)
//    Experience VARCHAR(255)
//    Salary INT
//    Address VARCHAR(255) //địa chỉ làm việc
//    Describe VARCHAR(255) //mô tả công việc
//    Request VARCHAR(255)
//    Benefits VARCHAR(255)
//    Deadline Date
//    EmployerID INT //thông tin người nhận hồ sơ
//    Status VARCHAR(255)
//    PostingDate date //Ngày được duyệt đăng tin

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String job;
    String specialized;
    Integer quantity;
    String typeOfWord;
    String sex;
    String experience;
    Integer salary;
    String address;

    @Column(columnDefinition = "TEXT")
    String descirbe;

    String request;
    String benefits;
    Date deadline;
    String status;
    Date postingDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

}
