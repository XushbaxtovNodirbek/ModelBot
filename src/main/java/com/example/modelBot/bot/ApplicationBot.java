package com.example.modelBot.bot;

import com.example.modelBot.bot.config.BotConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class ApplicationBot extends TelegramLongPollingBot {
    private final BotConfig config;
    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.print(update);
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }
}
