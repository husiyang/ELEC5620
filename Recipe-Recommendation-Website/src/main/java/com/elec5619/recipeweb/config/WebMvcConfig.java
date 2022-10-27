package com.elec5619.recipeweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/AnnexImage/**").
                addResourceLocations("file:D://code//ELEC5620//Recipe-Recommendation-Website//src//main//webapp//WEB-INF//jsp//AnnexImage/");
        registry.addResourceHandler("/ThumbImage/**").
                addResourceLocations("file:D://code//ELEC5620//Recipe-Recommendation-Website//src//main//webapp//WEB-INF//jsp//ThumbImage/");
    }
}
