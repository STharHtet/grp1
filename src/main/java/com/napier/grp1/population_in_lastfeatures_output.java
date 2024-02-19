package com.napier.grp1;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * To show population in each continent with living in cities and not living in cities
 */
public class population_in_lastfeatures_output {
    /**
     * Prints a list of World sorted by population.
     * @param dataoutput The list of countries to print.
     */
    public void printPopulationineachcontinent(ArrayList<populationppl> dataoutput)
    {

        // Print top border
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");

        // Print header
        System.out.println(String.format("| %-30s | %-30s | %-30s | %-30s |", "Continent", "TotalPopulation", "LivingInCities(%)", "NotLivingInCities(%)"));
        // Print header-bottom border
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");

        // Loop over all cities in the list
        for (populationppl pplpopcontinent : dataoutput)
        {
            // Format population with commas and three decimal places
            DecimalFormat numformat = new DecimalFormat("#,###,###,###");
            String formattedPopulationcountry = numformat.format(pplpopcontinent.getCountry_total_population());
            String formattedPopulationcity = numformat.format(pplpopcontinent.getCity_total_population());
            String formattednotlivingcities = numformat.format(pplpopcontinent.getTotal_not_livingcites());

            // Add Living in cities in each continent with percentage
            String livingcitiesper = String.format("%-20s (%s)", formattedPopulationcity, pplpopcontinent.getLiving_in_cities());

            // Add Not Living in cities in each region with percentage
            String notlivingcitiesper = String.format("%-20s (%s)", formattednotlivingcities, pplpopcontinent.getNot_living_in_cities());

            String count_string =
                    String.format("| %-30s | %-30s | %-30s | %-30s |",
                            pplpopcontinent.getContinent_ppl(), formattedPopulationcountry, livingcitiesper, notlivingcitiesper);
            System.out.println(count_string);
        }
        // Print bottom border
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
    }

    /**
     * To print the population in each region
     * @param dataoutput
     */
    public void printPopulationineachregion(ArrayList<populationppl> dataoutput)
    {

        // Print top border
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");

        // Print header
        System.out.println(String.format("| %-30s | %-30s | %-30s | %-30s |", "Region", "TotalPopulation", "LivingInCities(%)", "NotLivingInCities(%)"));
        // Print header-bottom border
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");

        // Loop over all cities in the list
        for (populationppl pplpopcontinent : dataoutput)
        {
            // Format population with commas and three decimal places
            DecimalFormat numformat = new DecimalFormat("#,###,###,###");
            String formattedPopulationcountry = numformat.format(pplpopcontinent.getCountry_total_population());
            String formattedPopulationcity = numformat.format(pplpopcontinent.getCity_total_population());
            String formattednotlivingcities = numformat.format(pplpopcontinent.getTotal_not_livingcites());

            // Add Living in cities in each continent with percentage
            String livingcitiesper = String.format("%-20s (%s)", formattedPopulationcity, pplpopcontinent.getLiving_in_cities());

            // Add Not Living in cities in each region with percentage
            String notlivingcitiesper = String.format("%-20s (%s)", formattednotlivingcities, pplpopcontinent.getNot_living_in_cities());

            String count_string =
                    String.format("| %-30s | %-30s | %-30s | %-30s |",
                            pplpopcontinent.getRegion_ppl(), formattedPopulationcountry, livingcitiesper, notlivingcitiesper);
            System.out.println(count_string);
        }
        // Print bottom border
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
    }

    /**
     * to print out the population in each country
     * @param dataoutput
     */
    public void printPopulationineachcountry(ArrayList<populationppl> dataoutput)
    {

        // Print top border
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+---------+");

        // Print header
        System.out.println(String.format("| %-40s | %-30s | %-30s | %-30s |", "Country", "TotalPopulation", "LivingInCities(%)", "NotLivingInCities(%)"));
        // Print header-bottom border
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+---------+");

        // Loop over all cities in the list
        for (populationppl pplpopcontinent : dataoutput)
        {
            // Format population with commas and three decimal places
            DecimalFormat numformat = new DecimalFormat("#,###,###,###");
            String formattedPopulationcountry = numformat.format(pplpopcontinent.getCountry_total_population());
            String formattedPopulationcity = numformat.format(pplpopcontinent.getCity_total_population());
            String formattednotlivingcities = numformat.format(pplpopcontinent.getTotal_not_livingcites());

            // Add Living in cities in each continent with percentage
            String livingcitiesper = String.format("%-20s (%s)", formattedPopulationcity, pplpopcontinent.getLiving_in_cities());

            // Add Not Living in cities in each region with percentage
            String notlivingcitiesper = String.format("%-20s (%s)", formattednotlivingcities, pplpopcontinent.getNot_living_in_cities());

            String count_string =
                    String.format("| %-40s | %-30s | %-30s | %-30s |",
                            pplpopcontinent.getCountry_name(), formattedPopulationcountry, livingcitiesper, notlivingcitiesper);
            System.out.println(count_string);
        }
        // Print bottom border
        System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+---------+");
    }

    /**
     * To print out the population in world
     * @param dataoutput
     */
    public void printPopulationinworld(ArrayList<populationppl> dataoutput)
    {

        // Print top border
        System.out.println("+---------------------+---------------------+---------------------+----------+");

        // Print header
        System.out.println(String.format("| %-40s | %-30s |", " ","TotalPopulation"));
        // Print header-bottom border
        System.out.println("+---------------------+---------------------+---------------------+----------+");

        // Loop over all cities in the list
        for (populationppl pplpopcontinent : dataoutput)
        {
            // Format population with commas and three decimal places
            DecimalFormat numformat = new DecimalFormat("#,###,###,###");
            String formattedPopulationworld = numformat.format(pplpopcontinent.getWorld_total());

            String count_string =
                    String.format("| %-40s | %-30s |", "Total Population in World", formattedPopulationworld);
            System.out.println(count_string);
        }
        // Print bottom border
        System.out.println("+---------------------+---------------------+---------------------+----------+");
    }

