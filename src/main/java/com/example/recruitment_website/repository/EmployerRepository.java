package com.example.recruitment_website.repository;

import com.example.recruitment_website.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {
}
