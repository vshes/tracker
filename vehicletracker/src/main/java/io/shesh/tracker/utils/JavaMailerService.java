package io.shesh.tracker.utils;

import io.shesh.tracker.model.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by shesh on 5/30/17.
 *
 *
 */
@Service
public class JavaMailerService implements  MailerService{

    @Autowired
    private MailSender mailSender;
    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Override
    public void send(List<Alert> message, String id) {
        try {
            simpleMailMessage.setFrom("tracker.io@test.com");
            simpleMailMessage.setSubject(" Alert for Vehicle  " +id + " Total of:" +message.size() +" Alerts");
            int count =1;
            StringBuffer stringBuffer = new StringBuffer();
            for(Alert alert : message){
                stringBuffer.append(count).append("\t").
                        append(" Vehicle ID :").append(alert.getVin()).append("\t").
                        append("Priority :").append(alert.getPriority()).append("\t").
                        append("Alert Msg:").append(alert.getAlertmsg()).
                        append( "\n");
                count +=1;
            }
            simpleMailMessage.setText(stringBuffer.toString());
            mailSender.send(simpleMailMessage);

        }catch (Exception e){
            e.printStackTrace();

        }

        System.out.println("Sent MAIL ");

    }
}
