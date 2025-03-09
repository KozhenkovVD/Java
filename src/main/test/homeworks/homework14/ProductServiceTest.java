package homeworks.homework14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private static ProductService productService;

    @BeforeAll
    static void init() {
        productService = new ProductService();
    }
    @Test
        void convertStringToProduct() {
            String line = "Хлеб = 40; Молоко = 60; Торт = 1000; Кофе растворимый = 432";
            List<Product> result  = productService.convertStringToProduct(line);
            Assertions.assertAll(() -> {
                Assertions.assertNotNull(result);
                Assertions.assertEquals(4, result.size());
            });
    }

    @ParameterizedTest
    @MethodSource("line")
    public void convertStringToProductParameterizedTest(String line) {
        List<Product> result = productService.convertStringToProduct(line);
        Assertions.assertAll(() -> {
            Assertions.assertNotNull(result);
        });
    }

    private static Stream<Arguments> line() {
        return Stream.of(
                Arguments.of("Хлеб = 40"), // null strings should be considered blank
                Arguments.of("Молоко = 60"),
                Arguments.of("Торт = 1000"),
                Arguments.of("Кофе растворимый = 432")
        );
    }
}