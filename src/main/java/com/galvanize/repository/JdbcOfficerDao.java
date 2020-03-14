package com.galvanize.repository;

import com.galvanize.entities.Officer;
import com.galvanize.entities.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcOfficerDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertOfficer;

    @Autowired
    public JdbcOfficerDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        insertOfficer = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("officers")
                .usingGeneratedKeyColumns("id");
    }

    public Long count() {
        String query = "select count(*) from officers";
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    public boolean exists(Long id) {
        boolean found = false;
        try {
            String query = "select 1 from officers where id=?";
            found = jdbcTemplate.queryForObject(query, Boolean.class, id);
        }catch (EmptyResultDataAccessException e){

        }
        return found;
    }

    public List<Officer> findAll() {
        return jdbcTemplate.query("select * from officers",
                (rs, rowNum) -> new Officer(rs.getLong("id"),
                        Rank.valueOf(rs.getString("officer_rank")),
                        rs.getString("first_name"),
                        rs.getString("last_name"))
        );
    }

    public Optional<Officer> findById(int id) {
        if(!existsById(id)) return Optional.empty();
    }
}
