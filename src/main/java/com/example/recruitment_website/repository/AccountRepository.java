package com.example.recruitment_website.repository;

import com.example.recruitment_website.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Integer> {

}
