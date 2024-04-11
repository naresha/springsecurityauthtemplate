package com.example.authtemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/hello")
    public String hello(Principal principal) {
        LOGGER.info("Principal: {}", principal);
        return "Hello";
    }
}
