package com.cruduser.app.springboot_simplecrud_mysql.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllers {

    @GetMapping("/")
    public String getPage(){
        return "Welcome";
    }
}
