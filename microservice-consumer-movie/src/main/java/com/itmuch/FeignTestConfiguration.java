package com.itmuch;

import feign.Logger;
import feign.Retryer;
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

}
