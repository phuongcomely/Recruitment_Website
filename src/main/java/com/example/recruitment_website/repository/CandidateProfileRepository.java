package com.example.recruitment_website.repository;

import com.example.recruitment_website.entity.CandidateProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile, Integer> {
}
