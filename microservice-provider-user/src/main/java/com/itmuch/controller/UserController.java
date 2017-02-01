package com.itmuch.controller;

import com.itmuch.model.Student;
import com.itmuch.model.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ligeng on 17/1/14.
 */

@RestController
public class UserController {
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String port;

    @GetMapping("index")
    public List<Student> index(){
        System.out.println(port);
        List<Student> list = new ArrayList<Student>();
        Student<Student> student = new Student<Student>();
        Student student2 = new Student(){{
            name = "inner name";
        }};
        student.name = "ligeng";
        student.data = student2;

        list.add(student);
        list.add(student2);
        return list;
    }

    @GetMapping("eureka-instance")
    public String serviceUrl(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("instance-info")
    public ServiceInstance showInfo(){
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        return instance;
    }




    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        return user;
    }
    @GetMapping("/get-user")
    public User getUser(@ModelAttribute User user) {
        return user;
    }

    @DeleteMapping("/delete")
    public User deleteTest(@RequestBody User user){
        return user;
    }

    @PutMapping("/test-put/{id}")
    public User testPut(@PathVariable Long id,@RequestBody User user){
        user.setId(id);
        return user;
    }

    @PutMapping("/test-put2")
    public User testPut2(@ModelAttribute User user){
        return user;
    }

}
