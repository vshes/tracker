package io.shesh.tracker;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

/**
 * Created by shesh on 5/28/17.
 */
@Configuration
@EnableTransactionManagement
@PropertySources({
        @PropertySource(value = "classpath:db.properties"),
        @PropertySource(value = "classpath:app.properties"),
        @PropertySource(value = "classpath:jpa.properties")
        })

public class JPAConfig {

    @Autowired
    private Environment environment;
    private Environment jpaenvironment;

    @Autowired
    public void setJpaenvironment(Environment jpaenv) {
        this.jpaenvironment = jpaenv;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(environment.getProperty("db.driver"));
        ds.setUrl(environment.getProperty("db.url"));
        ds.setUsername(environment.getProperty("db.user"));
        ds.setPassword(environment.getProperty("db.password"));
        return ds;
    }

    @Bean
    public PlatformTransactionManager txnManager(EntityManagerFactory emf) {
        JpaTransactionManager txnMgr = new JpaTransactionManager(emf);
        return txnMgr;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan(environment.getProperty("modelpackage"));
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setJpaProperties(getJpaProperties());
        return emf;
    }

    Properties getJpaProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", jpaenvironment.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", jpaenvironment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", jpaenvironment.getProperty("hibernate.hbm2ddl.auto"));
        return properties;

    }

}
