package org.serratec.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.HttpConstraint;

@RestController
public class StatusController {

    @GetMapping(path = "/api/status")
    @ResponseStatus(HttpStatus.OK)
    public String check(){
        return "Runing...";
    }
}
