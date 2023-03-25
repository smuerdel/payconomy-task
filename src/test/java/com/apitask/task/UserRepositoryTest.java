package com.apitask.task;

import com.apitask.task.model.User;
import com.apitask.task.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void listAll() {
        List<User> users = userRepository.findAll();
        Assertions.assertNotNull(users);
    }

    @Test
    public void listSamuel() {
        User samuel = userRepository.findById("smuerdel").orElseThrow();
        Assertions.assertEquals(samuel.getFirstname(), ("Samuel"));
    }

    @Test
    public void deleteEins() {
        User samuel = userRepository.findById("eins").orElseThrow();
        userRepository.delete(samuel);
        Assertions.assertThrows(NoSuchElementException.class, () -> userRepository.findById("eins").orElseThrow());
    }

    @Test
    public void updateSamuel() {
        Assertions.assertEquals(26, userRepository.findById("smuerdel").orElseThrow().getAge());
        User samuel = userRepository.findById("smuerdel").orElseThrow();
        samuel.setAge(21);
        samuel.setUpdateDate(Date.from(Instant.now()));
        userRepository.save(samuel);
        Assertions.assertEquals(21, userRepository.findById("smuerdel").orElseThrow().getAge());
    }


    /**
     * Mein Bruder heißt Pinkas.
     */
    @Test
    public void createPinkas() {
        User pinkas = new User();
        pinkas.setAge(28);
        pinkas.setEmail("pinkas@web.de");
        pinkas.setFirstname("Pinkas");
        pinkas.setUsername("pinkas");
        pinkas.setSurname("Mürdel");
        pinkas.setCreateDate(Date.from(Instant.now()));
        userRepository.save(pinkas);
        User zorro = userRepository.findById("pinkas").orElseThrow();
        Assertions.assertEquals("Pinkas", zorro.getFirstname());
    }
}
