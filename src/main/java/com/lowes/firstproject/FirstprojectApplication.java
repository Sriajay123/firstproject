package com.lowes.firstproject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class FirstprojectApplication  {

	private static final Logger log = LoggerFactory.getLogger(FirstprojectApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstprojectApplication.class, args);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for(String temp:beanDefinitionNames){
			System.out.println(temp);
		}


	}


}
