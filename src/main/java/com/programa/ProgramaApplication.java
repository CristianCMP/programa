package com.programa;

import com.programa.model.Person;
import com.programa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@SpringBootApplication
@RestController
public class ProgramaApplication {

/*
	@Autowired
	@Qualifier("applicationName")
	private String applicationName;

	@GetMapping("/hello")
	public String helloWord(){
		return "hello world";
	}*/

	@Bean
	public CommandLineRunner run(@Autowired PersonRepository repository){
		return args -> {
			Person person = new Person();
			person.setName("Mateus");
			person.setEmail("mateus@email.com");
			person.setTelephone("51999999");
			person.setBirth_date(LocalDate.of(1998,1,29));

			repository.save(person);
		};
	}
	public static void main(String[] args) {

		SpringApplication.run(ProgramaApplication.class, args);
	}

}
