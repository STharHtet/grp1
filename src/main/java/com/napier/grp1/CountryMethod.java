package com.napier.grp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * For calling the method for SQL statement
 */
public class CountryMethod {

    /**
     * The following method is for World population
     * @param con
     * @return
     */
    public ArrayList<Country> getTenCountry(Connection con)
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
                            + "ORDER BY country.Population DESC LIMIT 10 ";
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

}
