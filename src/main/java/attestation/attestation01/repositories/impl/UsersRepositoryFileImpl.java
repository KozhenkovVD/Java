package attestation.attestation01.repositories.impl;


import attestation.attestation01.exceptions.NotExistUser;
import attestation.attestation01.model.User;
import attestation.attestation01.repositories.UsersRepository;

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
        User user = USERS.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new NotExistUser("Пользователя с заданным идентификатором не существует"));
        return user;
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
        USERS.removeIf(user -> user.getId().equals(id));
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (User user : USERS) {
                bufferedWriter.write(user.toStringFile()+ "\n");
            }
            bufferedWriter.flush();
            fileWriter.close();
        } catch (IOException ioException) {ioException.printStackTrace();}
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
    public String toString() {
        return "UsersRepositoryFileImpl{" +
                "USERS=" + USERS;
    }
}
