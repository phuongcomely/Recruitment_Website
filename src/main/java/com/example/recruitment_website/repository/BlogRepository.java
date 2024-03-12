package com.example.recruitment_website.repository;

import com.example.recruitment_website.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
