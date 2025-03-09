package homeworks.homework14;

import homeworks.homework14.exceptions.NotValidValuesException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private static Person person ;

    @BeforeEach
    void init() {
        person = new Person("Иванов", 500);
    }

    @Test
    void getNameTest() {
        Assertions.assertEquals("Иванов", person.getName());
    }

    @Disabled
    @Test
    void getBalanceTest() {
        Assertions.assertEquals(500, person.getBalance());
    }

    @Test
    void setNameTest() {
        person.setName("Петров");
        Assertions.assertEquals("Петров", person.getName());
    }

    @Test
    void setBalanceTest() {
        person.setBalance(1000);
        Assertions.assertEquals(1000, person.getBalance());
    }

    @Test
    void setBalanceTestException() {
        NotValidValuesException exception = Assertions.assertThrows(
                NotValidValuesException.class,
                () -> person.setBalance(-100));
        assertEquals(exception.getMessage(), "Деньги не могут быть отрицательными");
    }


    @Test
    void addProductToBasket() {
        Product product = new Product("Колбаса", 100);
        person.addProductToBasket(product);
        assertEquals("Иванов - Колбаса", person.getProductFromBasket());
    }

}