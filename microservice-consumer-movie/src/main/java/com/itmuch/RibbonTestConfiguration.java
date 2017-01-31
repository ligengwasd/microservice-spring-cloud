package com.itmuch;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonTestConfiguration {

  @Bean
  public IRule ribbonRule() {
//    http://lxlong.iteye.com/blog/2314573   关于负责均衡策略的详细介绍
//    加权响应时间负载均衡 （WeightedResponseTime）
//    随机负载均衡 （Random）
//    以轮询的方式依次将请求调度不同的服务器，即每次调度执行i = (i + 1) mod n，并选出第i台服务器。
//    区域感知轮询负载均衡（ZoneAware）

//    return new RandomRule();
    return new RoundRobinRule();
  }

//  @Bean
  public IPing iPing(){
    return new PingUrl();
//    return new NoOpPing();
  }

  public ServerList<Server> serverList(){
//    return new ConfigurationBasedServerList
    return null;
  }

  public ServerListFilter<Server> serverListFilter(){
    return null;
  }

  public IClientConfig iClientConfig(){
//    return new DefaultClientConfigImpl();
    return null;
  }
}
