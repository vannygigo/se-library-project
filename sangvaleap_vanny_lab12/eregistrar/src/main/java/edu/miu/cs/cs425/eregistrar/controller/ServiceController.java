package edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {

    @GetMapping(value = { "/secured/service", "/eregister/secured/service" })
    public String services() {
        return "secured/service";
    }

}