    /**
     * To print out the population in a continent
     * @param dataoutput
     */
    public void printPopulationinacontinent(ArrayList<populationppl> dataoutput)
    {

        // Print top border
        System.out.println("+---------------------+---------------------+-----------+");

        // Print header
        System.out.println(String.format("| %-20s | %-30s |", "Continent","TotalPopulation in a continent"));
        // Print header-bottom border
        System.out.println("+---------------------+---------------------+-----------+");

        // Loop over all cities in the list
        for (populationppl pplpopcontinent : dataoutput)
        {
            // Format population with commas and three decimal places
            DecimalFormat numformat = new DecimalFormat("#,###,###,###");
            String formattedPopulationinacontinent = numformat.format(pplpopcontinent.getPopulationinacontinent());

            String count_string =
                    String.format("| %-20s | %-30s |", pplpopcontinent.getContinent_name(), formattedPopulationinacontinent);
            System.out.println(count_string);
        }
        // Print bottom border
        System.out.println("+---------------------+---------------------+-----------+");
    }

    /**
     * To print out the population in a region
     * @param dataoutput
     */
    public void printPopulationinaregion(ArrayList<populationppl> dataoutput)
    {

        // Print top border
        System.out.println("+---------------------+---------------------+-----------+");

        // Print header
        System.out.println(String.format("| %-20s | %-30s |", "Region","TotalPopulation in a region"));
        // Print header-bottom border
        System.out.println("+---------------------+---------------------+-----------+");

        // Loop over all cities in the list
        for (populationppl pplpopregion : dataoutput)
        {
            // Format population with commas and three decimal places
            DecimalFormat numformat = new DecimalFormat("#,###,###,###");
            String formattedPopulationinaregion = numformat.format(pplpopregion.getPopulationinaregion());

            String count_string =
                    String.format("| %-20s | %-30s |", pplpopregion.getRegion_name(), formattedPopulationinaregion);
            System.out.println(count_string);
        }
        // Print bottom border
        System.out.println("+---------------------+---------------------+-----------+");
    }

    /**
     * to print out the total population in a country
     * @param dataoutput
     */
    public void printPopulationinacountry(ArrayList<populationppl> dataoutput)
    {

        // Print top border
        System.out.println("+---------------------+---------------------+-----------+");

        // Print header
        System.out.println(String.format("| %-20s | %-30s |", "Country","TotalPopulation in a country"));
        // Print header-bottom border
        System.out.println("+---------------------+---------------------+-----------+");

        // Loop over all cities in the list
        for (populationppl pplpopcountry : dataoutput)
        {
            // Format population with commas and three decimal places
            DecimalFormat numformat = new DecimalFormat("#,###,###,###");
            String formattedPopulationinacountry= numformat.format(pplpopcountry.getPopulationinacountry());

            String count_string =
                    String.format("| %-20s | %-30s |", pplpopcountry.getCountry_name(), formattedPopulationinacountry);
            System.out.println(count_string);
        }
        // Print bottom border
        System.out.println("+---------------------+---------------------+-----------+");
    }

    /**
     * To print out the total population in a district
     * @param dataoutput
     */
    public void printPopulationinadistrict(ArrayList<populationppl> dataoutput)
    {

        // Print top border
        System.out.println("+---------------------+---------------------+-----------+");

        // Print header
        System.out.println(String.format("| %-20s | %-30s |", "District","TotalPopulation in a district"));
        // Print header-bottom border
        System.out.println("+---------------------+---------------------+-----------+");

        // Loop over all cities in the list
        for (populationppl pplpopdistrict : dataoutput)
        {
            // Format population with commas and three decimal places
            DecimalFormat numformat = new DecimalFormat("#,###,###,###");
            String formattedPopulationinadistrict = numformat.format(pplpopdistrict.getDistrict_total_population());

            String count_string =
                    String.format("| %-20s | %-30s |", pplpopdistrict.getDistrict_name(), formattedPopulationinadistrict);
            System.out.println(count_string);
        }
        // Print bottom border
        System.out.println("+---------------------+---------------------+-----------+");
    }

    /**
     * To print out the total population in a city
     * @param dataoutput
     */
    public void printPopulationinacity(ArrayList<populationppl> dataoutput)
    {

        // Print top border
        System.out.println("+---------------------+---------------------+-----------+");

        // Print header
        System.out.println(String.format("| %-20s | %-30s |", "City","TotalPopulation in a city"));
        // Print header-bottom border
        System.out.println("+---------------------+---------------------+-----------+");

        // Loop over all cities in the list
        for (populationppl pplpopcity : dataoutput)
        {
            // Format population with commas and three decimal places
            DecimalFormat numformat = new DecimalFormat("#,###,###,###");
            String formattedPopulationinacity = numformat.format(pplpopcity.getInacity_total_population());

            String count_string =
                    String.format("| %-20s | %-30s |", pplpopcity.getCity_name(), formattedPopulationinacity);
            System.out.println(count_string);
        }
        // Print bottom border
        System.out.println("+---------------------+---------------------+-----------+");
    }
}
