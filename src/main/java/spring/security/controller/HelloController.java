package spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;



@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello(Principal principal) {
        return "Hello  devDhiraj12";
    }


}