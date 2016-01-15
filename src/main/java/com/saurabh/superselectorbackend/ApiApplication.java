package com.saurabh.superselectorbackend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by saurabh on 15/1/16.
 */
@SpringBootApplication
public class ApiApplication {
    
    public static void main(String[] args) {
        new ApiApplication().configure(
            new SpringApplicationBuilder(ApiApplication.class)).run(args);
    }
    
    protected SpringApplicationBuilder configure(
        SpringApplicationBuilder application) {
        return application.sources(com.saurabh.superselectorbackend.ApiApplication.class);
    }
}
