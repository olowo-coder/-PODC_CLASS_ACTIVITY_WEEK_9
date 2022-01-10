package com.example.quiz.repository;

import com.example.quiz.model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ServiceRepository {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public ServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Solution saveProduct(Solution solution){
        String sql = "INSERT INTO solution(name, questionTitle) VALUES (?, ?)";
        Object[] params = new Object[] {solution.getName(), solution.questionTitle()};
        jdbcTemplate.update(sql,params);
        return solution;
    }
}
