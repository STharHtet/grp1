package com.napier.grp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CapCityMethod {
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
}