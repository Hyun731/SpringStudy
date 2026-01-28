package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DigdaApplication {
	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(DigdaApplication.class, args);
        String[] allBeanNames = ac.getBeanDefinitionNames();
        for (String beanName : allBeanNames){
            if (beanName.contains("helloController")){
                System.out.println("컨트롤러 " + beanName);
            }
        }
	}
}
