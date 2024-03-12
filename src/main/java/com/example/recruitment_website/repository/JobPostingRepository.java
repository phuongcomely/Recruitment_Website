package com.example.recruitment_website.repository;

import com.example.recruitment_website.entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting, Integer> {
}
