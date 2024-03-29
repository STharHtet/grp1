package com.napier.grp1;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The following class is to store the method for printing out data
 * relating to countries
 */
public class CountryOutput {
    /**
     * The following method is to display data from methods used for capital
     * cities. There are 5 columns which are country code, country name, continent,
     * region, country population and capital city that will be displayed.
     * @param dataoutput is take input for which country method data
     * to be displayed.
     */
    public void printPopulation(ArrayList<Country> dataoutput)
    {

        try {
            // Print top border
            System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+--");

            // Print header
            System.out.println(String.format("| %-5s | %-50s | %-20s | %-30s | %-20s | %-35s |", "Code", "Name", "Continent", "Region", "Population", "Capital"));
            // Print header-bottom border
            System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+--");

            // Loop over all dataoutput in the list
            for (Country count : dataoutput)
            {
                // Format population with commas and three decimal places
                DecimalFormat numformat = new DecimalFormat("#,###,###");
                String formattedPopulation = numformat.format(count.getPopulation());

                String count_string =
                        String.format("| %-5s | %-50s | %-20s | %-30s | %-20s | %-35s |",
                                count.getCountry_code(), count.getCountry_name(), count.getContinent(), count.getRegion(), formattedPopulation, count.getCity_name());
                System.out.println(count_string);
            }
            // Print bottom border
            System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+---------------------+--");
        }

        catch (NullPointerException ne){
            System.out.println("The arraylist is empty");
        }
        catch (Exception e){
            System.out.println("Error occurred because " + e);
        }
    }
}