package com.napier.grp1;

import java.sql.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class App {
    /**
     * Connection to MySQL database.
     */
    public Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay) {
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
                con = DriverManager.getConnection("jdbc:mysql://"+ location +"/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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
        if (args.length < 1) {
            a.connect("localhost:33060", 30000);
        }else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // Create a new country in the word object
        CountryMethod cw = new CountryMethod();
        CountryOutput coutput = new CountryOutput();
        // Create a new city in the word object
        CityMethod city = new CityMethod();
        CityOutput cityout = new CityOutput();
        // Create a new capital city in the word object
        CapCityMethod capcity = new CapCityMethod();
        CapCityOutput capcityout = new CapCityOutput();


        // Input for Continent
        String input_continent = "Asia";
        // Input for Region
        String input_region = "Caribbean";
        // Input for Country
        String input_country = "Myanmar";
        // Input for District
        String input_district = "Tokyo-to";
        // For limit the populated cities
        int limit = 10;


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
        // Extract cities by inputted continent
        ArrayList<City> citiesContinent = city.getCitiesByContinent(a.con, input_continent);
        // Extract cities by inputted region
        ArrayList<City> citiesRegion = city.getCitiesByRegion(a.con, input_region);
        // Extract cities by inputted country
        ArrayList<City> citiesCountry = city.getCitiesByCountry(a.con, input_country);
        // Extract cities by inputted continent
        ArrayList<City> citiesDistrict = city.getCitiesByDistrict(a.con, input_district);
        // Extract top ten cities by world
        ArrayList<City> top_ten_cities = city.getTopTenCities(a.con, limit);
        // Extract top ten cities by continent
        ArrayList<City> top_ten_cities_continent = city.getTopTenCitiesByContinent(a.con, input_continent, limit);
        // Extract top ten cities by region
        ArrayList<City> top_ten_cities_region = city.getTopTenCitiesByRegion(a.con, input_region, limit);
        // Extract top ten cities by county
        ArrayList<City> top_ten_cities_country = city.getTopTenCitiesByCountry(a.con, input_country, limit);
        // Extract top ten cities by district
        ArrayList<City> top_ten_cities_district = city.getTopTenCitiesByDistrict(a.con, input_district, limit);
        // For HHS
        // Extract capital cities in the world
        ArrayList<CapCity> capcities = capcity.getCapCities(a.con);
        // Extract top ten capital cities by world
        ArrayList<CapCity> top_ten_capcities = capcity.getTopTenCapCities(a.con, limit);
        // Extract top ten capital cities by continent
        ArrayList<CapCity> top_ten_capcities_continent = capcity.getTopTenCapCitiesByContinent(a.con, input_continent, limit);
        // Extract top ten capital cities by region
        ArrayList<CapCity> top_ten_capcities_region = capcity.getTopTenCapCitiesByRegion(a.con, input_region, limit);


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
        //Printing data of all cities in the world by inputted continent
        System.out.println("All the cities in a continent organised by largest population to smallest. (" + input_continent + ")");
        cityout.printPopulation(citiesContinent);
        // Printing data of all cities in the world by inputted region
        System.out.println("All the cities in a region organised by largest population to smallest. (" + input_region + ")");
        cityout.printPopulation(citiesRegion);
        // Printing data of all cities in the world by inputted country
        System.out.println("All the cities in a country organised by largest population to smallest. (" + input_country + ")");
        cityout.printPopulation(citiesCountry);
        // Printing data of all cities in the world by inputted district
        System.out.println("All the cities in a district organised by largest population to smallest. (" + input_district + ")");
        cityout.printPopulation(citiesDistrict);
        // Printing data of top N populated cities in the world.
        System.out.println("The top " + limit + " populated cities in the world.");
        cityout.printPopulation(top_ten_cities);
        // Printing data of top N populated cities in the continent.
        System.out.println("The top " +  limit + " populated cities in a continent. (" + input_continent + ")");
        cityout.printPopulation(top_ten_cities_continent);
        // Printing data of top N populated cities in the region.
        System.out.println("The top" + limit + " populated cities in a region. (" + input_region + ")");
        cityout.printPopulation(top_ten_cities_region);
        // Printing data of top N populated cities in the country.
        System.out.println("The top " + limit + " populated cities in a country. (" + input_country + ")");
        cityout.printPopulation(top_ten_cities_country);
        // Printing data of top N populated cities in the district.
        System.out.println("The top " + limit + " populated cities in a district. (" + input_district + ")");
        cityout.printPopulation(top_ten_cities_district);
        //For HHS
        // Printing data of capital cities in the world
        System.out.println("All the capital cities in the world organised by largest population to smallest.");
        capcityout.printPopulation(capcities);

        // Printing data of top N populated capital cities in the world.
        System.out.println("The top 10 populated capital cities in the world.");
        capcityout.printPopulation(top_ten_capcities);
        // Printing data of top N populated capital cities in the continent.
        System.out.println("The top 10 populated capital cities in a continent. (" + input_continent + ")");
        capcityout.printPopulation(top_ten_capcities_continent);
        // Printing data of top N populated capital cities in the region.
        System.out.println("The top 10 populated capital cities in a region. (" + input_region + ")");
        capcityout.printPopulation(top_ten_capcities_region);



        // Disconnect from database
        a.disconnect();
    }
}
