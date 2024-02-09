package com.napier.grp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * The following class is where all the CapCityMethods are stored in.
 * The App class (main class) would call these methods from the class
 * in order to work with them
 */
public class CapCityMethod {

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from CapCity class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the city name, country name and city
     * population and sorts the data by population in descending order
     * (largest to smallest population). The method extracts all capital
     * cities in the world
     * @param con is used to attempting connection with the database
     */
    public ArrayList<CapCity> getCapCities(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID "
                            + "ORDER BY city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country and city(Name) information
            ArrayList<CapCity> capitals = new ArrayList<CapCity>();
            while (rset.next())
            {
                CapCity cap = new CapCity();
                cap.setCap_city_name(rset.getString("city.Name"));
                cap.setCap_city_country(rset.getString("country.Name"));
                cap.setCap_city_population(rset.getInt("city.Population"));
                capitals.add(cap);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from CapCity class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the city name, country name and city
     * population and sorts the data by population in descending order
     * (largest to smallest population). The method extracts all capital
     * cities based on continent.
     * @param con is used to attempting connection with the database
     * @param capCityContinent is used in order to take input for which
     * continent to be made use of for the table to sorted with.
     */
    public ArrayList<CapCity> getCapCitiesByContinent(Connection con, String capCityContinent)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID AND country.Continent = ?"
                            + "ORDER BY city.Population DESC ";
            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,capCityContinent);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract capital city information
            ArrayList<CapCity> capitals = new ArrayList<CapCity>();
            while (rset.next())
            {
                CapCity cap = new CapCity();
                cap.setCap_city_name(rset.getString("city.Name"));
                cap.setCap_city_country(rset.getString("country.Name"));
                cap.setCap_city_population(rset.getInt("city.Population"));
                capitals.add(cap);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from CapCity class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the city name, country name and city
     * population and sorts the data by population in descending order
     * (largest to smallest population). The method extracts capital
     * cities based on region.
     * @param con is used to attempting connection with the database
     * @param capCityRegion is used in order to take input for which
     * region to be made use of for the table to sorted with.
     */
    public ArrayList<CapCity> getCapCitiesByRegion(Connection con, String capCityRegion)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID AND country.Region = ?"
                            + "ORDER BY city.Population DESC ";
            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,capCityRegion);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract capital city information
            ArrayList<CapCity> capitals = new ArrayList<CapCity>();
            while (rset.next())
            {
                CapCity cap = new CapCity();
                cap.setCap_city_name(rset.getString("city.Name"));
                cap.setCap_city_country(rset.getString("country.Name"));
                cap.setCap_city_population(rset.getInt("city.Population"));
                capitals.add(cap);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from CapCity class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the city name, country name and city
     * population and sorts the data by population in descending order
     * (largest to smallest population). The method extracts N number
     * of capital cities.
     * @param con is used to attempting connection with the database
     * @param lim defines the N number of cities
     */
    public ArrayList<CapCity> getTopTenCapCities(Connection con, int lim)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID "
                            + "ORDER BY city.Population DESC LIMIT " + lim;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country and city(Name) information
            ArrayList<CapCity> capitals = new ArrayList<CapCity>();
            while (rset.next())
            {
                CapCity cap = new CapCity();
                cap.setCap_city_name(rset.getString("city.Name"));
                cap.setCap_city_country(rset.getString("country.Name"));
                cap.setCap_city_population(rset.getInt("city.Population"));
                capitals.add(cap);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from CapCity class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the city name, country name and city
     * population and sorts the data by population in descending order
     * (largest to smallest population). The method extracts N number
     * of capital cities based on the continent.
     * @param con is used to attempting connection with the database
     * @param capCityContinent is used in order to take input for which
     * continent to be made use of for the table to sorted with.
     * @param lim defines the N number of cities
     */
    public ArrayList<CapCity> getTopTenCapCitiesByContinent(Connection con, String capCityContinent, int lim)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population, country.Continent "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID AND country.Continent = ?"
                            + "ORDER BY city.Population DESC LIMIT " + lim;
            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,capCityContinent);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract capital city information
            ArrayList<CapCity> capitals = new ArrayList<CapCity>();
            while (rset.next())
            {
                CapCity cap = new CapCity();
                cap.setCap_city_name(rset.getString("city.Name"));
                cap.setCap_city_country(rset.getString("country.Name"));
                cap.setCap_city_population(rset.getInt("city.Population"));
                cap.setCap_city_continent(rset.getString("country.Continent"));
                capitals.add(cap);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from CapCity class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the city name, country name and city
     * population and sorts the data by population in descending order
     * (largest to smallest population). The method extracts N number
     * of capital cities based on the region.
     * @param con is used to attempting connection with the database
     * @param capCityRegion is used in order to take input for which
     * region to be made use of for the table to sorted with.
     * @param lim defines the N number of cities
     */
    public ArrayList<CapCity> getTopTenCapCitiesByRegion(Connection con, String capCityRegion, int lim)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population, country.Region "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID AND country.Region = ?"
                            + "ORDER BY city.Population DESC LIMIT " + lim;
            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,capCityRegion);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();

            // Extract capital city information
            ArrayList<CapCity> capitals = new ArrayList<CapCity>();
            while (rset.next())
            {
                CapCity cap = new CapCity();
                cap.setCap_city_name(rset.getString("city.Name"));
                cap.setCap_city_country(rset.getString("country.Name"));
                cap.setCap_city_population(rset.getInt("city.Population"));
                cap.setCap_city_continent(rset.getString("country.Region"));
                capitals.add(cap);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }
}
