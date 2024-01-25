package com.enviro365.enviroinvests.Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DbConnect is a small command-line tool used to initialize the SQLite database for the Enviro365 Investments application.
 */
public class DbConnect {

    public static final String DB_URL = "jdbc:sqlite:enviro365_investments.db";

    public static void main(String[] args) {
        final DbConnect dbInitializer = new DbConnect();
        dbInitializer.initializeDatabase();
    }

    private void initializeDatabase() {
        try (final Connection connection = DriverManager.getConnection(DB_URL)) {
            System.out.println("Connected to database: " + DB_URL);
            createInvestorTable(connection);
            createProductTable(connection);
            System.out.println("Database initialization successful!");
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }

    private void createInvestorTable(Connection connection) {
        try (final Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS investor (id INTEGER PRIMARY KEY, name TEXT, address TEXT, contact TEXT, age INTEGER)");
            System.out.println("Investor table created successfully!");
        } catch (SQLException e) {
            System.err.println("Error creating investor table: " + e.getMessage());
        }
    }

    private void createProductTable(Connection connection) {
        try (final Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS product (id INTEGER PRIMARY KEY, type TEXT, name TEXT, current_balance REAL)");
            System.out.println("Product table created successfully!");
        } catch (SQLException e) {
            System.err.println("Error creating product table: " + e.getMessage());
        }
    }
}