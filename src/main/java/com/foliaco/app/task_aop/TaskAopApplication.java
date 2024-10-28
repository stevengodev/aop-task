package com.foliaco.app.task_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class TaskAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskAopApplication.class, args);
	}

}
