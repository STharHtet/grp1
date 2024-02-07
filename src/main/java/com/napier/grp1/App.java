package com.napier.grp1;

import java.sql.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class App {
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * The following method is to call the classes to be run on the main Java class
     * @param args
     */
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();


        // Create a new capital city in the word object
        CapCityMethod capcity = new CapCityMethod();
        CapCityOutput capcityout = new CapCityOutput();

        // Input for Continent, Region, Country and District
        String input_continent = "Asia";
        String input_region = "Caribbean";
        String input_country = "Myanmar";
        String input_district = "Tokyo-to";
        int limit = 10;

        // Array Countries, Region, Continents with the population largest to smallest
        // Extract top ten capital cities
        ArrayList<CapCity> top_ten_capcities_continent = capcity.getTopTenCapCitiesByContinent(a.con, input_continent, limit);

        // Printing data
        System.out.println("The top 10 populated capital cities in a continent. (" + input_continent + ")");
        capcityout.printPopulation(top_ten_capcities_continent);

        // Disconnect from database
        a.disconnect();
    }
}
