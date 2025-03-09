package homeworks.homework14;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonService {
    public List<Person> convertStringToPerson(String line) {
        return Arrays.stream(line.split(";"))
                .map(e -> {
                    String[] elements = e.split("=");
                    return new Person(elements[0].trim(),Integer.parseInt(elements[1].trim()));
                })
                .toList();
    }
}


