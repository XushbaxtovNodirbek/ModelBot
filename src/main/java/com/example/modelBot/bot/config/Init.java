package com.example.modelBot.bot.config;

import com.example.modelBot.bot.ApplicationBot;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
@RequiredArgsConstructor
public class Init {
    final ApplicationBot applicationBot;

    @EventListener({ContextRefreshedEvent.class})
    public void init(){
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(applicationBot);
        }catch (TelegramApiException e){
            throw new RuntimeException(e);
        }
    }
}
