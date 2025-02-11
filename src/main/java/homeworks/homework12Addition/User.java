package homeworks.homework12Addition;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {

            this.login = login;
            this.password = password;
    }

    static Boolean check (String login, String password, String confirmPassword)  {
        Boolean result = false;
        if (login.length() < 20 && password.length() < 20 && password.equals(confirmPassword) && password.matches("[A-Za-z0\\d_]+")) {
            result = true;
        } else if (login.length() >= 20 ) {
            throw new WrongLoginException("Логин слишком длинный");
        } else if (password.length() >= 20 || !password.matches("[A-Za-z0\\d_]+")) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры\n" +
                    "и знак подчеркивания. Длина password должна быть меньше 20 символов");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
