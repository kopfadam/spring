package com.apress.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.apress.todo")
public class TodoInMemoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoInMemoryApplication.class, args);
	}

}
