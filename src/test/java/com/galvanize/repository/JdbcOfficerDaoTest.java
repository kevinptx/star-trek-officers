package com.galvanize.repository;

import com.galvanize.entities.Officer;
import com.galvanize.entities.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcOfficerDaoTest {

    @Autowired
    JdbcOfficerDao jdbcOfficerDao;

    @Test
    void countOfficers() {
        //count * from table and will return a long
        Long officerCount = jdbcOfficerDao.count();
        assertEquals(5L, officerCount);
    }

    @Test
    void officerExistsById() {
        boolean officerExists = jdbcOfficerDao.exists(1L);
        assertTrue(officerExists);
    }

    @Test
    void findAllOfficers() {
        List<Officer> officers = jdbcOfficerDao.findAll();
        assertFalse(officers.isEmpty());
        officers.forEach(System.out::println);
    }

    @Test
    void findOfficerById() {
        Optional<Officer> officer = jdbcOfficerDao.findById(3);
        assertTrue(officer.isPresent());
        System.out.println(officer);
    }
}