package attestation.attestation01;

import attestation.attestation01.model.User;
import attestation.attestation01.repositories.UsersRepository;
import attestation.attestation01.repositories.impl.UsersRepositoryFileImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileImpl();

        //List<User> users = usersRepository.findAll();
       // users.forEach(i -> System.out.println(i.toStringFile()));

        User user = new User("||sdfgdg_654|789ghs|789ghs|Козлов|Сергей|Павлович|25|true");
        //usersRepository.create(user);
        //usersRepository.findAll().forEach(i -> System.out.println(i.toStringFile()));

        User userChange = usersRepository.findById("2");
        userChange.setFirstName("Козлов");
        usersRepository.update(userChange);
        usersRepository.findAll().forEach(i -> System.out.println(i.toStringFile()));
        //usersRepository.deleteAll();

//        try {
//            System.out.println(usersRepository.findById("9"));
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
    }
}
