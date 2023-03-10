package com.manager.peoplemanager;

import com.manager.peoplemanager.controller.PersonController;
import com.manager.peoplemanager.repository.PersonRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={})
@Configuration
//@EnableJpaRepositories(basePackageClasses = PersonRepository.class)
public class PeopleManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleManagerApplication.class, args);
	}

}
