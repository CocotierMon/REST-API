package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    AdminConfig adminConfig;

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("preview", "Hi, how are you?");
        context.setVariable("comp_name", adminConfig);
        context.setVariable("comp_phone", adminConfig);
        context.setVariable("comp_email", adminConfig);
        context.setVariable("goodbye", "See you soon!");
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("templates.mail/created-trello-card-mail", context);
    }

   /* public String buildDailyEmail(String message) {
        List<String> whatsNew = new ArrayList<>();
        whatsNew.add("Added everyday messages to our subscribers");
        whatsNew.add("New cards added");
        whatsNew.add("Don't forget to visit us!");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("preview", "What's new?");
        context.setVariable("comp_name", adminConfig);
        context.setVariable("comp_phone", adminConfig);
        context.setVariable("comp_email", adminConfig);
        context.setVariable("goodbye", "See you soon!");
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", whatsNew);
        return templateEngine.process("templates.mail/daily-trello-mail", context);
    } */
}