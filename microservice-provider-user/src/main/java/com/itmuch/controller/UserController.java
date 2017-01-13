package com.itmuch.controller;

import com.itmuch.model.Student;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ligeng on 17/1/14.
 */

@RestController
public class UserController {
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("index")
    public Student index(){
        Student student = new Student();
        student.name = "ligeng";
        return student;
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
}
