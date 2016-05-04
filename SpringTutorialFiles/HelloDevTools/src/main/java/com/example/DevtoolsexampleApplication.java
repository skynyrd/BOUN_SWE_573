package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
public class DevtoolsexampleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DevtoolsexampleApplication.class, args);

        MyAppConfig config = (MyAppConfig) ctx.getBean("myAppConfig");
        //pass this config to somewhere.
	}
}
