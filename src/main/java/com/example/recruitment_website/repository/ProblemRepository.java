package com.example.recruitment_website.repository;

import com.example.recruitment_website.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Integer> {
}
