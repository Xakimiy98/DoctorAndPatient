package com.example.projectoftest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class ProjectOfTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectOfTestApplication.class, args);

    }

}
