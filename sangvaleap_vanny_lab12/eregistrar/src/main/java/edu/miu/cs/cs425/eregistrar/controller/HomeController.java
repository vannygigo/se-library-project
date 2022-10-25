package edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/", "", "/eregister", "/eregister/public" })
public class HomeController {

    @GetMapping(value = { "", "/home" })
    public String displayHomepage() {
        return "public/index";
    }

    @GetMapping(value = { "/secured/home", "/eregister/secured/home" })
    public String home2() {
        return "secured/index";
    }

    @GetMapping(value = { "/about" })
    public String about() {
        return "public/about";
    }

    @GetMapping(value = { "/virtualtour" })
    public String virtualtour() {
        return "public/virtualtour";
    }
}
