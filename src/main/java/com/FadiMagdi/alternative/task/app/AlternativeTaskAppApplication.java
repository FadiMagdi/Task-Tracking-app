package com.FadiMagdi.alternative.task.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlternativeTaskAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlternativeTaskAppApplication.class, args);


	}

	//used for testing purposes

//	@Bean
//	public static CommandLineRunner getcommandlinerunner (String [] args){
//		return CommandLineRunner ->{
//		System.out.println("welcome to our task list app");
//		};
//	}

}
