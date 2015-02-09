package com.github.srekapalli.sample

import com.github.srekapalli.sample.config.SwaggerConfig
import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@CompileStatic
@Configuration
@ComponentScan("com.github.srekapalli.sample.resources")
@Import([SwaggerConfig])
class SampleApplication {

    static void main(String[] args) throws Exception {
        SpringApplication.run(SampleApplication.class, args)
    }

}