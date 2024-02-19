package com.napier.grp1;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * To show the output from the method of languages output
 */
public class populationwithlanguagesoutput {

    /**
     * Prints a formatted table displaying information about languages and the population
     * of people who speak those languages, along with the corresponding percentages.
     *
     * @param dataoutput An ArrayList of 'languages' objects containing language data.
     */
    public void printPopulationoflanguages(ArrayList<languages> dataoutput) {
        // Print top border
        System.out.println("+---------------------+---------------------+---------------------+--------------+");

        // Print header
        // Put Continent (30) or Region (30) below for display
        System.out.println(String.format("| %-20s | %-30s |", "Languages", "Population of people who spoke these languages (with %)"));
        // Print header-bottom border
        System.out.println("+---------------------+---------------------+---------------------+--------------+");

        // Loop over all capital cities in the list
        for (languages ldatapopl : dataoutput) {
            // Format population with commas and three decimal places
            DecimalFormat numformat = new DecimalFormat("#,###,###");
            String formattedPopulationlang = numformat.format(ldatapopl.getPopulation_with_languages());

            String percentageoflangaugepopl = String.format("%-20s (%s)", formattedPopulationlang, ldatapopl.getPercentage_population());

            // Put cap.getCap_city_continent() to display Continent data
            // Put cap.getCap_city_region() to display Region data
            String count_string =
                    String.format("| %-20s | %-30s |",
                            ldatapopl.getLanguages_data(), percentageoflangaugepopl);
            System.out.println(count_string);
        }
        // Print bottom border
        System.out.println("+---------------------+---------------------+-----------+");
    }
}

