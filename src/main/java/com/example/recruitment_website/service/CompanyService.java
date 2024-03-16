package com.example.recruitment_website.service;

import com.example.recruitment_website.entity.Company;
import com.example.recruitment_website.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    //lấy tất cả  công ty
    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }
    public  List<Company> getCompanyHot(Integer size){
        return companyRepository
                .findAll()
                .stream().limit(size)
                .toList();
    }

}
