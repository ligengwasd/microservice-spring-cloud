package com.itmuch.controller;

import com.itmuch.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ligeng on 17/1/14.
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${user.userServicePath}")
    private String userServicePath;


    @GetMapping("/movie")
    public Student index(){
        return restTemplate.getForObject(userServicePath+"index", Student.class);
    }
}
