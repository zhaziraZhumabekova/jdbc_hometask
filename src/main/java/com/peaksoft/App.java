package com.peaksoft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        Database.connection();
//        createTableCity();
//        createTableCountry();
//        createTablePresident();
//        addCity(1,"Bishkek", 120000, 12, "Kyrgyzstan");
//        addCity(2,"Moscow", 880000, 45, "Russia");
//        addCity(3,"New Jersey", 7800000, 90, "USA");
//        addCity(4,"Roma", 1000000, 17, "Italy");
//        addCity(5,"New Deli", 12000000, 110, "India");
//        addCity(6,"Izmir", 450000, 34, "Turkey");
//        addCountry(11, "Kyrgyzstan", 7000000, 45, "Eurasiaa");
//        addCountry(22, "Turkey", 1200000, 80, "Eurasia");
//        addCountry(33, "USA", 4500000, 43, "South America");
//        addCountry(44, "Brasilia", 5400000, 160, "America");
//        addCountry(55, "Japan", 540000000, 98, "Eurasiia");
//        addPresident(1,"Sadyr", "Japarov", 2, "Kyrgyxstan");
//        addPresident(2,"Vladimir", "Putin", 8, "Russia");
//        addPresident(3,"REdjep", "erdogan", 5, "Turkey");
//        for (City city : getList()) {
//            System.out.println(city);
//        }
        getById(2);

    }


    public static void createTableCity() {
        String SQL = "CREATE TABLE CITY(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(500) NOT NULL," +
                "population INTEGER," +
                "count_of_region INTEGER," +
                "country_name VARCHAR (500));";
        try (Connection connection = Database.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void createTableCountry() {
        String SQL = "CREATE TABLE COUNTRY(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(500) NOT NULL," +
                "population INTEGER," +
                "count_of_cities INTEGER," +
                "mainland_name VARCHAR (500));";
        try (Connection connection = Database.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void createTablePresident() {
        String SQL = "CREATE TABLE PRESIDENT(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(500) NOT NULL," +
                "sure_name VARCHAR(500) NOT NULL," +
                "count_of_internship INTEGER," +
                "country_name VARCHAR (500) UNIQUE);";
        try (Connection connection = Database.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addCity(int id, String name, int population, int count_of_region, String country_name) {
        String SQL = "INSERT INTO CITY(id, name, population, count_of_region, country_name)" +
                "VALUES(?, ?, ?, ?, ?)";
        try (Connection con = Database.connection();
             PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, population);
            statement.setInt(4, count_of_region);
            statement.setString(5, country_name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCountry(int id, String name, int population, int count_of_cities, String mainland_name) {
        String SQL = "INSERT INTO COUNTRY(id, name, population, count_of_cities, mainland_name)" +
                "VALUES(?, ?, ?, ?, ?)";
        try (Connection con = Database.connection();
             PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, population);
            statement.setInt(4, count_of_cities);
            statement.setString(5, mainland_name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addPresident(int id, String name, String sure_name, int count_of_internship, String country_name) {
        String SQL = "INSERT INTO PRESIDENT(id, name, sure_name, count_of_internship, country_name)" +
                "VALUES(?, ?, ?, ?, ?)";
        try (Connection con = Database.connection();
             PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, sure_name);
            statement.setInt(4, count_of_internship);
            statement.setString(5, country_name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<City> getList() {
        String SQL = "SELECT * FROM CITY";
        List<City> cities = new ArrayList<>();
        try (Connection con = Database.connection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setPopulation(resultSet.getInt("population"));
                city.setCountOfRegion(resultSet.getInt("count_of_region"));
                city.setCountryName(resultSet.getString("country_name"));
                cities.add(city);
            }
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
        return cities;

    }

    public static void getById(int id) {
        String SQL = "SELECT * FROM CITY WHERE id = ?";
        try (Connection connection = Database.connection();
             PreparedStatement pr = connection.prepareStatement(SQL)) {
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            rs.next();
            System.out.println(rs.getInt("id") + " "
                    + rs.getString("name") + " "
                    + rs.getInt("population") + "  "
                    + rs.getInt("count_of_region") + " "
                    + rs.getString("country_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}