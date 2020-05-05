package com.alioo.alivalue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${name}")
    private String name;


    @AliValue("name2")
    private String name2;


    @Override
    public String toString() {
        return "AppConfig{" +
                "name='" + name + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }
}
