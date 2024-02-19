package com.napier.grp1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * to create sql query statement for the output
 */
public class populationoflanguagesmethod {

    /**
     * Retrieves language-related data, including the total population and percentage
     * for specific languages (Chinese, English, Hindi, Spanish, Arabic) across countries.
     *
     * @param con The database connection to execute the SQL query.
     * @return An ArrayList of 'languages' objects containing language data.
     *         Each object includes language name, total population with the language,
     *         and the percentage of the total population speaking the language.
     *         Returns null in case of an exception or failure.
     */
    public ArrayList<languages> countrylanguages(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT countrylanguage.Language, "
                            + "(SUM(country.Population * (countrylanguage.Percentage / 100))) AS `TotalPopulationwithlanguages`,"
                            + "CONCAT( "
                            +   "FORMAT("
                            +       "(SUM(country.Population * (countrylanguage.Percentage / 100)) / "
                            +       "(SELECT SUM(Population) FROM country)) * 100, "
                            +   "2), "
                            + "'%') AS `Percentageofpopulationlanguages` "
                            + "FROM country, countrylanguage WHERE country.Code = countrylanguage.CountryCode "
                            + "AND countrylanguage.Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') "
                            + "GROUP BY countrylanguage.Language ORDER BY TotalPopulationwithlanguages DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country and city(Name) information
            ArrayList<languages> languagesdata = new ArrayList<languages>();
            while (rset.next())
            {
                languages ldata = new languages();
                ldata.setLanguages_data(rset.getString("countrylanguage.Language"));
                ldata.setPopulation_with_languages(rset.getLong("TotalPopulationwithlanguages"));
                ldata.setPercentage_population(rset.getString("Percentageofpopulationlanguages"));
                languagesdata.add(ldata);
            }
            return languagesdata;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get languages data details");
            return null;
        }
    }
}
