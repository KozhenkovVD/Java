package homeworks.homework13.utils;

import homeworks.homework13.exceptions.NotValidValueException;

public class Parser {
    public Integer parseCount (String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NotValidValueException("Невалидное значение");
        }
    }

    public Integer validateCount (String str) {
        return this.parseCount(str);
    }

    public Double parseNumber (String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new NotValidValueException("Невалидное значение");
        }
    }

    public Double validateNumber (String str) {
        return this.parseNumber(str);
    }
}
