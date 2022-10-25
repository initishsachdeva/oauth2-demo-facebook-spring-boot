package com.example.oauth2demofbspringboot.restcontrollers;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(Principal principal) {
        Map<String, Object> authDetails = (Map<String, Object>) ((OAuth2Authentication) principal)
                .getUserAuthentication()
                .getDetails();
        String userName = (String) authDetails.get("name");
        return "Hey " + userName + ", Happy Diwali !!";
    }
}
