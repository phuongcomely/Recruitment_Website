package com.example.recruitment_website.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "saveJobs")
public class SaveJob {
//    CandidateID int
//    JobPostingID int
//    SaveDate date
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Date date;

    @ManyToOne
    @JoinColumn(name = "jobPosting_id")
    private  JobPosting jobPosting;
}
