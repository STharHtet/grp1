package com.napier.grp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Creating SQL query for each continent with living in cities and not living in cities
 * for the app to run by calling these method and put the collected array variables into
 * the print method
 */
public class population_lastfeatures_method {

    public ArrayList<populationppl> eachcontinent(Connection con) {
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT CTP.Continent, CTP.CityTotalPopulation, COP.CountryTotalPopulation, COP.CountryTotalPopulation - CTP.CityTotalPopulation AS `TotalNotLivingCities`, "
                            + "CONCAT(FORMAT((CTP.CityTotalPopulation / COP.CountryTotalPopulation) * 100, 2), '%') AS `LivingInCities`, "
                            + "CONCAT(FORMAT((COP.CountryTotalPopulation - CTP.CityTotalPopulation) / COP.CountryTotalPopulation * 100, 2), '%') AS `NotLivingInCities` FROM "
                            + "(SELECT country.Continent, SUM(city.Population) AS `CityTotalPopulation` FROM city, country WHERE city.CountryCode = country.Code GROUP BY country.Continent) CTP, "
                            + "(SELECT country.Continent, SUM(country.Population) AS `CountryTotalPopulation` FROM country GROUP BY country.Continent) COP WHERE CTP.Continent = COP.Continent ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<populationppl> ppleachcontinent = new ArrayList<populationppl>();
            while (rset.next()) {
                populationppl popppl = new populationppl();
                popppl.setContinent_ppl(rset.getString("CTP.Continent"));
                popppl.setCountry_total_population(rset.getLong("COP.CountryTotalPopulation"));
                popppl.setCity_total_population(rset.getLong("CTP.CityTotalPopulation"));
                popppl.setTotal_not_livingcites(rset.getLong("TotalNotLivingCities"));
                popppl.setLiving_in_cities(rset.getString("LivingInCities"));
                popppl.setNot_living_in_cities(rset.getString("NotLivingInCities"));
                ppleachcontinent.add(popppl);
            }
            return ppleachcontinent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public ArrayList<populationppl> eachregion(Connection con) {
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT RTP.Region, RTP.CityTotalPopulation, ROP.CountryTotalPopulation, ROP.CountryTotalPopulation - RTP.CityTotalPopulation AS `TotalNotlivingCities`, "
                            + "CONCAT(FORMAT((RTP.CityTotalPopulation / ROP.CountryTotalPopulation) * 100, 2), '%') AS `LivingInCities`, "
                            + "CONCAT(FORMAT((ROP.CountryTotalPopulation - RTP.CityTotalPopulation) / ROP.CountryTotalPopulation * 100, 2), '%') AS `NotLivingInCities` FROM "
                            + "(SELECT country.Region, SUM(city.Population) AS `CityTotalPopulation` FROM city, country WHERE city.CountryCode = country.Code GROUP BY country.Region) RTP, "
                            + "(SELECT country.Region, SUM(country.Population) AS `CountryTotalPopulation` FROM country GROUP BY country.Region) ROP WHERE RTP.Region = ROP.Region ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<populationppl> ppleachcontinent = new ArrayList<populationppl>();
            while (rset.next()) {
                populationppl popppl = new populationppl();
                popppl.setRegion_ppl(rset.getString("RTP.Region"));
                popppl.setCountry_total_population(rset.getLong("ROP.CountryTotalPopulation"));
                popppl.setCity_total_population(rset.getLong("RTP.CityTotalPopulation"));
                popppl.setTotal_not_livingcites(rset.getLong("TotalNotLivingCities"));
                popppl.setLiving_in_cities(rset.getString("LivingInCities"));
                popppl.setNot_living_in_cities(rset.getString("NotLivingInCities"));
                ppleachcontinent.add(popppl);
            }
            return ppleachcontinent;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public ArrayList<populationppl> eachcountry(Connection con) {
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT COUTP.Name, COUTP.CityTotalPopulation, CUOP.CountryTotalPopulation, CUOP.CountryTotalPopulation - COUTP.CityTotalPopulation AS `TotalNotlivingCities`, "
                            + "CONCAT(FORMAT((COUTP.CityTotalPopulation / CUOP.CountryTotalPopulation) * 100, 2), '%') AS `LivingInCities`, "
                            + "CONCAT(FORMAT((CUOP.CountryTotalPopulation - COUTP.CityTotalPopulation) / CUOP.CountryTotalPopulation * 100, 2), '%') AS `NotLivingInCities` FROM "
                            + "(SELECT country.Name, SUM(city.Population) AS `CityTotalPopulation` FROM city, country WHERE city.CountryCode = country.Code GROUP BY country.Name) COUTP, "
                            + "(SELECT country.Name, SUM(country.Population) AS `CountryTotalPopulation` FROM country GROUP BY country.Name) CUOP WHERE COUTP.Name = CUOP.Name ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<populationppl> ppleachcontinent = new ArrayList<populationppl>();
            while (rset.next()) {
                populationppl popppl = new populationppl();
                popppl.setCountry_name(rset.getString("COUTP.Name"));
                popppl.setCountry_total_population(rset.getLong("CUOP.CountryTotalPopulation"));
                popppl.setCity_total_population(rset.getLong("COUTP.CityTotalPopulation"));
                popppl.setTotal_not_livingcites(rset.getLong("TotalNotLivingCities"));
                popppl.setLiving_in_cities(rset.getString("LivingInCities"));
                popppl.setNot_living_in_cities(rset.getString("NotLivingInCities"));
                ppleachcontinent.add(popppl);
            }
            return ppleachcontinent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public ArrayList<populationppl> totalpopulationinworld(Connection con) {
        try {
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) AS `WorldTotal` FROM country";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<populationppl> ppleachcontinent = new ArrayList<populationppl>();
            while (rset.next()) {
                populationppl popppl = new populationppl();
                popppl.setWorld_total(rset.getLong("WorldTotal"));
                ppleachcontinent.add(popppl);
            }
            return ppleachcontinent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public ArrayList<populationppl> totalpopulationinacontinent(Connection con, String totalinacontinent) {
        try {

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Continent, SUM(country.Population) AS `ContinentTotal` FROM country "
                            + "WHERE country.Continent = ? ";


            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1, totalinacontinent);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();
            ArrayList<populationppl> ppleachcontinent = new ArrayList<populationppl>();
            while (rset.next()) {
                populationppl popppl = new populationppl();
                popppl.setPopulationinacontinent(rset.getLong("ContinentTotal"));
                popppl.setContinent_name(rset.getString("country.Continent"));
                ppleachcontinent.add(popppl);
            }
            return ppleachcontinent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }
    public ArrayList<populationppl> totalpopulationinaregion(Connection con, String totalinaregion) {
        try {

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Region, SUM(country.Population) AS `RegionTotal` FROM country "
                            + "WHERE country.Region = ? ";


            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1, totalinaregion);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();
            ArrayList<populationppl> ppleachcontinent = new ArrayList<populationppl>();
            while (rset.next()) {
                populationppl popppl = new populationppl();
                popppl.setPopulationinaregion(rset.getLong("RegionTotal"));
                popppl.setRegion_name(rset.getString("country.Region"));
                ppleachcontinent.add(popppl);
            }
            return ppleachcontinent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public ArrayList<populationppl> totalpopulationinacountry(Connection con, String totalinacountry) {
        try {

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, SUM(country.Population) AS `CountryTotal` FROM country "
                            + "WHERE country.Name = ? ";


            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1, totalinacountry);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();
            ArrayList<populationppl> ppleachcontinent = new ArrayList<populationppl>();
            while (rset.next()) {
                populationppl popppl = new populationppl();
                popppl.setPopulationinacountry(rset.getLong("CountryTotal"));
                popppl.setCountry_name(rset.getString("country.Name"));
                ppleachcontinent.add(popppl);
            }
            return ppleachcontinent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public ArrayList<populationppl> totalpopulationinadistrict(Connection con, String totalinadistrict) {
        try {

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.District, SUM(city.Population) AS `DistrictTotal` FROM country, city "
                            + "WHERE country.Code = city.CountryCode AND city.District = ? GROUP BY city.District ";


            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1, totalinadistrict);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();
            ArrayList<populationppl> ppleachcontinent = new ArrayList<populationppl>();
            while (rset.next()) {
                populationppl popppl = new populationppl();
                popppl.setDistrict_total_population(rset.getLong("DistrictTotal"));
                popppl.setDistrict_name(rset.getString("city.District"));
                ppleachcontinent.add(popppl);
            }
            return ppleachcontinent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public ArrayList<populationppl> totalpopulationinacity(Connection con, String totalinacity) {
        try {

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, SUM(city.Population) AS `CityTotal` FROM country, city "
                            + "WHERE country.Code = city.CountryCode AND city.Name = ? GROUP BY city.Name ";


            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.setString(1, totalinacity);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();
            ArrayList<populationppl> ppleachcontinent = new ArrayList<populationppl>();
            while (rset.next()) {
                populationppl popppl = new populationppl();
                popppl.setInacity_total_population(rset.getLong("CityTotal"));
                popppl.setCity_name(rset.getString("city.Name"));
                ppleachcontinent.add(popppl);
            }
            return ppleachcontinent;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }
}
