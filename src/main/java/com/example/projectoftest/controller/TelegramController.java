package com.example.projectoftest.controller;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramController extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        Message message = update.getMessage();
        User user = message.getFrom();
        String text = "";
        SendMessage messageToHost = new SendMessage("2131447201", text );
        SendMessage sendMessage = new SendMessage(user.getId().toString(),
                "Register or Login ");
        try {
            if (message.getText().equals("/start")) {
                System.out.println(user.getId());
                execute(sendMessage);

            }
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        if(message.getText().endsWith("gister")){
            System.out.println(message.getText());
            sendMessage.setText("Doctor or Patient");
            text = message.getText();
            messageToHost.setText(text);
            try {
                execute(sendMessage);
                execute(messageToHost);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

        else if (update.getMessage().getText().endsWith("octor")){
            System.out.println(update.getMessage().getText());
            text = message.getText();
            messageToHost.setText(text);
            sendMessage.setText("Firstname :");
            try {
                execute(sendMessage);
                execute(messageToHost);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }




    }


    @Override
    public String getBotUsername() {
        return "Open_Budjet_For_You_bot";
    }

    @Override
    public String getBotToken() {
        return "6457848447:AAGFr_gvbeKtPBfIhfRn-Ko7wWthrKiCZlE";
    }

    private boolean isNumber(String s){
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }

    }
}
