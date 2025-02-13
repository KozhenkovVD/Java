package homeworks.homework12;

import homeworks.homework12.exception.NotValidDataException;
import homeworks.homework12.exception.UnexpectedCountValueException;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws ParseException, IOException {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные человека. Для окончания ввода укажите \"END\"");

//ТЕСТОВЫЕ ДАННЫЕ
//Иванов Иван Иванович 20.08.2005 9108889999 m 25
//10.03.1978 Петров Иван Иванович 9108888888 m 101
//10.03.1978 Петров Иван Иванович m 101
//10.03.78 9108888888 m 101 Петров Иван Иванович
//m 45 Иванов Петр Иванович 15.07.1999 9108887777
//9108888888 Фролов Иван Иванович 10.03.1978 т 101

        String strPerson = "";
        while (!strPerson.equals("END")) {
            strPerson = scanner.nextLine();
            if (strPerson.equals("END")) {
                break;
            } else {
                try {
                    String[] strPersonArray = strPerson.split(" ");
                    if (strPersonArray.length > 7) {
                        throw new UnexpectedCountValueException("ОШИБКА: Введено больше данных чем требуется");
                    } else if (strPersonArray.length < 7) {
                        throw new UnexpectedCountValueException("ОШИБКА: Введено меньше данных чем требуется");
                    }
                    else {
                        Pattern patternFIO = Pattern.compile("[а-яА-я]+\\s[а-яА-я]+\\s[а-яА-я]+");
                        Matcher matcherFIO = patternFIO.matcher(strPerson);
                        String fio = "";
                        if (matcherFIO.find()) {
                            fio = matcherFIO.group();
                        }

                        Pattern patternBirthdate = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
                        Matcher matcherBirthdate = patternBirthdate.matcher(strPerson);
                        String birthdateStr = "";
                        if (matcherBirthdate.find()) {
                            birthdateStr = matcherBirthdate.group();
                        }

                        Pattern patternPhoneNumber = Pattern.compile("\\d{10}");
                        Matcher matcherPhoneNumber = patternPhoneNumber.matcher(strPerson);
                        String phoneNumberStr = "";
                        if (matcherPhoneNumber.find()) {
                            phoneNumberStr = matcherPhoneNumber.group();
                        }


                        Pattern patternGender = Pattern.compile("^\\w | \\w | \\w$");
                        Matcher matcherGender = patternGender.matcher(strPerson);
                        String gender = "";
                        if (matcherGender.find()) {
                            gender = matcherGender.group().trim();
                        }

                        Pattern patternAge = Pattern.compile("^\\d{1,3} | \\d{1,3} | \\d{1,3}$");
                        Matcher matcherAge = patternAge.matcher(strPerson);
                        String ageStr = "";
                        if (matcherAge.find()) {
                            ageStr = matcherAge.group().trim();
                        }
                        try {
                            personList.add(new Person(fio, birthdateStr, phoneNumberStr, gender, ageStr));
                        } catch (NotValidDataException notValidData) {notValidData.printStackTrace();}
                    }
            } catch (RuntimeException runtimeException) {runtimeException.printStackTrace();}
        }
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
