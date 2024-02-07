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

        // Create a new country in the word object
        CountryMethod cw = new CountryMethod();
        CountryOutput coutput = new CountryOutput();
        // Create a new city in the word object
        CityMethod city = new CityMethod();
        CityOutput cityout = new CityOutput();

        // Input for Continent
        String input_continent = "Asia";
        // Input for Region
        String input_region = "Caribbean";

        // Array Countries, Region, Continents with the population largest to smallest
        // Extract country in the world from a class
        ArrayList<Country> countries = cw.getCountry(a.con);
        ArrayList<Country> continents = cw.getCountriesByContinent(a.con, "Asia");
        ArrayList<Country> region = cw.region_data(a.con,"caribbean");
        // Extract top ten countries in the world
        ArrayList<Country> tenCountries = cw.getTenCountry(a.con);
        //Extract top ten countries from the continent
        ArrayList<Country> tenContinents = cw.getTenCountriesByContinent(a.con,input_continent);
        // Extract top ten countries from the region
        ArrayList<Country> tenRegions = cw.getTenCountriesByRegion(a.con,input_region);
        // Extract cities by world
        ArrayList<City> cities = city.getCities(a.con);
        // Extract cities
        ArrayList<City> citiesContinent = city.getCitiesByContinent(a.con, input_continent);



        // Printing data
        System.out.println("All the countries in the world organised by largest population to smallest.");
        coutput.printPopulation(countries);
        System.out.println("All the countries in a continent organised by largest population to smallest. (Asia)");
        coutput.printPopulation(continents);
        System.out.println("All the countries in a region organised by largest population to smallest. (Caribbean)");
        coutput.printPopulation(region);
        // Printing data of the top 10 populated countries in the world
        System.out.println("The top 10 populated countries in the world.");
        coutput.printPopulation(tenCountries);
        //Print Data of top 10 populated countries in a continent
        System.out.println("The top 10 populated countries in a continent. (" + input_continent + ")");
        coutput.printPopulation(tenContinents);
        // Printing data of top 10 populated countries in a region
        System.out.println("The top 10 populated countries in a region. (" + input_region + ")");
        coutput.printPopulation(tenRegions);
        // Printing data of all cities in the world
        System.out.println("All the cities in the world organised by largest population to smallest.");
        cityout.printPopulation(cities);
        //Printing data of all cities in the world by continent
        System.out.println("All the cities in a continent organised by largest population to smallest. (" + input_continent + ")");
        cityout.printPopulation(citiesContinent);




        // Disconnect from database
        a.disconnect();
    }
}
