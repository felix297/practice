package com.company;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
@Data
public class ServiceInvoctionHandler implements InvocationHandler {
    private Service service;

    @Autowired
    public ServiceInvoctionHandler (@Qualifier("main") Service service) {
        this.service = service;
    }

    public Service getProxy () {
        return (Service) Proxy.newProxyInstance(this.getClass().getClassLoader(), service.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke (Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        if (method.getName().equals("create")) {
            eatDis();
        }

        Object res = method.invoke(service, args);

        if (method.getName().equals("update")) {
            wirteDis();
        }

        return res;
    }

    public void eatDis () {
        System.out.println("吃香喝辣");

    }

    public void wirteDis () {
        System.out.println("我的区长爸爸");
    }
}
