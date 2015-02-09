package com.github.srekapalli.sample.config

import com.mangofactory.swagger.configuration.SpringSwaggerConfig
import com.mangofactory.swagger.models.dto.ApiInfo
import com.mangofactory.swagger.plugin.EnableSwagger
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@CompileStatic
@Configuration
@EnableSwagger
@EnableAutoConfiguration
class SwaggerConfig {

    private static final String TITLE = 'My title'
    private static final String DESC = 'This thing does something...'
    private static final String[] INCLUDE = ['^/api*.*$'] // <-- you can add things here you want to expose via swagger

    private SpringSwaggerConfig springSwaggerConfig

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig
    }

    @Bean
    SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(INCLUDE)
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(TITLE, DESC, null, null, null, null)
    }
}
