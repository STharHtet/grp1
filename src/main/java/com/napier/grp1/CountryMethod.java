package com.napier.grp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The following class is where all the CountryMethods are stored in.
 * The App class (main class) would call these methods from the class
 * in order to work with them
 */
public class CountryMethod {
    /**
     * The following method is to extract data from the world database
     * using SQL statements and make use of setters from Country class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the country code, country name, country
     * continent, country region and country population and sorts the
     * data by population in descending order (largest to smallest population).
     * The method extracts all countries in the world.
     * @param con is used to attempting connection with the database
     */
    public ArrayList<Country> getCountry(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID "
                            + "ORDER BY country.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country and city(Name) information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country cou = new Country();
                cou.setCountry_code(rset.getString("country.Code"));
                cou.setCountry_name(rset.getString("country.Name"));
                cou.setContinent(rset.getString("country.Continent"));
                cou.setRegion(rset.getString("country.Region"));
                cou.setPopulation(rset.getInt("country.Population"));
                cou.setCity_name(rset.getString("city.Name"));
                countries.add(cou);
            }
            return countries;
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
     * using SQL statements and make use of setters from Country class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the country code, country name, country
     * continent, country region and country population and sorts the
     * data by population in descending order (largest to smallest population).
     * The method extracts all countries based on continent.
     * @param con is used to attempting connection with the database
     * @param inContinent is used in order to take input for which continent
     * to be made use of for the table to be sorted with.
     */
    public ArrayList<Country> getCountriesByContinent(Connection con, String inContinent)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID AND country.Continent = ?"
                            + "ORDER BY country.Population DESC ";
            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,inContinent);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();
            // Extract country and city(Name) information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country cou = new Country();
                cou.setCountry_code(rset.getString("country.Code"));
                cou.setCountry_name(rset.getString("country.Name"));
                cou.setContinent(rset.getString("country.Continent"));
                cou.setRegion(rset.getString("country.Region"));
                cou.setPopulation(rset.getInt("country.Population"));
                cou.setCity_name(rset.getString("city.Name"));
                countries.add(cou);
            }
            return countries;
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
     * using SQL statements and make use of setters from Country class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the country code, country name, country
     * continent, country region and country population and sorts the
     * data by population in descending order (largest to smallest population).
     * The method extracts all countries based on region.
     * @param con is used to attempting connection with the database
     * @param regionn is used in order to take input for which region
     * to be made use of for the table to be sorted with.
     */
    public ArrayList<Country> region_data(Connection con, String regionn)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID AND country.Region = ? "
                            + "ORDER BY Region ASC ,Population DESC ";

            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,regionn);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();
            // Extract country and city(Name) information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country cou = new Country();
                cou.setCountry_code(rset.getString("country.Code"));
                cou.setCountry_name(rset.getString("country.Name"));
                cou.setContinent(rset.getString("country.Continent"));
                cou.setRegion(rset.getString("country.Region"));
                cou.setPopulation(rset.getInt("country.Population"));
                cou.setCity_name(rset.getString("city.Name"));
                countries.add(cou);
            }
            return countries;
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
     * using SQL statements and make use of setters from Country class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the country code, country name, country
     * continent, country region and country population and sorts the
     * data by population in descending order (largest to smallest population).
     * The method extracts N number of countries.
     * @param con is used to attempting connection with the database
     * @param limit defines the N number of countries
     */
    public ArrayList<Country> getTenCountry(Connection con, int limit)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID "
                            + "ORDER BY country.Population DESC LIMIT ? ";

            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setInt(1, limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();
            // Extract country and city(Name) information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country cou = new Country();
                cou.setCountry_code(rset.getString("country.Code"));
                cou.setCountry_name(rset.getString("country.Name"));
                cou.setContinent(rset.getString("country.Continent"));
                cou.setRegion(rset.getString("country.Region"));
                cou.setPopulation(rset.getInt("country.Population"));
                cou.setCity_name(rset.getString("city.Name"));
                countries.add(cou);
            }
            return countries;
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
     * using SQL statements and make use of setters from Country class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the country code, country name, country
     * continent, country region and country population and sorts the
     * data by population in descending order (largest to smallest population).
     * The method extracts N number of countries.
     * @param con is used to attempting connection with the database
     * @param inContinent is used in order to take input for which
     * continent to be made use of for the table to sorted with.
     * @param limit defines the N number of countries
     */
    public ArrayList<Country> getTenCountriesByContinent(Connection con, String inContinent, int limit)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID AND country.Continent = ?"
                            + "ORDER BY country.Population DESC LIMIT ? ";
            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,inContinent);
            stmt.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();
            // Extract country and city(Name) information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country cou = new Country();
                cou.setCountry_code(rset.getString("country.Code"));
                cou.setCountry_name(rset.getString("country.Name"));
                cou.setContinent(rset.getString("country.Continent"));
                cou.setRegion(rset.getString("country.Region"));
                cou.setPopulation(rset.getInt("country.Population"));
                cou.setCity_name(rset.getString("city.Name"));
                countries.add(cou);
            }
            return countries;
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
     * using SQL statements and make use of setters from Country class
     * in order to set appropriate variables with the extracted data.
     * The method below extracts the country code, country name, country
     * continent, country region and country population and sorts the
     * data by population in descending order (largest to smallest population).
     * The method extracts N number of countries.
     * @param con is used to attempting connection with the database
     * @param regionn is used in order to take input for which
     * continent to be made use of for the table to sorted with.
     * @param limit defines the N number of countries
     */
    public ArrayList<Country> getTenCountriesByRegion(Connection con, String regionn, int limit)
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name "
                            + "FROM country, city "
                            + "WHERE country.Capital = city.ID AND country.Region = ? "
                            + "ORDER BY Region ASC ,Population DESC LIMIT ? ";

            // Create an SQL statement
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1,regionn);
            stmt.setInt(2, limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();
            // Extract country and city(Name) information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country cou = new Country();
                cou.setCountry_code(rset.getString("country.Code"));
                cou.setCountry_name(rset.getString("country.Name"));
                cou.setContinent(rset.getString("country.Continent"));
                cou.setRegion(rset.getString("country.Region"));
                cou.setPopulation(rset.getInt("country.Population"));
                cou.setCity_name(rset.getString("city.Name"));
                countries.add(cou);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }



}
