package io.shesh.tracker;

import io.shesh.tracker.controller.TestComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by shesh on 5/28/17.
 */
public class AppInit {

    public static void main(String[] args) {
         ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        TestComponent tc = (TestComponent) applicationContext.getBean(TestComponent.class);
        tc.sayHi();

    }
}
