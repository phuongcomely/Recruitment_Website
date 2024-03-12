package com.example.recruitment_website.repository;

import com.example.recruitment_website.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
