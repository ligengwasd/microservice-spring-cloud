package com.itmuch;

import feign.*;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.netflix.feign.encoding.BaseRequestInterceptor;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ligeng on 17/1/30.
 */
@Configuration
public class FeignTestConfiguration {
    @Bean
    public Retryer retryer(){
        return Retryer.NEVER_RETRY;
    }

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
//        return Logger.Level.NONE;
    }

//    public Request.Options options(){
//        return Request.Options();
//    }

    @Bean
    public RequestInterceptor myRequestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                System.out.println("myRequestInterceptor is executing");
            }
        };
    }

//    SpringMvcContract


}
