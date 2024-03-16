package com.example.recruitment_website.controller;

import com.example.recruitment_website.entity.Company;
import com.example.recruitment_website.entity.JobPosting;
import com.example.recruitment_website.service.CompanyService;
import com.example.recruitment_website.service.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequiredArgsConstructor
public class WebController {
    private  final CompanyService companyService;
    private final JobPostingService jobPostingService;

    @GetMapping("/")
    public String getHomePage(Model model){
        List<Company> listCompanyHot = companyService.getCompanyHot(8);
        List<JobPosting> listJobPostingHurry = jobPostingService.getJobPostingHurry( "đã duyệt", 6 );

        model.addAttribute("listCompanyHot", listCompanyHot);
        model.addAttribute("listJobPostingHurry", listJobPostingHurry);

        return ("client/index");

    }
}
