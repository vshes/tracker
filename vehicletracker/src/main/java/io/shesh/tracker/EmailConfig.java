package io.shesh.tracker;

import io.shesh.tracker.utils.JavaMailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import java.util.Properties;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by shesh on 5/30/17.
 */

@Configuration
@PropertySource(value = "classpath:email.properties")

public class EmailConfig {


    @Autowired
    Environment environment;
    @Bean
   public MailSender mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getProperty("email.host"));
        mailSender.setProtocol(environment.getProperty("email.protocol"));
        mailSender.setUsername(environment.getProperty("email.username"));
        mailSender.setPassword(environment.getProperty("email.password"));
        mailSender.setPort(Integer.parseInt(environment.getProperty("email.port")));
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "false");
        return mailSender;
    }

    @Bean
    public SimpleMailMessage simpleMailMessage(){
       SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
       simpleMailMessage.setTo(environment.getProperty("email.to"));
       return simpleMailMessage;
    }


}
