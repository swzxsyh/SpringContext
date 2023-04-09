package com.test.facade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public ModelAndView hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("name", name);
        return mav;
    }
}
