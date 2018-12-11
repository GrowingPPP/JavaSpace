package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class zghProperties {
    @Value("${com.zgh.name}")
    private String name;
    @Value("@{com.zgh.password}")
    private String password;
}
