package com.napier.grp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CityMethod {

    //for top N cities by continent
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
}
