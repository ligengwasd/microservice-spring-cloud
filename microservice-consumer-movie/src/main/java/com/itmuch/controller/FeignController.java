package com.itmuch.controller;

import com.itmuch.feign.User;
import com.itmuch.feign.UserFeignClient;
import com.itmuch.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ligeng on 17/1/29.
 */
@RestController
public class FeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id, "this is tokenKey");
    }

    @GetMapping("/test")
    public User testPost(User user) {
        user.setName("ligeng");
        return this.userFeignClient.postUser(user);
    }

    @GetMapping("/test-get")
    public User testGet(User user) {
        return this.userFeignClient.getUser(user);
    }

    @GetMapping("/delete")
    public User testDelete(User user){
        user.setName("ligeng");
        return this.userFeignClient.deleteTest(user);
    }

    @GetMapping("/test-put")
    public User testPut(){
        User user = new User();
        user.setName("ligeng");
        return this.userFeignClient.testPut(111L,user);
    }

    @GetMapping("/test-put2")
    public User testPut2(){
        User user = new User();
        user.setName("ligeng");
        return this.userFeignClient.testPut2(user);
    }

    @GetMapping("/test-gen")
    public Student<User> testGeneric(){
        Student<User> data =this.userFeignClient.testGeneric();
        System.out.println(data.data.getUsername());
        return data;
    }


}
