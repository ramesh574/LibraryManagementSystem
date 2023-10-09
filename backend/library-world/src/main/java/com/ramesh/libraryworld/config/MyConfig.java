package com.ramesh.libraryworld.config;

import com.ramesh.libraryworld.entity.Book;
import com.ramesh.libraryworld.entity.Message;
import com.ramesh.libraryworld.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyConfig implements RepositoryRestConfigurer {

    private String allowOrigin="http://localhost:3000";
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
                                                     CorsRegistry cors){
        HttpMethod [] theUnsupportedAction={
                HttpMethod.DELETE,
                HttpMethod.PATCH,
                HttpMethod.POST,
                HttpMethod.PUT
        };
        config.exposeIdsFor(Book.class);
        config.exposeIdsFor(Review.class);
        config.exposeIdsFor(Message.class);
        disableHttpMethods(Review.class,config,theUnsupportedAction);
        disableHttpMethods(Book.class, config, theUnsupportedAction);
        disableHttpMethods(Message.class,config,theUnsupportedAction);
        /* Configure CORS Mapping */
        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(allowOrigin);
    }
    private void disableHttpMethods(Class theClass,
                                    RepositoryRestConfiguration config,
                                    HttpMethod[] theUnsupportedAction) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) ->
                        httpMethods.disable(theUnsupportedAction))
                .withCollectionExposure((metdata, httpMethods) ->
                        httpMethods.disable(theUnsupportedAction));
    }
}
