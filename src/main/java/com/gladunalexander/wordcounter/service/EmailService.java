package com.gladunalexander.wordcounter.service;

import com.gladunalexander.wordcounter.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by user on 19/09/2017.
 */

@Service
public class EmailService {

    @Autowired
    private MailSender mailSender;

    @Value("${spring.mail.username}")
    private String webMasterMail;

    public void sendMessage(final Feedback feedback){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(feedback.getEmail());
        simpleMailMessage.setTo(webMasterMail);
        simpleMailMessage.setText(feedback.getFeedback());
        simpleMailMessage.setSubject("Feedback from: " + feedback.getEmail());

        mailSender.send(simpleMailMessage);
    }
}
