package com.napier.grp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * The following class is where all the CityMethods are stored in.
 * The App class (main class) would call these methods from the class
 * in order to work with them
 */
public class CityMethod {

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from City class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the city name, country code, country name,
     * country continent, city district and city population
     * and sorts the data by population in descending order
     * (largest to smallest population). The method extracts all cities
     * in the world
     * @param con is used to attempting connection with the database
     */
    public ArrayList<City> getCities(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, country.Continent, city.District, city.Population, country.Name "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "ORDER BY city.Population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City cit = new City();
                cit.setCity_name(rset.getString("city.Name"));
                cit.setCountry_code(rset.getString("city.CountryCode"));
                cit.setCountry_name(rset.getString("country.Name"));
                cit.setCity_continent(rset.getString("country.Continent"));
                cit.setCity_district(rset.getString("city.District"));
                cit.setCity_population(rset.getInt("city.Population"));
                cities.add(cit);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from City class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the city name, country code, country name,
     * country continent, city district and city population and sorts
     * the data by population in descending order (largest to smallest population).
     * The method extracts all cities based on continent.
     * @param con is used to attempting connection with the database
     * @param cityContinent is used in order to take input for which
     * continent to be made use of for the table to sorted with.
     */
    public ArrayList<City> getCitiesByContinent(Connection con, String cityContinent) {
        try {

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, country.Continent, city.District, city.Population, country.Name "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Continent = ? "
                            + "ORDER BY city.Population DESC ";

            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1, cityContinent);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City cit = new City();
                cit.setCity_name(rset.getString("city.Name"));
                cit.setCountry_code(rset.getString("city.CountryCode"));
                cit.setCountry_name(rset.getString("country.Name"));
                cit.setCity_continent(rset.getString("country.Continent"));
                cit.setCity_district(rset.getString("city.District"));
                cit.setCity_population(rset.getInt("city.Population"));
                cities.add(cit);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from City class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the city name, country code, country name,
     * country continent, city district and city population and sorts
     * the data by population in descending order (largest to smallest population).
     * The method extracts all cities based on region.
     * @param con is used to attempting connection with the database
     * @param cityRegion is used in order to take input for which
     * continent to be made use of for the table to sorted with.
     */
    public ArrayList<City> getCitiesByRegion(Connection con, String cityRegion) {
        try {

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, country.Region, city.District, city.Population, country.Name "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Region = ? "
                            + "ORDER BY city.Population DESC ";

            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,cityRegion);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City cit = new City();
                cit.setCity_name(rset.getString("city.Name"));
                cit.setCountry_code(rset.getString("city.CountryCode"));
                cit.setCountry_name(rset.getString("country.Name"));
                cit.setCity_region(rset.getString("country.Region"));
                cit.setCity_district(rset.getString("city.District"));
                cit.setCity_population(rset.getInt("city.Population"));
                cities.add(cit);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from City class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the city name, country code, country name,
     * country continent, city district and city population and sorts
     * the data by population in descending order (largest to smallest population).
     * The method extracts all cities based on country.
     * @param con is used to attempting connection with the database
     * @param cityCountry is used in order to take input for which
     * continent to be made use of for the table to sorted with.
     */
    public ArrayList<City> getCitiesByCountry(Connection con, String cityCountry) {
        try {

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population, country.Name "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Name = ? "
                            + "ORDER BY city.Population DESC ";

            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,cityCountry);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City cit = new City();
                cit.setCity_name(rset.getString("city.Name"));
                cit.setCountry_code(rset.getString("city.CountryCode"));
                cit.setCountry_name(rset.getString("country.Name"));
                cit.setCity_district(rset.getString("city.District"));
                cit.setCity_population(rset.getInt("city.Population"));
                cities.add(cit);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from City class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the city name, country code, country name,
     * country continent, city district and city population and sorts
     * the data by population in descending order (largest to smallest population).
     * The method extracts all cities based on district.
     * @param con is used to attempting connection with the database
     * @param cityDistrict is used in order to take input for which
     * district to be made use of for the table to sorted with.
     */
    public ArrayList<City> getCitiesByDistrict(Connection con, String cityDistrict) {
        try {

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population, country.Name "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND city.District = ? "
                            + "ORDER BY city.Population DESC ";

            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,cityDistrict);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City cit = new City();
                cit.setCity_name(rset.getString("city.Name"));
                cit.setCountry_code(rset.getString("city.CountryCode"));
                cit.setCountry_name(rset.getString("country.Name"));
                cit.setCity_district(rset.getString("city.District"));
                cit.setCity_population(rset.getInt("city.Population"));
                cities.add(cit);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from City class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts city name, country code, country name,
     * country continent, city district and city population and sorts
     * the data by population in descending order
     * (largest to smallest population). The method extracts N number
     * of cities.
     * @param con is used to attempting connection with the database
     * @param limit defines the N number of cities
     */
    public ArrayList<City> getTopTenCities(Connection con, int limit) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, country.Continent, city.District, city.Population, country.Name "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "ORDER BY city.Population DESC LIMIT " + limit;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract city information report
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City cit = new City();
                cit.setCity_name(rset.getString("city.Name"));
                cit.setCountry_code(rset.getString("city.CountryCode"));
                cit.setCountry_name(rset.getString("country.Name"));
                cit.setCity_continent(rset.getString("country.Continent"));
                cit.setCity_district(rset.getString("city.District"));
                cit.setCity_population(rset.getInt("city.Population"));
                cities.add(cit);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from City class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts city name, country code, country name,
     * country continent, city district and city population and sorts
     * the data by population in descending order
     * (largest to smallest population). The method extracts N number
     * of cities.
     * @param con is used to attempting connection with the database
     * @param cityContinent is used in order to take input for which
     * continent to be made use of for the table to sorted with.
     * @param limit defines the N number of cities
     */
    public ArrayList<City> getTopTenCitiesByContinent(Connection con, String cityContinent, int limit) {
        try {


            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, country.Continent, city.District, city.Population, country.Name "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Continent = ? "
                            + "ORDER BY city.Population DESC LIMIT " + limit;

            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,cityContinent);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City cit = new City();
                cit.setCity_name(rset.getString("city.Name"));
                cit.setCountry_code(rset.getString("city.CountryCode"));
                cit.setCountry_name(rset.getString("country.Name"));
                cit.setCity_continent(rset.getString("country.Continent"));
                cit.setCity_district(rset.getString("city.District"));
                cit.setCity_population(rset.getInt("city.Population"));
                cities.add(cit);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from City class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts city name, country code, country name,
     * country continent, city district and city population and sorts
     * the data by population in descending order
     * (largest to smallest population). The method extracts N number
     * of cities.
     * @param con is used to attempting connection with the database
     * @param cityRegion is used in order to take input for which
     * region to be made use of for the table to sorted with.
     * @param limit defines the N number of cities
     */
    public ArrayList<City> getTopTenCitiesByRegion(Connection con, String cityRegion, int limit) {
        try {


            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, country.Region, city.District, city.Population, country.Name "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Region = ? "
                            + "ORDER BY city.Population DESC LIMIT " + limit;

            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,cityRegion);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City cit = new City();
                cit.setCity_name(rset.getString("city.Name"));
                cit.setCountry_code(rset.getString("city.CountryCode"));
                cit.setCountry_name(rset.getString("country.Name"));
                cit.setCity_region(rset.getString("country.Region"));
                cit.setCity_district(rset.getString("city.District"));
                cit.setCity_population(rset.getInt("city.Population"));
                cities.add(cit);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from City class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts city name, country code, country name,
     * country continent, city district and city population and sorts
     * the data by population in descending order
     * (largest to smallest population). The method extracts N number
     * of cities.
     * @param con is used to attempting connection with the database
     * @param cityCountry is used in order to take input for which
     * country to be made use of for the table to sorted with.
     * @param limit defines the N number of cities
     */
    public ArrayList<City> getTopTenCitiesByCountry(Connection con, String cityCountry, int limit) {
        try {
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population, country.Name "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND country.Name = ? "
                            + "ORDER BY city.Population DESC LIMIT " + limit;

            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,cityCountry);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City cit = new City();
                cit.setCity_name(rset.getString("city.Name"));
                cit.setCountry_code(rset.getString("city.CountryCode"));
                cit.setCountry_name(rset.getString("country.Name"));
                cit.setCity_district(rset.getString("city.District"));
                cit.setCity_population(rset.getInt("city.Population"));
                cities.add(cit);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from City class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts city name, country code, country name,
     * country continent, city district and city population and sorts
     * the data by population in descending order
     * (largest to smallest population). The method extracts N number
     * of cities.
     * @param con is used to attempting connection with the database
     * @param cityDistrict is used in order to take input for which
     * district to be made use of for the table to sorted with.
     * @param limit defines the N number of cities
     */
    public ArrayList<City> getTopTenCitiesByDistrict(Connection con, String cityDistrict, int limit) {
        try {


            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population, country.Name "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code AND city.District = ? "
                            + "ORDER BY city.Population DESC LIMIT " + limit;

            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,cityDistrict);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next()) {
                City cit = new City();
                cit.setCity_name(rset.getString("city.Name"));
                cit.setCountry_code(rset.getString("city.CountryCode"));
                cit.setCountry_name(rset.getString("country.Name"));
                cit.setCity_district(rset.getString("city.District"));
                cit.setCity_population(rset.getInt("city.Population"));
                cities.add(cit);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

}
