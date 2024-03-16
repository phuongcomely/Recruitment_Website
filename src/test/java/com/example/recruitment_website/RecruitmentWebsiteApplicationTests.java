package com.example.recruitment_website;


import com.example.recruitment_website.entity.Account;
import com.example.recruitment_website.entity.Company;
import com.example.recruitment_website.entity.JobPosting;
import com.example.recruitment_website.repository.CompanyRepository;
import com.example.recruitment_website.repository.JobPostingRepository;
import com.github.slugify.Slugify;
import com.example.recruitment_website.model.enums.Role;
import com.example.recruitment_website.repository.AccountRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@SpringBootTest
class RecruitmentWebsiteApplicationTests {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private JobPostingRepository jobPostingRepository;

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
	@Test
	void save_all_company() {
		Faker faker = new Faker(); // Faker data
		Slugify slugify = Slugify.builder().build(); // Generate slug

		for(int i=0; i< 20; i++){
			String name = faker.company().name();
			//String companyPhone = faker.phoneNumber().cellPhone();
			String companyPhone = faker.phoneNumber().cellPhone().replaceAll("\\D", "");
			String website = faker.internet().url();
			String field = faker.job().title();
			Date taxDate = faker.date().birthday();
			String placeOfTax = faker.address().country();
	//		boolean status = faker.bool().bool();
	//		Date createdAt = faker.date().birthday();
	//		Date publishedAt = null;
			Company company = Company.builder()
					.companyName(name)
					.slug(slugify.slugify(name))
					.logo(generateLinkImage(name))
					.companyEmail(faker.internet().emailAddress())
					.companyPhone(companyPhone)
					.companyWebsite(website)
					.field(field)
					.personnalSize(faker.lorem().sentence())
					.address(faker.address().fullAddress())
					.taxCode(faker.number().randomDigit())
					.taxDate(taxDate)
					.placeOfTax(placeOfTax)
					.video(generateLinkVideo(name)) // Ví dụ, bạn có thể thay thế bằng phương thức phù hợp
					.build();

			companyRepository.save(company);
			}

		}
		@Test
		void save_all_jobPosting(){
			List<Company> listCompany = companyRepository.findAll();
			Faker faker = new Faker(); // Faker data
			Slugify slugify = Slugify.builder().build(); // Generate slug
			List<String> typeOfWordList = Arrays.asList("fulltime", "parttime");
			for(int i=0; i<30; i++){
				int experienceYears = faker.number().numberBetween(0, 21); // Kinh nghiệm từ 0 đến 20 năm


				List<Company> rdCompanyList = new ArrayList<>();
				for (int j = 0; j < faker.number().numberBetween(1, 5); j++) {
					Company rdCompany = listCompany.get(faker.number().numberBetween(0, listCompany.size()));
					if (!rdCompanyList.contains(rdCompany)) {
						rdCompanyList.add(rdCompany);
					}
				}
				String title = faker.job().title();
				String specialized = faker.job().field();
				String job = faker.job().position();
				Integer quantity = faker.number().numberBetween(1, 11);
				String typeOfWord = typeOfWordList.get(faker.number().numberBetween(0, typeOfWordList.size()));
				String sex = faker.demographic().sex();
				String experience = experienceYears + " năm";
				Integer salary = faker.number().numberBetween(10000, 20000);
				String address = faker.address().fullAddress();
				String describe = faker.lorem().paragraph();
				String request = faker.lorem().sentence();
				String benefits = faker.lorem().sentence();
				String[] statusOptions = {"đã duyệt", "chờ duyệt", "hết hạn"};
				String status = statusOptions[faker.number().numberBetween(0, statusOptions.length)];
				// Tạo ngày hết hạn ngẫu nhiên trong tương lai
				Date deadline = faker.date().future(30, TimeUnit.DAYS);

				// Tạo ngày đăng bài ngẫu nhiên trong khoảng thời gian trước ngày deadline
				Date postingDate = faker.date().past(30, TimeUnit.DAYS);

				// Nếu ngày đăng bài sau ngày hết hạn, ta cần tạo lại
				while (postingDate.after(deadline)) {
					postingDate = faker.date().past(30, TimeUnit.DAYS);
				}

				JobPosting jobPosting = JobPosting.builder()
						.title(title)
						.specialized(specialized)
						.job(job)
						.quantity(quantity)
						.typeOfWord(typeOfWord)
						.sex(sex)
						.experience(experience)
						.salary(salary)
						.address(address)
						.descirbe(describe)
						.request(request)
						.benefits(benefits)
						.deadline(deadline)
						.status(status)
						.postingDate(postingDate)
						.build();
			jobPostingRepository.save(jobPosting);


			}
		}
		// get first character from string, and to uppercase
	private static String getCharacter(String str) {
		return str.substring(0, 1).toUpperCase();
	}

	// generate link author avatar follow struct : https://placehold.co/200x200?text=[...]
	public static String generateLinkImage(String name) {
		return "https://placehold.co/200x200?text=" + getCharacter(name);
	}
	private String generateLinkVideo(String companyName) {
		// Giả định rằng bạn có một URL cơ sở cho video
		String baseVideoUrl = "https://example.com/videos/";

		// Tạo một phần của URL dựa trên tên công ty
		String videoName = companyName.toLowerCase().replace(" ", "_");

		// Trả về liên kết hoàn chỉnh
		return baseVideoUrl + videoName;
	}
}

