package com.example.recruitment_website.repository;

import com.example.recruitment_website.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
