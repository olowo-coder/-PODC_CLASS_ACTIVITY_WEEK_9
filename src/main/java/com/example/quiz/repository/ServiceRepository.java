package com.example.quiz.repository;

import com.example.quiz.model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceRepository {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public ServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //Jonathan
    public Solution saveSolution(Solution solution){
        String sql = "INSERT INTO solution(name, questionTitle) VALUES (?, ?)";
        Object[] params = new Object[] {solution.getName(), solution.getQuestionTitle()};
        jdbcTemplate.update(sql,params);
        return solution;
    }
}
