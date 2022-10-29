package edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping(value = { "/public/login", "/eregister/public/login" })
    public String login() {
        return "public/login";
    }
}
