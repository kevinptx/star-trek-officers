package com.galvanize.controllers;

import java.util.List;
import java.util.Optional;

import com.galvanize.entities.Officer;
import com.galvanize.repository.JpaOfficerDao;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficerController {
    private JpaOfficerDao jpaOfficerDao;

    OfficerController(JpaOfficerDao jpaOfficerDao){
        this.jpaOfficerDao = jpaOfficerDao;
    }

    //POST METHOD
    @PostMapping("/officers")
    Officer newOfficer(@RequestBody Officer newOfficer){
        return jpaOfficerDao.save(newOfficer);
    }

    //GET METHOD to return all officers
    @GetMapping("/officers")
    List<Officer> all(){
        return jpaOfficerDao.findAll();
    }

    //GET METHOD to return a single officer
    @GetMapping("/officer/{id}")
    Optional<Officer> one(@PathVariable Long id){
        return jpaOfficerDao.findById(id);
    }

    //UPDATE METHOD
    @PutMapping("/officer/{id}")
    Optional<Officer> demoteOfficer(@RequestBody Officer newOfficer, @PathVariable Long id){
        return jpaOfficerDao.findById(id)
                .map(officer -> {
                    officer.setRank(newOfficer.getRank());
                    return jpaOfficerDao.save(officer);
                });
    }

    //DELETE
    @DeleteMapping("/officer/{id}")
    void deleteOfficer(@PathVariable Long id){
        jpaOfficerDao.deleteById(id);
    }
}
