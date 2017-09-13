package com.gladunalexander.wordcounter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by user on 12/09/2017.
 */

@Controller
public class WelcomeController {

    private static final String WELCOME_LOCATION = "http://localhost:8080/templates/index.html";

    @RequestMapping("/")
    public void welcome(HttpServletResponse response) {
       response.setHeader("Location", WELCOME_LOCATION);
       response.setStatus(HttpStatus.FOUND.value());
    }
}
