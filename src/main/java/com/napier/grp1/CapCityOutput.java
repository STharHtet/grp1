package com.napier.grp1;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The following class is to store the method for printing out data
 * relating to capital cities
 */
public class CapCityOutput {

    /**
     * The following method is to display data from methods used for capital
     * cities. There are 3 columns which are city name, country name and city
     * population that will be displayed.
     * @param dataoutput is take input for which capital city method data
     * to be displayed.
     */
    public void printPopulation(ArrayList<CapCity> dataoutput)
    {

        try {
            if (dataoutput == null) {
                System.out.println("The list is null");
            } else if (dataoutput.isEmpty()) {
                System.out.println("There is no capital cities");
            } else {

                // Print top border
                System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+------------------+");

                // Print header
                // Put Continent (30) or Region (30) below for display
                System.out.println(String.format("| %-50s | %-50s | %-20s |", "Name", "Country", "Population"));
                // Print header-bottom border
                System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+------------------+");

                // Loop over all capital cities in the list
                for (CapCity cap : dataoutput) {

                    if (cap == null) {
                        System.out.println("Capital city is null");
                    } else {
                        // Format population with commas and three decimal places
                        DecimalFormat numformat = new DecimalFormat("#,###,###");
                        String formattedPopulation = numformat.format(cap.getCap_city_population());

                        // Put cap.getCap_city_continent() to display Continent data
                        // Put cap.getCap_city_region() to display Region data
                        String count_string =
                                String.format("| %-50s | %-50s | %-20s |",
                                        cap.getCap_city_name(), cap.getCap_city_country(), formattedPopulation);
                        System.out.println(count_string);
                    }
                }
                // Print bottom border
                System.out.println("+---------------------+---------------------+---------------------+---------------------+---------------------+------------------+");
            }
        }

        catch (NullPointerException ne){
            System.out.println("The arraylist is empty");
        }
        catch (Exception e){
            System.out.println("Error occurred because " + e);
        }
    }
}
