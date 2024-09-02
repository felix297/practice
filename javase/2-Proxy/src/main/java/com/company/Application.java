package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main (String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ServiceInvoctionHandler handler = context.getBean("serviceInvoctionHandler", ServiceInvoctionHandler.class);
        Service service = handler.getProxy();
        service.update();

    }

}