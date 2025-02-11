package homeworks.homework12;

import homeworks.homework12.exception.NotValidData;

import java.io.*;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws ParseException, IOException {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String strPerson = "";




        for (int i = 1; i < 5; i++) {
                // ТЕСТОВЫЕ ДАННЫЕ
                // Иванов Иван Иванович 20.08.2005 9108889999 m 25
                // Петров Иван Иванович 10.03.1978 9108888888 m 101
                // Петров Иван Иванович 10.03.78 9108888888 m 101
                // Иванов Петр Иванович 15.07.1999 9108887777 m 45
                System.out.println("Введите данные человека №" + i);
                System.out.println("Введите ФИО");
                String fio = scanner.nextLine();
                System.out.println("Введите дату рождения (dd.mm.yyyy)");
                String birthdateStr = scanner.nextLine();
                System.out.println("Введите номер телефона (10 цифр)");
                String phoneNumberStr = scanner.nextLine();
                System.out.println("Введите пол (m/f)");
                String gender = scanner.nextLine();
                System.out.println("Введите возраст");
                String ageStr = scanner.nextLine();

                try {
                    personList.add(new Person(fio, birthdateStr, phoneNumberStr, gender, ageStr));
                } catch (NotValidData notValidData) {System.out.println(notValidData.getMessage());}

            }

        try {
            for (Person i : personList) {
            FileWriter fileWriter = new FileWriter("src/main/java/homeworks/homework12/" + i.getName1() + ".txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(i.toStringFile() + "\n");
            bufferedWriter.flush();
            fileWriter.close();
        }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
