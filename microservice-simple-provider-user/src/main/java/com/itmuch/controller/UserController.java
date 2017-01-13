package com.itmuch.controller;

import com.itmuch.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ligeng on 17/1/14.
 */

@RestController
public class UserController {

    @GetMapping("index")
    public Student index(){
        Student student = new Student();
        student.name = "ligeng";
        return student;
    }
}
