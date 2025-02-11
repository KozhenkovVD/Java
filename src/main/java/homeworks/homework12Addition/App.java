package homeworks.homework12Addition;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        String login = "Jkfajfsdfg6546sdfgdfg";
        String password = "asdfF561_454";
        String confirmPassword = "asdfF561_454";
        if (User.check(login, password, confirmPassword)){
          User user = new User(login, password);
            System.out.println(user);
        }




    }
}
