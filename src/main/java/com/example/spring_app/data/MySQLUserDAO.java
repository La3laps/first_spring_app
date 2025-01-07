package com.example.spring_app.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MySQLUserDAO implements IUserDAO {
    // private Connection connection;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // JDBC
    @Override
    public List<UserData> getAllUsers() {
        return (List<UserData>) jdbcTemplate.query("SELECT * FROM USERS",
                new BeanPropertyRowMapper<>(UserData.class));
    };

    @Override
    public UserData getUserById(int userId) {
        UserData userData = jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE id = ?", new Object[] { userId },
                new BeanPropertyRowMapper<>(UserData.class));
        return userData;
    };

    @Override
    public int addUser(UserData user) {
        return jdbcTemplate.update("INSERT INTO USERS (name, email) VALUES (?, ?)", user.getName(),
                user.getEmail());
    };

    @Override
    public void updateUser(UserData user) {

        jdbcTemplate.update("UPDATE USERS SET name = ?, email = ? WHERE id = ?", user.getName(),
                user.getEmail(), user.getId());
    };

    @Override
    public void deleteUser(int id) {
        jdbcTemplate.update("DELETE FROM USERS WHERE id = ?", id);
    }

}
