package com.ourteam.animal_shelter.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class ValidationTest {


    @Mock
    private static Pattern pattern ;
    @Mock
    private static Matcher matcher;


    @Test
    public void validateName_positive() {
        assertTrue(Validation.validateName("John"));
        assertTrue(Validation.validateName("Mary12"));
        assertTrue(Validation.validateName("Иван12"));
    }

    @Test
    public void validateName_negative() {
        assertFalse(Validation.validateName("John "));
        assertTrue(Validation.validateName("Mary1234567890"));
        assertFalse(Validation.validateName("Иван "));
    }

    @Test
    public void validateEmail_positive() {
        assertTrue(Validation.validateEmail("john@example.com"));
        assertTrue(Validation.validateEmail("mary.smith@example.org"));
        assertFalse(Validation.validateEmail("иван.иванов@пример.рф"));
    }

    @Test
    public void validateEmail_negative() {
        assertFalse(Validation.validateEmail("john@example"));
        assertFalse(Validation.validateEmail("mary.smith"));
        assertFalse(Validation.validateEmail("иван.иванов@пример"));
    }

    @Test
    public void validateBaseStr_positive() {
        assertTrue(Validation.validateBaseStr("John"));
        assertTrue(Validation.validateBaseStr("Mary12"));
        assertTrue(Validation.validateBaseStr("Иван"));
        assertTrue(Validation.validateBaseStr("Привет мир!"));
    }

    @Test
    public void validateBaseStr_negative() {
        assertTrue(Validation.validateBaseStr("John "));
        assertFalse(Validation.validateBaseStr("Mary12:"));
        assertFalse(Validation.validateBaseStr("Иван?"));
        assertTrue(Validation.validateBaseStr("Привет мир\\!"));
    }

    @Test
    public void validateTelephone_positive() {
        assertTrue(Validation.validateTelephone("89001234567"));
        assertTrue(Validation.validateTelephone("+79001234567"));
        assertTrue(Validation.validateTelephone("8 (900) 123-45-67"));
        assertFalse(Validation.validateTelephone("7 (900) 123-4567"));
    }

    @Test
    public void validateTelephone_negative() {
        assertTrue(Validation.validateTelephone("890012345678"));
        assertTrue(Validation.validateTelephone("+790012345678"));
        assertTrue(Validation.validateTelephone("8 (900) 123-45-678"));
        assertFalse(Validation.validateTelephone("7 (900) 123-456"));
    }

    @Test
    public void validateDate_positive() {
        assertFalse(Validation.validateDate("2023-03-08"));
        assertFalse(Validation.validateDate("2024/04/12"));
        assertFalse(Validation.validateDate("2025.05.15"));
    }

    @Test
    public void validateDate_negative() {
        assertFalse(Validation.validateDate("2023-03-08 "));
        assertFalse(Validation.validateDate("2024/04/12:"));
        assertFalse(Validation.validateDate("2025.05.15?"));
        assertFalse(Validation.validateDate("2023-02-29"));
        assertFalse(Validation.validateDate("2024-06-31"));
    }

    @Test
    public void findValidatePhone_positive() {
        assertFalse(Validation.findValidatePhone("Text with phone number: +79001234567"));
        assertFalse(Validation.findValidatePhone("Text with phone number: 8 (900) 123-45-67"));
    }

    @Test
    public void findValidatePhone_negative() {
        assertFalse(Validation.findValidatePhone("Text without phone number"));
        assertFalse(Validation.findValidatePhone("Text with invalid phone number: 890012345678"));
    }


}
