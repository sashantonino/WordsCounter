package com.gladunalexander.wordcounter.controller;

import com.gladunalexander.wordcounter.domain.Feedback;
import com.gladunalexander.wordcounter.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by user on 12/09/2017.
 */

@Controller
public class WelcomeController {

    private static final String WELCOME_LOCATION = "http://localhost:8080/templates/index.html";

    @Autowired
    private EmailService emailService;

    @RequestMapping("/")
    public void welcome(HttpServletResponse response) {
       response.setHeader("Location", WELCOME_LOCATION);
       response.setStatus(HttpStatus.FOUND.value());
    }

    @RequestMapping(value = "/sendFeedback", method = RequestMethod.POST)
    public void sendEmail(@RequestBody Feedback feedback){
        emailService.sendMessage(feedback);
    }
}
