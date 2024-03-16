package com.example.recruitment_website.rest;

import com.example.recruitment_website.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/companies")
@RequiredArgsConstructor
public class CompanyResouce {
    private final CompanyService companyService;


}
