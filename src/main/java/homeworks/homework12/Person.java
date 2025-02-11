package homeworks.homework12;


import homeworks.homework12.exception.NotValidData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private String name1;
    private String name2;
    private String name3;
    private LocalDate birthdate;
    private Long phoneNumber;
    private String gender;
    private Integer age;

    public Person(String name1, String name2, String name3, LocalDate birthdate, Long phoneNumber, String gender, Integer age) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    public Person(String fio, String birthdateStr, String phoneNumberStr, String gender, String ageStr) {
        if (!fio.matches("[а-яА-я]+\\s[а-яА-я]+\\s[а-яА-я]+")) {
            throw new NotValidData("Неверный формат ФИО (Необходимо ввести фаимлию, имя, отчество через пробел)");
        } else if (!birthdateStr.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new NotValidData("Неверный формат даты рождения");
        } else if (!phoneNumberStr.matches("\\d{10}")) {
            throw new NotValidData("Неверный формат номера телефона");
        } else if (!gender.matches("[mf]")) {
            throw new NotValidData("Значение пола должно быть m или f");
        } else if (!ageStr.matches("\\d{1,3}")) {
            throw new NotValidData("Неверный формат возраста");
        } else {


            try {
                DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("dd.MM.yyyy");
                String[] fioArray = fio.split(" ");
                String name1 = fioArray[0];
                String name2 = fioArray[1];
                String name3 = fioArray[2];
                LocalDate birthdate = LocalDate.parse(birthdateStr, dateFormat);
                Long phoneNumber = Long.parseLong(phoneNumberStr);
                Integer age = Integer.parseInt(ageStr);

                this.name1 = name1;
                this.name2 = name2;
                this.name3 = name3;
                this.birthdate = birthdate;
                this.phoneNumber = phoneNumber;
                this.gender = gender;
                this.age = age;
            } catch (RuntimeException runtimeException) {

            }


            }

    }

    public String toStringFile() {
        DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "<" + name1 + " " + name2 + " " + name3 + ">" +
                //"<" + birthdate.format(dateFormat) + ">" +
                "<" + birthdate + ">" +
                "<" + phoneNumber + ">" +
                "<" + gender + ">";
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                ", birthdate=" + birthdate +
                ", phoneNumber=" + phoneNumber +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
