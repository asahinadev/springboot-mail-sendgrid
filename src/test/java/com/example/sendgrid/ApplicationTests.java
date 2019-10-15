package com.example.sendgrid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Value("${spring.mail.username}")
	String mailUser;

	@Value("${spring.mail.password}")
	String mailPass;

	@Value("${app.mail.test.from}")
	String mailTestFrom;

	@Value("${app.mail.test.to}")
	String mailTestTo;

	@Autowired
	MailSender mailSender;

	@Test
	public void contextLoads() {
	}

	@Test
	public void mailsenderTest() {

		log.info("spring.mail.username: {}", mailUser);
		log.info("spring.mail.password: {}", mailPass);
		log.info("app.mail.test.from  : {}", mailTestTo);
		log.info("app.mail.test.to    : {}", mailTestFrom);

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(mailTestFrom);
		mail.setTo(mailTestTo);
		mail.setSubject("[SEND GRID] 送信テスト");
		mail.setText("テスト送信です");

		mailSender.send(mail);

	}

}
