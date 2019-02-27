package com.elina.acnspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
	
	@GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello!";
    }

}