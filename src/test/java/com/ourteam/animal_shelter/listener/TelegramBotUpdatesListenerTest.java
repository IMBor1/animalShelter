/*package com.ourteam.animal_shelter.listener;

import com.ourteam.animal_shelter.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TelegramBotUpdatesListenerTest {

    private TelegramBotUpdatesListener listener ;

    @Mock
    private TelegramLongPollingBot telegramBot;

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    public void setUp() {
        listener = new TelegramBotUpdatesListener(clientRepository, telegramBot, buttons);
        listener.init();
    }

    @Test
    public void process_messageUpdate() {
        Message message = mock(Message.class);
        Update update = mock(Update.class);
        when(update.message()).thenReturn(message);
        when(message.getChatId()).thenReturn(12345L);
        when(message.getText()).thenReturn("/c1");

        listener.process(List.of(update));

        verify(telegramBot).setUpdatesListener(listener);
        verify(clientRepository, never()).save(any());
        verify(telegramBot).execute(any());
    }

    @Test
    public void process_callbackQueryUpdate() {
        Update update = mock(Update.class);
        User user = mock(User.class);
        Message message = mock(Message.class);
        when(update.callbackQuery()).thenReturn(mock(Update.CallbackQuery.class));
        when(update.callbackQuery().getMessage()).thenReturn(message);
        when(message.getChat()).thenReturn(mock(Update.CallbackQuery.class));
        when(message.getChat().getId()).thenReturn(12345L);
        when(message.getChat().getUsername()).thenReturn("username");
        when(update.callbackQuery().getData()).thenReturn("/a1");

        listener.process(List.of(update));

        verify(telegramBot).setUpdatesListener(listener);
        verify(clientRepository).save(any());
        verify(telegramBot).execute(any());
    }

    @Test
    public void process_invalidUpdate() {
        listener.process(List.of(mock(Update.class)));

        verify(telegramBot).setUpdatesListener(listener);
        verify(clientRepository, never()).save(any());
        verify(telegramBot, never()).execute(any());
    }
}*/
