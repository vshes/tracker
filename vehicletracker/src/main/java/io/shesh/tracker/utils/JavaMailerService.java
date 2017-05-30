package io.shesh.tracker.utils;

import io.shesh.tracker.model.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by shesh on 5/30/17.
 *
 *
 */
@Component
public class JavaMailerService implements  MailerService{

    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Override
    public void send(Alert message) {
        try {
            simpleMailMessage.setText("PLEASE CHECK THE MESSAGE :"+message.getAlertmsg());
            simpleMailMessage.setSubject(message.getAlertmsg());
            mailSender.send(simpleMailMessage);


        }catch (Exception e){
            e.printStackTrace();

        }

        System.out.println("Sent MAIL ");

    }
}
