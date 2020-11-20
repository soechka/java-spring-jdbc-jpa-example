package ru.testspring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.testspring.entity.StudentsJdbcDemo;

import java.util.List;

@Repository
public class StudentsJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM public.student", Integer.class);
    }

    public List<StudentsJdbcDemo> getStudents() {
        return jdbcTemplate.query("SELECT * FROM public.student", (rs, rowNum) ->
                new StudentsJdbcDemo(
                        rs.getLong("id"),
                        rs.getInt("fac_id"),
                        rs.getString("name"),
                        rs.getInt("year")
                ));
    }

    public List<StudentsJdbcDemo> getFacultyStudents(int fac_id) {
        return jdbcTemplate.query(String.format("SELECT * FROM public.student WHERE fac_id = %s", fac_id),
            (rs, rowNum) ->
                    new StudentsJdbcDemo(
                            rs.getLong("id"),
                            rs.getInt("fac_id"),
                            rs.getString("name"),
                            rs.getInt("year")
                    ));
    }
}
