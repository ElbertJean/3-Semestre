package com.example.agropescajacare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class AgropescajacareApplication {

    public static void main(String[] args) {
        createDatabaseIfNotExists("lojapesca");
        SpringApplication.run(AgropescajacareApplication.class, args);
    }

    private static void createDatabaseIfNotExists(String databaseName) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Dgs589*-+";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databaseName);
            System.out.println("Banco de dados '" + databaseName + "' verificado/criado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar/verificar o banco de dados: " + e.getMessage(), e);
        }
    }
}
