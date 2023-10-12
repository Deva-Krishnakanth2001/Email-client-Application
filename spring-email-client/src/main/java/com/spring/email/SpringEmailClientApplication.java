package com.spring.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;



@SpringBootApplication
public class SpringEmailClientApplication {
	
	@Autowired
	public emailSenderService emailService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);	
	}
	
	
	@EventListener()
	public void trigger(ApplicationReadyEvent event) throws MessagingException {
		
		
		//emailService.sendSimpleEmail("devakrishnakanth61@gmail.com", "this is a body messagge", "this is a subject msg");
		emailService.sendEmailWithAttachments("devakrishanakanth61@gmail.com", "this a body message", "this is a subject "
				, "C:\\Users\\shopp\\OneDrive\\Pictures\\Screenshots\\Screenshot (2).png");
	}
	
}
