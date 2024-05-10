package com.example.projectoftest;

import com.example.projectoftest.controller.TelegramController;
import com.example.projectoftest.controller.TransferController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class ProjectOfTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectOfTestApplication.class, args);
        try {


            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            TelegramController telegramController = new TelegramController();
            telegramBotsApi.registerBot(telegramController);

        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
