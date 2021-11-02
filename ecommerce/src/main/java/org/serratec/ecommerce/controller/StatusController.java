package org.serratec.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class StatusController {

    @GetMapping(path = "/status")
    @ResponseStatus(HttpStatus.OK)
    public String check(){
        return "Runing...";
    }
}
