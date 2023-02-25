package com.test.facade.controller;


import com.test.application.UseFunctionalInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class CallFunctionalController {

    @GetMapping("/convert/{id}")
    public String functionalConvert(@PathVariable Integer id) {
        UseFunctionalInterface useConverter = new UseFunctionalInterface();
        return useConverter.useConverter(id);
    }

}
