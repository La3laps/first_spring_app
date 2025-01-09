package com.example.spring_app.Config;
// package com.example.spring_app.data.Config;

// import javax.sql.DataSource;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Profile;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;

// @Configuration
// public class SpringJdbcConfig {
// @Bean
// @Profile("mysql")
// public DataSource dataSourceMySql() {
// DriverManagerDataSource dataSource = new DriverManagerDataSource();
// dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
// dataSource.setUrl("jdbc:mysql://localhost:3306/square_games");
// dataSource.setUsername("root");
// dataSource.setPassword("");

// return dataSource;
// }

// @Bean
// @Profile("h2")
// public DataSource dataSourceH2() {
// DriverManagerDataSource dataSource = new DriverManagerDataSource();
// dataSource.setDriverClassName("org.h2.Driver");
// dataSource.setUrl("jdbc:h2:mem:square_games");
// dataSource.setUsername("root");
// dataSource.setPassword("");

// return dataSource;
// }

// }