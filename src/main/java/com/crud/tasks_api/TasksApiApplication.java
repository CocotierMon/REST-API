package com.crud.tasks_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TasksApiApplication {
        //extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TasksApiApplication.class, args);
    }

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TasksApiApplication.class);
    }*/
}
