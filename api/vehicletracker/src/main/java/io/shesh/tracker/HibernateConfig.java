package io.shesh.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by shesh on 5/28/17.
 */

@Configuration
@PropertySource(value = "classpath:jpa.properties")
public class HibernateConfig {

    @Autowired
    private Environment jpaenv;


}
