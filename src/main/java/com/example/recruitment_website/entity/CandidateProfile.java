package com.example.recruitment_website.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "candidateProfiles")
public class CandidateProfile {
//    ProfileID INT
//    CandidateID INT
//    JobPostingID INT
//    CV VARCHAR(255)
//    Status VARCHAR(255)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String cv;
    String status;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name =  "jobPosting_id")
    private JobPosting jobPosting;
}
