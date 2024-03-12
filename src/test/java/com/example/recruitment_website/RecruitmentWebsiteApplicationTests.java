package com.example.recruitment_website;


import com.example.recruitment_website.entity.Account;
import com.example.recruitment_website.model.enums.Role;
import com.example.recruitment_website.repository.AccountRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
class RecruitmentWebsiteApplicationTests {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	void save_all_account() {
		Faker faker = new Faker(); // Dữ liệu giả mạo
		for (int i = 0; i < 20; i++) {
			Role role = (i == 0 || i == 1 || i == 2) ? Role.ADMIN : (i % 2 == 0 ? Role.CANDIDATE : Role.EMPLOYER);

			Account account = Account.builder()
					.email(faker.internet().emailAddress())
					.password(bCryptPasswordEncoder.encode("123"))
					.role(role)
					.build();
			accountRepository.save(account); // Lưu vào cơ sở dữ liệu
		}
	}

}
