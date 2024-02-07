package com.nlw.certification_nlw.seed;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateSeed {
    private final JdbcTemplate template;

    public CreateSeed(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    public void run() throws IOException {
        executeSqlFile("src/main/resources/create.sql");
    }

    public void executeSqlFile(String filePath) throws IOException {
        String sqlScript = new String(Files.readAllBytes(Path.of(filePath)));
        template.execute(sqlScript);
        System.out.println("Success!");
    }

    public static void main(String[] args) throws IOException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5434/pg_nlw");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");

        CreateSeed createSeed = new CreateSeed(dataSource);
        createSeed.run();
    }
}
