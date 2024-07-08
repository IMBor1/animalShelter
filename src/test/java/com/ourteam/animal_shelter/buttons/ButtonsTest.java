package com.ourteam.animal_shelter.buttons;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ButtonsTest {

    @Mock
    private TelegramBot telegramBot;
    @InjectMocks
    private Buttons buttons;

    @BeforeEach
    public void setUp() {
        buttons = new Buttons(telegramBot);
    }

    @Test
    public void InformationOfButtonStage0Test() {

        String comMsg = "/c1";
        Long chatId = 1L;
        Update update = mock(Update.class, RETURNS_DEEP_STUBS);
        when(update.message().text()).thenReturn(comMsg);
        when(update.message().chat().id()).thenReturn(chatId);


        buttons.ButtonsStage_0(update);


        verify(telegramBot, times(1)).execute(any(SendMessage.class));
    }

    @Test
    public void InformationOfButtonStage1Test() {

        String comMsg = "/a2";
        Long chatId = 1L;
        Update update = mock(Update.class, RETURNS_DEEP_STUBS);
        when(update.callbackQuery().message().chat().id()).thenReturn(chatId);


        buttons.buttonsStage_1(update);


        verify(telegramBot, times(1)).execute(any(SendMessage.class));
    }

    @Test
    public void InformationOfButtonStage2Test() {

        String comMsg = "/b1";
        Long chatId = 1L;
        Update update = mock(Update.class, RETURNS_DEEP_STUBS);
        when(update.callbackQuery().message().chat().id()).thenReturn(chatId);


        buttons.buttonsStage_2(update);


        verify(telegramBot, times(1)).execute(any(SendMessage.class));
    }

    @Test
    public void AdoptAnimalButtonStage2Test() {

        String comMsg = "/b13";
        Long chatId = 1L;
        Update update = mock(Update.class, RETURNS_DEEP_STUBS);
        when(update.callbackQuery().message().chat().id()).thenReturn(chatId);


        buttons.buttonsStage_2(update);


        verify(telegramBot, times(1)).execute(any(SendMessage.class));
    }
}

