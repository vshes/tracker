package io.shesh.tracker;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by shesh on 5/28/17.
 */
@Configuration
@ComponentScan
@EnableWebMvc

public class AppConfig extends WebMvcConfigurerAdapter{

//    @Override
//    public void addCorsMappings(CorsRegistry registry){
//        registry.addMapping("/api/*")
//               .allowedOrigins("http://mocker.egen.io","http://localhost:63342")
//                .allowedMethods("OPTIONS","GET","POST","PUT","DELETE")
//                .maxAge(3600)
//                .allowCredentials(false);
//
//    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}
