package com.scaler.productservicedecmwfeve.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//localhost:8080/hello
@RestController  //This class will be serving REST(http) APIs
@RequestMapping("/hello")
public class HelloController {
    //GET -- /hello/
    @GetMapping("/say/{name}/{time}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("time") int time) {

        String answer ="";
        for(int i=0;i<time;i++) {
            answer += "Hello World " + name;
            answer += "<br>";
        }
        return answer;
    }
}
