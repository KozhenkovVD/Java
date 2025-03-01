package attestation.attestation01.repositories.impl;

import attestation.attestation01.model.User;
import attestation.attestation01.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class UsersRepositoryFileImplTest {
    private static UsersRepository usersRepository;
    @BeforeEach
    void init() {
        usersRepository = new UsersRepositoryFileImpl();
        usersRepository.create(new User("1||dfgsdfg_6546|789_ghs|789_ghs|Козлов|Сергей||30|false"));
    }
    @Test
    void findAllTest() {
        assert (usersRepository.findAll().size() == 1);
    }
    @Test
    void deleteAllTest() {
        usersRepository.deleteAll();
        assert (usersRepository.findAll().isEmpty());
    }


}