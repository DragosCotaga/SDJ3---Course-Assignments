package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController is a web controller that handles requests for the home page.
 */

@RestController
@RequestMapping("/api")
@Controller
public class HomeController {

    /**
     * Returns the name of the home page view template.
     *
     * @return the name of the home page view template (index)
     */

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
