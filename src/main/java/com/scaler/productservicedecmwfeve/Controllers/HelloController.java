package com.scaler.productservicedecmwfeve.Controllers;


import org.springframework.web.bind.annotation.*;

//localhost:8080/hello
@RestController  //This class will be serving REST(http) APIs
@RequestMapping("/hello")
public class HelloController {
    //GET -- /hello/
    @GetMapping("/say/{name}/{time}")

    //@pathvariable = annotation, it uses adv java concept of reflection to differentiate parameters

    public String sayHello(@PathVariable("name") String name, @PathVariable("time") int time) {

        String answer ="";
        for(int i=0;i<time;i++) {
            answer += "Hello World " + name;
            answer += "<br>";
        }
        return answer;
    }
}
