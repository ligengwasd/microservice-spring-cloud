package com.itmuch.controller;

import com.itmuch.model.JsonUtil;
import com.itmuch.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ligeng on 17/1/14.
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie")
    public String index(){
        return restTemplate.getForObject("http://microservice-provider-user/"+"index", String.class);
    }
    @GetMapping("test")
    public String test(){
        ServiceInstance instance = loadBalancerClient.choose("http://microservice-provider-user");
        System.out.println(instance.getHost()+":"+instance.getPort()+" "+instance.getServiceId());
        return "1";
    }


}
