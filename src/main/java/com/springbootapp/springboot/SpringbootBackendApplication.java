package com.springbootapp.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbootapp.springboot.dao.UserRepository;
import com.springbootapp.springboot.model.User;

@SpringBootApplication
public class SpringbootBackendApplication
//implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
//	@Autowired
//	public   UserRepository userRepo;
//		
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//	
// 
////	this.userRepo.save(new User("Alpha","Katikala","alphaka94@gmail.com"));
////	this.userRepo.save(new User("Anish","Ravi","anishr46@gmail.com"));
////	this.userRepo.save(new User("Sathish","T S","sathishts@gmail.com"));
//
//		
//	}

}
