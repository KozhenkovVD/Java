package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static User user;

    @BeforeEach
    void init() {
        user = new User();
    }

    @Test
    void setLoginTest() {
        user.setLogin("sdf_1");
        Assertions.assertEquals("sdf_1", user.getLogin());
    }
    @Test
    void setFirstNameTestException() {
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> user.setFirstName("фыва4"));
        assertEquals(exception.getMessage(), "Фамилия должна содержать только буквы");
    }
    @Test
    void setLoginTestException() {
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> user.setLogin("asfrg_"));
        assertEquals(exception.getMessage(), "Логин должен содержать буквы, цифры и символ \"_\" и быть меньше 20 символов");
    }



}