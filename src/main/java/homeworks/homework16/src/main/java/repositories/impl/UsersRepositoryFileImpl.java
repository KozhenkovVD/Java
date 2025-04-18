package repositories.impl;


import exceptions.NotExistUser;
import model.User;
import repositories.UsersRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryFileImpl implements UsersRepository {

    private static String FILE_PATH = "src/main/resources/repository.txt";
    private static List<User> USERS = new ArrayList<>();

    public UsersRepositoryFileImpl() {
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                USERS.add(new User(bufferedReader.readLine()));
            }
            fileReader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Override
    public void create(User user) {
        USERS.add(user);
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (User i : USERS) {
                bufferedWriter.write(i.toStringFile()+ "\n");
            }
            bufferedWriter.flush();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public User findById(String id) {
        return
                USERS.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new NotExistUser("Пользователя с заданным идентификатором не существует"));
    }

    @Override
    public List<User> findAll() {
        return USERS;
    }

    @Override
    public void update(User user) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (User i : USERS) {
                bufferedWriter.write(i.toStringFile()+ "\n");
            }
            bufferedWriter.flush();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Override
    public void deleteById(String id) {
        try {
            USERS.remove(findById(id));
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (User user : USERS) {
                bufferedWriter.write(user.toStringFile()+ "\n");
            }
            bufferedWriter.flush();
            fileWriter.close();

        } catch (RuntimeException|IOException exception) {
            exception.printStackTrace();

        }
    }


    @Override
    public void deleteAll() {
        USERS.clear();
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.flush();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Override
    public List<User> findByAge(Integer age) {
        return USERS.stream()
                .filter(user -> user.getAge().equals(age))
                .toList();
    }

    @Override
    public List<User> findByIsWorker() {
        return USERS.stream()
                .filter(user -> user.getWorker().equals(true))
                .toList();
    }


    @Override
    public String toString() {
        return "UsersRepositoryFileImpl{" +
                "USERS=" + USERS;
    }
}
