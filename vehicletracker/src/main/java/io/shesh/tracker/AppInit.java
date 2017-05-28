package io.shesh.tracker;

import io.shesh.tracker.controller.TestComponent;
import io.shesh.tracker.utils.AlertMsgType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by shesh on 5/28/17.
 */
public class AppInit {

    public static void main(String[] args) {

//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        TestComponent tc = applicationContext.getBean(TestComponent.class);
//        tc.sayHi();
        System.out.println(AlertMsgType.values().length);
        for(AlertMsgType alert :  AlertMsgType.values()){
            System.out.println(alert.getAlertMsg());
        }
        AlertMsgType.CHECK_ENGINE_LIGHT.getAlertMsg();

    }
}
