package com.itmuch.feign;

import com.itmuch.FeignTestConfiguration;
import com.itmuch.model.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "microservice-provider-user",
        configuration = FeignTestConfiguration.class)
public interface UserFeignClient{
  @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
  public User findById(@PathVariable("id") Long id, @RequestHeader("tokenKey") String tokenKey); // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public User postUser(@RequestBody User user);

  // 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。可能是我没找到相应的注解或使用方法错误。
  // 如勘误，请@lilizhou2008  eacdy0000@126.com
  @RequestMapping(value = "/get-user", method = RequestMethod.GET)
  public User getUser(@RequestAttribute User user);

  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public User deleteTest(@RequestBody User user);

  //  put表示update
  @RequestMapping(value = "/test-put/{id}", method = RequestMethod.PUT)
  public User testPut(@PathVariable("id") Long id,@RequestBody User user);

  @RequestMapping(value = "/test-put2", method = RequestMethod.PUT)
  public User testPut2(@RequestAttribute User user);

  @RequestMapping(value = "/test-gen", method = RequestMethod.GET)
  public Student<User> testGeneric();
}
