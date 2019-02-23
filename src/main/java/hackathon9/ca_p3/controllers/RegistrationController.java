package hackathon9.ca_p3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
public class RegistrationController {

    @GetMapping(value = "/register")
    public void register(HttpServletResponse response) {
        Cookie cookie = new Cookie("userId", UUID.randomUUID().toString());
        response.addCookie(cookie);
    }
}
