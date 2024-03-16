package com.example.recruitment_website.repository;

import com.example.recruitment_website.entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingRepository extends JpaRepository<JobPosting, Integer> {
    List<JobPosting> findByStatusOrderByPostingDateAsc(String status);

}
