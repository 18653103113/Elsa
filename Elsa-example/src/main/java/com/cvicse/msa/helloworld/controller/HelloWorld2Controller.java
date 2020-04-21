package com.cvicse.msa.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld2Controller {

    @ResponseBody
    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public String sayHello(){
        return "您好，世界2";
    }

}
