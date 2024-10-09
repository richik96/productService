package com.example.product_service_oct24.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/world")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/{name}")
    public String helloUniverse(@PathVariable String name) {
        return "Hello Universe! " +name;
    }

    @RequestMapping("/uranus")
    public String helloUranus() {
        return "Hello Uranus!";
    }
}
