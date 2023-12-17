package com.digitaltrio.listdoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ListDoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListDoApiApplication.class, args);
    }

}
