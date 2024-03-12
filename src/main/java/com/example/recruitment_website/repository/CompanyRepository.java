package com.example.recruitment_website.repository;

import com.example.recruitment_website.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
