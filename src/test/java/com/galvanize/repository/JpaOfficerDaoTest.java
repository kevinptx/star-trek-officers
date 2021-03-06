package com.galvanize.repository;

import com.galvanize.entities.Officer;
import com.galvanize.entities.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpaOfficerDaoTest {

    @Autowired
    JpaOfficerDao jpaOfficerDao;

    @Test
    void countOfficers() {
        Long count = jpaOfficerDao.count();
        assertTrue(count > 0);
    }
    @Test
    void findAllOfficers(){
        List<Officer> officers = jpaOfficerDao.findAll();
        assertFalse(officers.isEmpty());
        officers.forEach(System.out::println);
    }

    @Test
    void officerExistsById() {
        assertTrue(jpaOfficerDao.existsById(2L));
    }

    @Test
    void findOfficerById() {
        Optional<Officer> officer = jpaOfficerDao.findById(3L);
        assertTrue(officer.isPresent());
        System.out.println(officer);
    }

    @Test
    void createNewOfficer() {
        Officer officer = new Officer(Rank.LIEUTENANT, "This", "Guy" );
        jpaOfficerDao.save(officer);
        assertNotNull(officer.getId());
        System.out.println(officer);
        jpaOfficerDao.delete(officer);
    }

    @Test
    void deleteOfficer() {
        Optional<Officer> officer = jpaOfficerDao.findById(1L);
        jpaOfficerDao.delete(officer.get());
        assertFalse(jpaOfficerDao.existsById(1L));
    }
}