import model.User;
import repositories.UsersRepository;
import repositories.impl.UsersRepositoryFileImpl;

public class App {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileImpl();

        User user = new User("1||dfgsdfg_6546|789_ghs|789_ghs|Козлов|Сергей||30|false");
        usersRepository.create(user);
        user = new User("2||dfgsdfg_6546|789_ghs|789_ghs|Иванов|Владимир||20|true");
        usersRepository.create(user);

        User userChange = usersRepository.findById("2");
        userChange.setId("3");
        usersRepository.update(userChange);
        usersRepository.findAll().stream()
                .forEach(u -> System.out.println(u.toStringFile()));

        System.out.println("\n Поиск по возврату (20):");
        usersRepository.findByAge(20).stream()
                .forEach(u -> System.out.println(u.toStringFile()));

        System.out.println( "\n Поиск работников:");
        usersRepository.findByAge(20).stream()
                .forEach(u -> System.out.println(u.toStringFile()));

        System.out.println( "\n Удаление по id (3):");
        usersRepository.deleteById("3");
                usersRepository.findAll().stream()
                .forEach(u -> System.out.println(u.toStringFile()));

        System.out.println( "\n Удаление всех пользователей:");
        usersRepository.deleteAll();
        System.out.println(usersRepository.findAll());


        //usersRepository.findAll().forEach(i -> System.out.println(i.toStringFile()));
        //System.out.println(usersRepository.findAll());
//
//
//        userChange.setLogin("asdf654_");
//        userChange.setPassword("qwer5_ty");
//        userChange.setConfirmPassword("qwerty");
//        userChange.setFirstName("Бонд");
//        userChange.setLastName("Джеймс");
//        userChange.setMiddleName("Бонд");
//        userChange.setAge(30);
//        userChange.setWorker(false);
//        usersRepository.update(userChange);
//        System.out.println(usersRepository.findByAge(20));
//        //usersRepository.findAll().forEach(i -> System.out.println(i.toStringFile()));
          //usersRepository.deleteById("98d5134b-d51b-4318-9fb7-4e1035f5a314");

//        try {
//            System.out.println(usersRepository.findById("9"));
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }



    }
}
