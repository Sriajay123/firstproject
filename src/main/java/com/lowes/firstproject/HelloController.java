package com.lowes.firstproject;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


    @GetMapping("/welcome/{name}")
    public String print(@PathVariable ("name") String name){
        return "hi welcome to spring boot first project" +" "+ name ;
    }

    @GetMapping("/hi")
    public String doSomething(){
        return "hi welcome !";
    }

    @GetMapping("/bye")
    public String doSomet(){
        return "bye visit again !";
    }

}
