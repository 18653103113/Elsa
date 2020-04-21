package com.cvicse.msa.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld1Controller {

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String sayHello(){
        return "您好，世界1";
    }

}
