package com.spring.email;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

// Author - Dkrishnakanth

@Service
@Component
public class emailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleEmail(String toEmail, String body, String subject) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("devakrishnakanth18@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
		System.out.println("Mail Sent...");

	}

	public void sendEmailWithAttachments(String toEmail, String body, String Subject,
			String Attachments) throws MessagingException {

		MimeMessage msg = mailSender.createMimeMessage();

		MimeMessageHelper mimemessagehelper = new MimeMessageHelper(msg, true);
		mimemessagehelper.setFrom("devakrishnakanth18@gmail.com");
		mimemessagehelper.setTo(toEmail);
		mimemessagehelper.setSubject(Subject);
		mimemessagehelper.setText(body);

		FileSystemResource fileSystemResource = new FileSystemResource(new File(Attachments));

		mimemessagehelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

		mailSender.send(msg);
		System.out.println("Mail send using attachments ... ");

	}

}
