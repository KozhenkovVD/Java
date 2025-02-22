package attestation.attestation01.model;

import homeworks.homework12Addition.WrongLoginException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class User {
    private String id;
    private LocalDateTime inDateTime;
    private String login;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String middleName;
    private Integer age;
    private Boolean isWorker;

    public User(String id, LocalDateTime inDateTime, String login, String password, String confirmPassword, String firstName, String lastName, String middleName, Integer age, Boolean isWorker) {
        this.id = id;
        this.inDateTime = inDateTime;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.isWorker = isWorker;
    }
    public User(String userParamString) {
        String[] userParamStringArray = userParamString.split("\\|");
        if (!userParamStringArray[0].isEmpty()) {
            this.id = userParamStringArray[0];
        } else
            this.id = String.valueOf(UUID.randomUUID());
        if (!userParamStringArray[1].isEmpty()) {
            this.inDateTime = LocalDateTime.parse(userParamStringArray[1], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } else
            this.inDateTime = LocalDateTime.now();
        this.login = userParamStringArray[2];
        this.password = userParamStringArray[3];
        this.confirmPassword = userParamStringArray[4];
        if (userParamStringArray[5].matches("^[а-яА-яa-zA-Z]+$")) {
            throw new WrongLoginException("Фамилия должна содержать только буквы");
        } else {
            this.firstName = userParamStringArray[5];;
        }

        this.lastName = userParamStringArray[6];
        this.middleName = userParamStringArray[7];
        this.age = Integer.valueOf(userParamStringArray[8]);
        this.isWorker = Boolean.valueOf(userParamStringArray[9]);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getInDateTime() {
        return inDateTime;
    }

      public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (!login.matches("(?=.*\\w)(?=.*\\d)(?=.*[_])") || login.length() > 19) {
            throw new WrongLoginException("Логин должен содержать только буквы, цифры и символ \"_\" и быть меньше 20 символов");
        } else {
            this.login = login;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!password.matches("(?=.*\\w)(?=.*\\d)(?=.*[_])") || password.length() > 19) {
            throw new WrongLoginException("Пароль должен содержать только буквы, цифры и символ \"_\" и быть меньше 20 символов");
        } else {
            this.password = password;
        }

    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.matches("\\d")) {
            throw new WrongLoginException("Фамилия должна содержать только буквы");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getWorker() {
        return isWorker;
    }

    public void setWorker(Boolean worker) {
        isWorker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(inDateTime, user.inDateTime) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(confirmPassword, user.confirmPassword) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(middleName, user.middleName) && Objects.equals(age, user.age) && Objects.equals(isWorker, user.isWorker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inDateTime, login, password, confirmPassword, firstName, lastName, middleName, age, isWorker);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", inDateTime=" + inDateTime +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", isWorker=" + isWorker +
                '}';
    }

    public String toStringFile() {
        return id + "|" +
                inDateTime + "|" +
                login + "|" +
                password + "|" +
                confirmPassword + "|" +
                firstName + "|" +
                lastName + "|" +
                middleName + "|" +
                age + "|" +
                isWorker;
    }
}