package homeworks.homework14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    private static PersonService personService;

    @BeforeAll
    static void init() {
        personService = new PersonService();
    }

    @Test
    void convertStringToPersonTest() {
        String line = "Павел Андреевич = 10000; Анна Петровна = 2000; Борис = 10";
        List<Person> result = personService.convertStringToPerson(line);
        Assertions.assertAll(() -> {
            Assertions.assertNotNull(result);
            Assertions.assertEquals(3, result.size());
        });
    }

    @ParameterizedTest
    @MethodSource("line")
    public void convertStringToPersonParameterizedTest(String line) {
        List<Person> result = personService.convertStringToPerson(line);
        Assertions.assertAll(() -> {
            Assertions.assertNotNull(result);
        });
    }

    private static Stream<Arguments> line() {
        return Stream.of(
                Arguments.of("Павел Андреевич = 10000"), // null strings should be considered blank
                Arguments.of("Анна Петровна = 2000"),
                Arguments.of("Борис = 10")
        );
    }
}

//
//    }

