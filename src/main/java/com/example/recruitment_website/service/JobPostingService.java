package com.example.recruitment_website.service;

import com.example.recruitment_website.entity.JobPosting;
import com.example.recruitment_website.repository.JobPostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostingService {
    private final JobPostingRepository jobPostingRepository;
    public List<JobPosting> getAllJobPosting(){
        return jobPostingRepository.findAll();
    }
    public List<JobPosting> getJobPostingHurry( String status, Integer size){
        return jobPostingRepository.findByStatusOrderByPostingDateAsc( status)
                .stream().limit(size)
                .toList();


    }

}
