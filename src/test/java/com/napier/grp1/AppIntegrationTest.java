package com.napier.grp1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing all the method and output from the App
 */
public class AppIntegrationTest{

    static App app;

    @BeforeAll
    static void init() throws SQLException {
        app = new App();
        app.connect("localhost:33060", 30000);
    }
    /**
     * All the countries in the world organised by largest population to smallest.
     */
    @Test
    void testGetCountry()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CountryMethod countrymethod = new CountryMethod();
        CountryOutput countryout = new CountryOutput();
        ArrayList<Country> countries = countrymethod.getCountry(app.con);

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("CHN", countries.get(0).getCountry_code(), "first row of the country code in the world is CHN");
        assertEquals("China", countries.get(0).getCountry_name(), "first row of the country name is China");
        assertEquals("Asia", countries.get(0).getContinent(), "first row of the country Continent is Asia");
        assertEquals("Eastern Asia", countries.get(0).getRegion(), "first row of the country region is Eastern Asia");
        assertEquals(1277558000, countries.get(0).getPopulation(), "first row of the country population is 1,277,558,00");
        assertEquals("Peking", countries.get(0).getCity_name(), "first row of the country (city name) is Peking");

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("PCN", countries.get(countries.size()-1).getCountry_code(), "last row of the country code in the world is PCN");
        assertEquals("Pitcairn", countries.get(countries.size()-1).getCountry_name(), "last row of the country name is Pitcairn");
        assertEquals("Oceania", countries.get(countries.size()-1).getContinent(), "last row of the country Continent is Oceania");
        assertEquals("Polynesia", countries.get(countries.size()-1).getRegion(), "last row of the country region is Polynesia");
        assertEquals(50, countries.get(countries.size()-1).getPopulation(), "last row of the country population is 50");
        assertEquals("Adamstown", countries.get(countries.size()-1).getCity_name(), "last row of the country (city name) is Adamnstown");

        // Testing get works or not
        for (Country countlist : countries){
            assertNotNull(countlist.getCity_name(), "getter of city_name variables shouldn't be null value");
            assertTrue(countlist.getPopulation() > -1 , "Population shouldn't be less than 0");
            assertNotNull(countlist.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(countlist.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(countlist.getRegion(), "getter of region variables shouldn't be null value");
            assertNotNull(countlist.getContinent(), "getter of continent variable shouldn't be null value");
        }
        assertNotNull(countries);
        System.out.println("All the countries in the world organised by largest population to smallest.");
        countryout.printPopulation(countries);
    }
    /**
     * All the countries in a continent organised by largest population to smallest. (Asia)
     */
    @Test
    void testGetCountriesByContinent()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CountryMethod countrymethod = new CountryMethod();
        CountryOutput countryout = new CountryOutput();
        ArrayList<Country> countriesbycontinent = countrymethod.getCountriesByContinent(app.con, "Asia");

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("CHN", countriesbycontinent.get(0).getCountry_code(), "first row of the country code in the world is CHN");
        assertEquals("China", countriesbycontinent.get(0).getCountry_name(), "first row of the country name is China");
        assertEquals("Asia", countriesbycontinent.get(0).getContinent(), "first row of the country Continent is Asia");
        assertEquals("Eastern Asia", countriesbycontinent.get(0).getRegion(), "first row of the country region is Eastern Asia");
        assertEquals(1277558000, countriesbycontinent.get(0).getPopulation(), "first row of the country population is 1,277,558,00");
        assertEquals("Peking", countriesbycontinent.get(0).getCity_name(), "first row of the country (city name) is Peking");

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("MDV", countriesbycontinent.get(countriesbycontinent.size()-1).getCountry_code(), "last row of the country code in the world is PCN");
        assertEquals("Maldives", countriesbycontinent.get(countriesbycontinent.size()-1).getCountry_name(), "last row of the country name is Pitcairn");
        assertEquals("Asia", countriesbycontinent.get(countriesbycontinent.size()-1).getContinent(), "last row of the country Continent is Asia");
        assertEquals("Southern and Central Asia", countriesbycontinent.get(countriesbycontinent.size()-1).getRegion(), "last row of the country region is Southern and Central Asia");
        assertEquals(286000, countriesbycontinent.get(countriesbycontinent.size()-1).getPopulation(), "last row of the country population is 286,000");
        assertEquals("Male", countriesbycontinent.get(countriesbycontinent.size()-1).getCity_name(), "last row of the country (city name) is Male");

        // Testing get works or not
        for (Country countlist : countriesbycontinent){
            assertNotNull(countlist.getCity_name(), "getter of city_name variables shouldn't be null value");
            assertTrue(countlist.getPopulation() > -1 , "Population shouldn't be less than 0");
            assertNotNull(countlist.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(countlist.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(countlist.getRegion(), "getter of region variables shouldn't be null value");
            assertNotNull(countlist.getContinent(), "getter of continent variable shouldn't be null value");
        }
        assertNotNull(countriesbycontinent);
        System.out.println("All the countries in a continent organised by largest population to smallest. (Asia)");
        countryout.printPopulation(countriesbycontinent);
    }
    /**
     * All the countries in a region organised by largest population to smallest. (Caribbean)
     */
    @Test
    void testGetCountriesByRegion()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CountryMethod countrymethod = new CountryMethod();
        CountryOutput countryout = new CountryOutput();
        ArrayList<Country> countriesbyregion = countrymethod.region_data(app.con, "Caribbean");

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("CUB", countriesbyregion.get(0).getCountry_code(), "first row of the country code in the world is CUB");
        assertEquals("Cuba", countriesbyregion.get(0).getCountry_name(), "first row of the country name is Cuba");
        assertEquals("North America", countriesbyregion.get(0).getContinent(), "first row of the country Continent is North America");
        assertEquals("Caribbean", countriesbyregion.get(0).getRegion(), "first row of the country region is Caribbean");
        assertEquals(11201000, countriesbyregion.get(0).getPopulation(), "first row of the country population is 11,201,000");
        assertEquals("La Habana", countriesbyregion.get(0).getCity_name(), "first row of the country (city name) is La Habana");

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("AIA", countriesbyregion.get(countriesbyregion.size()-1).getCountry_code(), "last row of the country code in the world is AIA");
        assertEquals("Anguilla", countriesbyregion.get(countriesbyregion.size()-1).getCountry_name(), "last row of the country name is Anguilla");
        assertEquals("North America", countriesbyregion.get(countriesbyregion.size()-1).getContinent(), "last row of the country Continent is North America");
        assertEquals("Caribbean", countriesbyregion.get(countriesbyregion.size()-1).getRegion(), "last row of the country region is Caribbean");
        assertEquals(8000, countriesbyregion.get(countriesbyregion.size()-1).getPopulation(), "last row of the country population is 8,000");
        assertEquals("The Valley", countriesbyregion.get(countriesbyregion.size()-1).getCity_name(), "last row of the country (city name) is The Valley");

        // Testing get works or not
        for (Country countlist : countriesbyregion){
            assertNotNull(countlist.getCity_name(), "getter of city_name variables shouldn't be null value");
            assertTrue(countlist.getPopulation() > -1 , "Population shouldn't be less than 0");
            assertNotNull(countlist.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(countlist.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(countlist.getRegion(), "getter of region variables shouldn't be null value");
            assertNotNull(countlist.getContinent(), "getter of continent variable shouldn't be null value");
        }
        assertNotNull(countriesbyregion);
        System.out.println("All the countries in a region organised by largest population to smallest. (Caribbean)");
        countryout.printPopulation(countriesbyregion);
    }
    /**
     * The top 10 populated countries in the world.
     */
    @Test
    void testTenCountry()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CountryMethod countrymethod = new CountryMethod();
        CountryOutput countryout = new CountryOutput();
        ArrayList<Country> toptencountires = countrymethod.getTenCountry(app.con, 10);

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("CHN", toptencountires.get(0).getCountry_code(), "first row of the country code in the world in top ten countries is CHN");
        assertEquals("China", toptencountires.get(0).getCountry_name(), "first row of the country name is China");
        assertEquals("Asia", toptencountires.get(0).getContinent(), "first row of the country Continent is Asia");
        assertEquals("Eastern Asia", toptencountires.get(0).getRegion(), "first row of the country region is Eastern Asia");
        assertEquals(1277558000, toptencountires.get(0).getPopulation(), "first row of the country population is 1,277,558,000");
        assertEquals("Peking", toptencountires.get(0).getCity_name(), "first row of the country (city name) is Peking");

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("NGA", toptencountires.get(toptencountires.size()-1).getCountry_code(), "last row of the country code in the world in top ten countries is NGA");
        assertEquals("Nigeria", toptencountires.get(toptencountires.size()-1).getCountry_name(), "last row of the country name is Nigeria");
        assertEquals("Africa", toptencountires.get(toptencountires.size()-1).getContinent(), "last row of the country Continent is Africa");
        assertEquals("Western Africa", toptencountires.get(toptencountires.size()-1).getRegion(), "last row of the country region is Western Africa");
        assertEquals(111506000, toptencountires.get(toptencountires.size()-1).getPopulation(), "last row of the country population is 111,506,000");
        assertEquals("Abuja", toptencountires.get(toptencountires.size()-1).getCity_name(), "last row of the country (city name) is Abuja");

        // Testing get works or not
        for (Country countlist : toptencountires){
            assertNotNull(countlist.getCity_name(), "getter of city_name variables shouldn't be null value");
            assertTrue(countlist.getPopulation() > -1 , "Population shouldn't be less than 0");
            assertNotNull(countlist.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(countlist.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(countlist.getRegion(), "getter of region variables shouldn't be null value");
            assertNotNull(countlist.getContinent(), "getter of continent variable shouldn't be null value");
        }
        assertNotNull(toptencountires);
        System.out.println("The top 10 populated countries in the world.");
        countryout.printPopulation(toptencountires);
    }
    /**
     *  The top 10 populated countries in a continent. (Asia)
     */
    @Test
    void testTenCountriesByContinent()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CountryMethod countrymethod = new CountryMethod();
        CountryOutput countryout = new CountryOutput();
        ArrayList<Country> toptencountiresbycontinent = countrymethod.getTenCountriesByContinent(app.con, "Asia",10);

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("CHN", toptencountiresbycontinent.get(0).getCountry_code(), "first row of the country code in the world in top ten countries is CHN");
        assertEquals("China", toptencountiresbycontinent.get(0).getCountry_name(), "first row of the country name is China");
        assertEquals("Asia", toptencountiresbycontinent.get(0).getContinent(), "first row of the country Continent is Asia");
        assertEquals("Eastern Asia", toptencountiresbycontinent.get(0).getRegion(), "first row of the country region is Eastern Asia");
        assertEquals(1277558000, toptencountiresbycontinent.get(0).getPopulation(), "first row of the country population is 1,277,558,000");
        assertEquals("Peking", toptencountiresbycontinent.get(0).getCity_name(), "first row of the country (city name) is Peking");

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("TUR", toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getCountry_code(), "last row of the country code in the world in top ten countries is TUR");
        assertEquals("Turkey", toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getCountry_name(), "last row of the country name is Turkey");
        assertEquals("Asia", toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getContinent(), "last row of the country Continent is Asia");
        assertEquals("Middle East", toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getRegion(), "last row of the country region is Middle East");
        assertEquals(66591000, toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getPopulation(), "last row of the country population is 66,591,000");
        assertEquals("Ankara", toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getCity_name(), "last row of the country (city name) is Ankara");

        // Testing get works or not
        for (Country countlist : toptencountiresbycontinent){
            assertNotNull(countlist.getCity_name(), "getter of city_name variables shouldn't be null value");
            assertTrue(countlist.getPopulation() > -1 , "Population shouldn't be less than 0");
            assertNotNull(countlist.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(countlist.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(countlist.getRegion(), "getter of region variables shouldn't be null value");
            assertNotNull(countlist.getContinent(), "getter of continent variable shouldn't be null value");
        }
        assertNotNull(toptencountiresbycontinent);
        System.out.println("The top 10 populated countries in a continent. (Asia)");
        countryout.printPopulation(toptencountiresbycontinent);
    }
    /**
     *  The top 10 populated countries in a region. (Caribbean)
     */
    @Test
    void testTenCountriesByRegion()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CountryMethod countrymethod = new CountryMethod();
        CountryOutput countryout = new CountryOutput();
        ArrayList<Country> toptencountiresbycontinent = countrymethod.getTenCountriesByRegion(app.con, "Caribbean",10);

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("CUB", toptencountiresbycontinent.get(0).getCountry_code(), "first row of the country code in the region in top ten is CUB");
        assertEquals("Cuba", toptencountiresbycontinent.get(0).getCountry_name(), "first row of the country name is Cuba");
        assertEquals("North America", toptencountiresbycontinent.get(0).getContinent(), "first row of the country Continent is North America");
        assertEquals("Caribbean", toptencountiresbycontinent.get(0).getRegion(), "first row of the country region is Caribbean");
        assertEquals(11201000, toptencountiresbycontinent.get(0).getPopulation(), "first row of the country population is 11,201,000");
        assertEquals("La Habana", toptencountiresbycontinent.get(0).getCity_name(), "first row of the country (city name) is La Habana");

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("BRB", toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getCountry_code(), "last row of the country code in the world in top ten region is BRB");
        assertEquals("Barbados", toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getCountry_name(), "last row of the country name is Barbados");
        assertEquals("North America", toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getContinent(), "last row of the country Continent is North America");
        assertEquals("Caribbean", toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getRegion(), "last row of the country region is Caribbean");
        assertEquals(270000, toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getPopulation(), "last row of the country population is 270,000");
        assertEquals("Bridgetown", toptencountiresbycontinent.get(toptencountiresbycontinent.size()-1).getCity_name(), "last row of the country (city name) is Bridgetown");

        // Testing get works or not
        for (Country countlist : toptencountiresbycontinent){
            assertNotNull(countlist.getCity_name(), "getter of city_name variables shouldn't be null value");
            assertTrue(countlist.getPopulation() > -1 , "Population shouldn't be less than 0");
            assertNotNull(countlist.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(countlist.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(countlist.getRegion(), "getter of region variables shouldn't be null value");
            assertNotNull(countlist.getContinent(), "getter of continent variable shouldn't be null value");
        }
        assertNotNull(toptencountiresbycontinent);
        System.out.println("The top 10 populated countries in a region. (Caribbean)");
        countryout.printPopulation(toptencountiresbycontinent);
    }

    /**
     * All the cities in the world organised by largest population to smallest.
     */
    @Test
    void testGetCities()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CityMethod citmethod = new CityMethod();
        CityOutput citoutput = new CityOutput();
        ArrayList<City> capcities = citmethod.getCities(app.con);

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("Mumbai (Bombay)", capcities.get(0).getCity_name(), "first row of the city name is Mumbai");
        assertEquals("India", capcities.get(0).getCountry_name(), "first row of the city (country name) is India");
        assertEquals("IND", capcities.get(0).getCountry_code(), "first row of the cit (country code) is IND");
        assertEquals("Maharashtra", capcities.get(0).getCity_district(), "first row of the city (country district) is Maharashtra");
        assertEquals(10500000, capcities.get(0).getCity_population(), "first row of the city (population) is 10,500,000");

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("Adamstown", capcities.get(capcities.size()-1).getCity_name(), "last row of the city name is Adamstown");
        assertEquals("Pitcairn", capcities.get(capcities.size()-1).getCountry_name(), "last row of the city (country name) is Pitcairn ");
        assertEquals("PCN", capcities.get(capcities.size()-1).getCountry_code(), "last row of the cit (country code) is PCN");
        assertEquals("–", capcities.get(capcities.size()-1).getCity_district(), "last row of the city (country district) is –");
        assertEquals(42, capcities.get(capcities.size()-1).getCity_population(), "last row of the city (population) is 42");

        // Testing get works or not
        for (City cit : capcities){
            assertNotNull(cit.getCity_name(), "getter of City_name variables shouldn't be null value");
            assertTrue(cit.getCity_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(cit.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(cit.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(cit.getCity_district(), "getter of City_district variables shouldn't be null value");
        }
        assertNotNull(capcities);
        System.out.println("All the capital cities in the world organised by largest population to smallest.");
        citoutput.printPopulation(capcities);
    }
    /**
     * All the cities in a continent organised by largest population to smallest. (Asia)
     */
    @Test
    void testGetCitiesByContinent()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CityMethod citmethod = new CityMethod();
        CityOutput citoutput = new CityOutput();
        ArrayList<City> capcitiesbycontinent = citmethod.getCitiesByContinent(app.con, "Asia");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Mumbai (Bombay)", capcitiesbycontinent.get(0).getCity_name(), "first row of the city name by continent is Mumbai");
        assertEquals("India", capcitiesbycontinent.get(0).getCountry_name(), "first row of the city (country name) is India");
        assertEquals("IND", capcitiesbycontinent.get(0).getCountry_code(), "first row of the cit (country code) is IND");
        assertEquals("Maharashtra", capcitiesbycontinent.get(0).getCity_district(), "first row of the city (country district) is Maharashtra");
        assertEquals(10500000, capcitiesbycontinent.get(0).getCity_population(), "first row of the city (population) is 10,500,000");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Bandar Seri Begawan", capcitiesbycontinent.get(capcitiesbycontinent.size()-1).getCity_name(), "last row of the city name by continent is Bandar Seri Begawan");
        assertEquals("Brunei", capcitiesbycontinent.get(capcitiesbycontinent.size()-1).getCountry_name(), "last row of the city (country name) is Brunei ");
        assertEquals("BRN", capcitiesbycontinent.get(capcitiesbycontinent.size()-1).getCountry_code(), "last row of the cit (country code) is BRN");
        assertEquals("Brunei and Muara", capcitiesbycontinent.get(capcitiesbycontinent.size()-1).getCity_district(), "last row of the city (country district) is Brunei and Muara");
        assertEquals(21484, capcitiesbycontinent.get(capcitiesbycontinent.size()-1).getCity_population(), "last row of the city (population) is 21,484");

        // Testing get works or not
        for (City cit : capcitiesbycontinent){
            assertNotNull(cit.getCity_name(), "getter of City_name variables shouldn't be null value");
            assertTrue(cit.getCity_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(cit.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(cit.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(cit.getCity_district(), "getter of City_district variables shouldn't be null value");
        }
        assertNotNull(capcitiesbycontinent);
        System.out.println("All the capital cities in the a continent organised by largest population to smallest. (Asia)");
        citoutput.printPopulation(capcitiesbycontinent);
    }
    /**
     * All the cities in a region organised by largest population to smallest. (Caribbean)
     */
    @Test
    void testGetCitiesByRegion()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CityMethod citmethod = new CityMethod();
        CityOutput citoutput = new CityOutput();
        ArrayList<City> capcitiesbyregion = citmethod.getCitiesByRegion(app.con, "Caribbean");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("La Habana", capcitiesbyregion.get(0).getCity_name(), "first row of the city name by region is a Habana");
        assertEquals("Cuba", capcitiesbyregion.get(0).getCountry_name(), "first row of the city (country name) is Cuba");
        assertEquals("CUB", capcitiesbyregion.get(0).getCountry_code(), "first row of the cit (country code) is CUB");
        assertEquals("La Habana", capcitiesbyregion.get(0).getCity_district(), "first row of the city (country district) is La Habana");
        assertEquals(2256000, capcitiesbyregion.get(0).getCity_population(), "first row of the city (population) is 2,256,000");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("The Valley", capcitiesbyregion.get(capcitiesbyregion.size()-1).getCity_name(), "last row of the city name is The Valley");
        assertEquals("Anguilla", capcitiesbyregion.get(capcitiesbyregion.size()-1).getCountry_name(), "last row of the city (country name) is Anguilla ");
        assertEquals("AIA", capcitiesbyregion.get(capcitiesbyregion.size()-1).getCountry_code(), "last row of the cit (country code) is AIA");
        assertEquals("–", capcitiesbyregion.get(capcitiesbyregion.size()-1).getCity_district(), "last row of the city (country district) is –");
        assertEquals(595, capcitiesbyregion.get(capcitiesbyregion.size()-1).getCity_population(), "last row of the city (population) is 595");

        // Testing get works or not
        for (City cit : capcitiesbyregion){
            assertNotNull(cit.getCity_name(), "getter of City_name variables shouldn't be null value");
            assertTrue(cit.getCity_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(cit.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(cit.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(cit.getCity_district(), "getter of City_district variables shouldn't be null value");
        }
        assertNotNull(capcitiesbyregion);
        System.out.println("All the cities in a region organised by largest population to smallest. (Caribbean)");
        citoutput.printPopulation(capcitiesbyregion);
    }
    /**
     * All the cities in a country organised by largest population to smallest. (Myanmar)
     */
    @Test
    void testGetCitiesByCountry()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CityMethod citmethod = new CityMethod();
        CityOutput citoutput = new CityOutput();
        ArrayList<City> capcitiesbycountry = citmethod.getCitiesByCountry(app.con, "Myanmar");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Rangoon (Yangon)", capcitiesbycountry.get(0).getCity_name(), "first row of the city name by country is a Rangoon(Yangon)");
        assertEquals("Myanmar", capcitiesbycountry.get(0).getCountry_name(), "first row of the city (country name) is Myanmar");
        assertEquals("MMR", capcitiesbycountry.get(0).getCountry_code(), "first row of the cit (country code) is MMR");
        assertEquals("Rangoon [Yangon]", capcitiesbycountry.get(0).getCity_district(), "first row of the city (country district) is Rangoon");
        assertEquals(3361700, capcitiesbycountry .get(0).getCity_population(), "first row of the city (population) is 3,361,700");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Pagakku (Pakokku)", capcitiesbycountry.get(capcitiesbycountry.size()-1).getCity_name(), "last row of the city name by country is Pagakku");
        assertEquals("Myanmar", capcitiesbycountry.get(capcitiesbycountry.size()-1).getCountry_name(), "last row of the city (country name) is Myanmar");
        assertEquals("MMR", capcitiesbycountry.get(capcitiesbycountry.size()-1).getCountry_code(), "last row of the cit (country code) is MMR");
        assertEquals("Magwe [Magway]", capcitiesbycountry.get(capcitiesbycountry.size()-1).getCity_district(), "last row of the city (country district) is Magwe");
        assertEquals(94800, capcitiesbycountry.get(capcitiesbycountry.size()-1).getCity_population(), "last row of the city (population) is 94,800");

        // Testing get works or not
        for (City cit : capcitiesbycountry){
            assertNotNull(cit.getCity_name(), "getter of City_name variables shouldn't be null value");
            assertTrue(cit.getCity_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(cit.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(cit.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(cit.getCity_district(), "getter of City_district variables shouldn't be null value");
        }
        assertNotNull(capcitiesbycountry);
        System.out.println("All the cities in a country organised by largest population to smallest. (Myanmar)");
        citoutput.printPopulation(capcitiesbycountry);
    }
    /**
     * All the cities in a district organised by largest population to smallest. (Tokyo-to)
     */
    @Test
    void testGetCitiesByDistrict()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CityMethod citmethod = new CityMethod();
        CityOutput citoutput = new CityOutput();
        ArrayList<City> capcitiesbydistrict = citmethod.getCitiesByDistrict(app.con, "Tokyo-to");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Tokyo", capcitiesbydistrict.get(0).getCity_name(), "first row of the city name by district is a Tokyo");
        assertEquals("Japan", capcitiesbydistrict.get(0).getCountry_name(), "first row of the city (country name) is Japan");
        assertEquals("JPN", capcitiesbydistrict.get(0).getCountry_code(), "first row of the cit (country code) is JPN");
        assertEquals("Tokyo-to", capcitiesbydistrict.get(0).getCity_district(), "first row of the city (country district) is Tokyo-to");
        assertEquals(7980230, capcitiesbydistrict .get(0).getCity_population(), "first row of the city (population) is 7,980,230");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Hoya", capcitiesbydistrict.get(capcitiesbydistrict.size()-1).getCity_name(), "last row of the city name by district is Hoya");
        assertEquals("Japan", capcitiesbydistrict.get(capcitiesbydistrict.size()-1).getCountry_name(), "last row of the city (country name) is Japan");
        assertEquals("JPN", capcitiesbydistrict.get(capcitiesbydistrict.size()-1).getCountry_code(), "last row of the cit (country code) is JPN");
        assertEquals("Tokyo-to", capcitiesbydistrict.get(capcitiesbydistrict.size()-1).getCity_district(), "last row of the city (country district) is Tokyo-to");
        assertEquals(100313, capcitiesbydistrict.get(capcitiesbydistrict.size()-1).getCity_population(), "last row of the city (population) is 100,313");

        // Testing get works or not
        for (City cit : capcitiesbydistrict){
            assertNotNull(cit.getCity_name(), "getter of City_name variables shouldn't be null value");
            assertTrue(cit.getCity_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(cit.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(cit.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(cit.getCity_district(), "getter of City_district variables shouldn't be null value");
        }
        assertNotNull(capcitiesbydistrict);
        System.out.println("All the cities in a district organised by largest population to smallest. (Tokyo-to)");
        citoutput.printPopulation(capcitiesbydistrict);
    }
    /**
     * The top 10 populated cities in the world
     */
    @Test
    void testGetTopTenCity()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CityMethod citmethod = new CityMethod();
        CityOutput citoutput = new CityOutput();
        ArrayList<City> capcitiestopten = citmethod.getTopTenCities(app.con, 10);

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Mumbai (Bombay)", capcitiestopten.get(0).getCity_name(), "first row of the city name by top ten list in world is a Mumbai (Bombay)");
        assertEquals("India", capcitiestopten.get(0).getCountry_name(), "first row of the city (country name) is India");
        assertEquals("IND", capcitiestopten.get(0).getCountry_code(), "first row of the cit (country code) is IND");
        assertEquals("Maharashtra", capcitiestopten.get(0).getCity_district(), "first row of the city (country district) is Maharashtra");
        assertEquals(10500000, capcitiestopten.get(0).getCity_population(), "first row of the city (population) is 10,500,000");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("New York", capcitiestopten.get(capcitiestopten.size()-1).getCity_name(), "last row of the city name by top ten list in world is New York");
        assertEquals("United States", capcitiestopten.get(capcitiestopten.size()-1).getCountry_name(), "last row of the city (country name) is United States");
        assertEquals("USA", capcitiestopten.get(capcitiestopten.size()-1).getCountry_code(), "last row of the cit (country code) is USA");
        assertEquals("New York", capcitiestopten.get(capcitiestopten.size()-1).getCity_district(), "last row of the city (country district) is New York");
        assertEquals(8008278, capcitiestopten.get(capcitiestopten.size()-1).getCity_population(), "last row of the city (population) is 8,008,278");

        // Testing get works or not
        for (City cit : capcitiestopten){
            assertNotNull(cit.getCity_name(), "getter of City_name variables shouldn't be null value");
            assertTrue(cit.getCity_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(cit.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(cit.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(cit.getCity_district(), "getter of City_district variables shouldn't be null value");
        }
        assertNotNull(capcitiestopten);
        System.out.println("The top 10 populated cities in the world");
        citoutput.printPopulation(capcitiestopten);
    }
    /**
     * The top 10 populated cities in a continent. (Asia)
     */
    @Test
    void testGetTopTenCityByContinent()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CityMethod citmethod = new CityMethod();
        CityOutput citoutput = new CityOutput();
        ArrayList<City> capcitiestoptenbycontinent = citmethod.getTopTenCitiesByContinent(app.con, "Asia", 10);

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Mumbai (Bombay)", capcitiestoptenbycontinent.get(0).getCity_name(), "first row of the city name by top ten list in continent is a Mumbai (Bombay)");
        assertEquals("India", capcitiestoptenbycontinent.get(0).getCountry_name(), "first row of the city (country name) is India");
        assertEquals("IND", capcitiestoptenbycontinent.get(0).getCountry_code(), "first row of the cit (country code) is IND");
        assertEquals("Maharashtra", capcitiestoptenbycontinent.get(0).getCity_district(), "first row of the city (country district) is Maharashtra");
        assertEquals(10500000, capcitiestoptenbycontinent.get(0).getCity_population(), "first row of the city (population) is 10,500,000");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Teheran", capcitiestoptenbycontinent.get(capcitiestoptenbycontinent.size()-1).getCity_name(), "last row of the city name by top ten list in continent is Teheran");
        assertEquals("Iran", capcitiestoptenbycontinent.get(capcitiestoptenbycontinent.size()-1).getCountry_name(), "last row of the city (country name) is Iran");
        assertEquals("IRN", capcitiestoptenbycontinent.get(capcitiestoptenbycontinent.size()-1).getCountry_code(), "last row of the cit (country code) is IRN");
        assertEquals("Teheran", capcitiestoptenbycontinent.get(capcitiestoptenbycontinent.size()-1).getCity_district(), "last row of the city (country district) is Teheran");
        assertEquals(6758845, capcitiestoptenbycontinent.get(capcitiestoptenbycontinent.size()-1).getCity_population(), "last row of the city (population) is 6,658,845");

        // Testing get works or not
        for (City cit : capcitiestoptenbycontinent){
            assertNotNull(cit.getCity_name(), "getter of City_name variables shouldn't be null value");
            assertTrue(cit.getCity_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(cit.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(cit.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(cit.getCity_district(), "getter of City_district variables shouldn't be null value");
        }
        assertNotNull(capcitiestoptenbycontinent);
        System.out.println("The top 10 populated cities in a continent. (Asia)");
        citoutput.printPopulation(capcitiestoptenbycontinent);
    }
    /**
     * The top 10 populated cities in a region. (Caribbean)
     */
    @Test
    void testGetTopTenCityByRegion()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CityMethod citmethod = new CityMethod();
        CityOutput citoutput = new CityOutput();
        ArrayList<City> capcitiestoptenbyregion = citmethod.getTopTenCitiesByRegion(app.con, "Caribbean", 10);

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("La Habana", capcitiestoptenbyregion.get(0).getCity_name(), "first row of the city name by top ten list in region is La Habana");
        assertEquals("Cuba", capcitiestoptenbyregion.get(0).getCountry_name(), "first row of the city (country name) is Cuba");
        assertEquals("CUB", capcitiestoptenbyregion.get(0).getCountry_code(), "first row of the cit (country code) is CUB");
        assertEquals("La Habana", capcitiestoptenbyregion.get(0).getCity_district(), "first row of the city (country district) is La Habana");
        assertEquals(2256000, capcitiestoptenbyregion.get(0).getCity_population(), "first row of the city (population) is 2,256,000");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Delmas", capcitiestoptenbyregion.get(capcitiestoptenbyregion.size()-1).getCity_name(), "last row of the city name by top ten list in region is Delmas");
        assertEquals("Haiti", capcitiestoptenbyregion.get(capcitiestoptenbyregion.size()-1).getCountry_name(), "last row of the city (country name) is Haiti");
        assertEquals("HTI", capcitiestoptenbyregion.get(capcitiestoptenbyregion.size()-1).getCountry_code(), "last row of the cit (country code) is HTI");
        assertEquals("Ouest", capcitiestoptenbyregion.get(capcitiestoptenbyregion.size()-1).getCity_district(), "last row of the city (country district) is Ouest");
        assertEquals(240429, capcitiestoptenbyregion.get(capcitiestoptenbyregion.size()-1).getCity_population(), "last row of the city (population) is 240,429");

        // Testing get works or not
        for (City cit : capcitiestoptenbyregion){
            assertNotNull(cit.getCity_name(), "getter of City_name variables shouldn't be null value");
            assertTrue(cit.getCity_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(cit.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(cit.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(cit.getCity_district(), "getter of City_district variables shouldn't be null value");
        }
        assertNotNull(capcitiestoptenbyregion);
        System.out.println("The top 10 populated cities in a region. (Caribbean)");
        citoutput.printPopulation(capcitiestoptenbyregion);
    }
    /**
     * The top 10 populated cities in a country. (Myanmar)
     */
    @Test
    void testGetTopTenCityByCountry()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CityMethod citmethod = new CityMethod();
        CityOutput citoutput = new CityOutput();
        ArrayList<City> capcitiestoptenbycountry = citmethod.getTopTenCitiesByCountry(app.con, "Myanmar", 10);

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Rangoon (Yangon)", capcitiestoptenbycountry.get(0).getCity_name(), "first row of the city name by top ten list in region is Rangoon (Yangon)");
        assertEquals("Myanmar", capcitiestoptenbycountry.get(0).getCountry_name(), "first row of the city (country name) is Myanmar");
        assertEquals("MMR", capcitiestoptenbycountry.get(0).getCountry_code(), "first row of the cit (country code) is MMR");
        assertEquals("Rangoon [Yangon]", capcitiestoptenbycountry.get(0).getCity_district(), "first row of the city (country district) is Rangoon [Yangon]");
        assertEquals(3361700, capcitiestoptenbycountry.get(0).getCity_population(), "first row of the city (population) is 3,361,700");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Mergui (Myeik)", capcitiestoptenbycountry.get(capcitiestoptenbycountry.size()-1).getCity_name(), "last row of the city name by top ten list in region is Mergui (Myeik)");
        assertEquals("Myanmar", capcitiestoptenbycountry.get(capcitiestoptenbycountry.size()-1).getCountry_name(), "last row of the city (country name) is Myanmar");
        assertEquals("MMR", capcitiestoptenbycountry.get(capcitiestoptenbycountry.size()-1).getCountry_code(), "last row of the cit (country code) is MMR");
        assertEquals("Tenasserim [Tanintha", capcitiestoptenbycountry.get(capcitiestoptenbycountry.size()-1).getCity_district(), "last row of the city (country district) is Tenasserim [Tanintha]");
        assertEquals(122700, capcitiestoptenbycountry.get(capcitiestoptenbycountry.size()-1).getCity_population(), "last row of the city (population) is 122,700");

        // Testing get works or not
        for (City cit : capcitiestoptenbycountry){
            assertNotNull(cit.getCity_name(), "getter of City_name variables shouldn't be null value");
            assertTrue(cit.getCity_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(cit.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(cit.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(cit.getCity_district(), "getter of City_district variables shouldn't be null value");
        }
        assertNotNull(capcitiestoptenbycountry);
        System.out.println("The top 10 populated cities in a country. (Myanmar)");
        citoutput.printPopulation(capcitiestoptenbycountry);
    }
    /**
     * The top 10 populated cities in a district . (Tokyo-to)
     */
    @Test
    void testGetTopTenCityByDistrict()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CityMethod citmethod = new CityMethod();
        CityOutput citoutput = new CityOutput();
        ArrayList<City> capcitiestoptenbycountry = citmethod.getTopTenCitiesByDistrict(app.con, "Tokyo-to", 10);

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Tokyo", capcitiestoptenbycountry.get(0).getCity_name(), "first row of the city name by top ten list in district is Tokyo");
        assertEquals("Japan", capcitiestoptenbycountry.get(0).getCountry_name(), "first row of the city (country name) is Japan");
        assertEquals("JPN", capcitiestoptenbycountry.get(0).getCountry_code(), "first row of the cit (country code) is JPN");
        assertEquals("Tokyo-to", capcitiestoptenbycountry.get(0).getCity_district(), "first row of the city (country district) is Tokyo-to");
        assertEquals(7980230, capcitiestoptenbycountry.get(0).getCity_population(), "first row of the city (population) is 7,980,230");

        // Testing the output is equals to the first rows of cities data in the continent sorted by population
        assertEquals("Hitachinaka", capcitiestoptenbycountry.get(capcitiestoptenbycountry.size()-1).getCity_name(), "last row of the city name by top ten list in district is Hitahnaka");
        assertEquals("Japan", capcitiestoptenbycountry.get(capcitiestoptenbycountry.size()-1).getCountry_name(), "last row of the city (country name) is Japan");
        assertEquals("JPN", capcitiestoptenbycountry.get(capcitiestoptenbycountry.size()-1).getCountry_code(), "last row of the cit (country code) is JPN");
        assertEquals("Tokyo-to", capcitiestoptenbycountry.get(capcitiestoptenbycountry.size()-1).getCity_district(), "last row of the city (country district) is Tokyo-to");
        assertEquals(148006, capcitiestoptenbycountry.get(capcitiestoptenbycountry.size()-1).getCity_population(), "last row of the city (population) is 148,006");

        // Testing get works or not
        for (City cit : capcitiestoptenbycountry){
            assertNotNull(cit.getCity_name(), "getter of City_name variables shouldn't be null value");
            assertTrue(cit.getCity_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(cit.getCountry_name(), "getter of Country_name variables shouldn't be null value");
            assertNotNull(cit.getCountry_code(), "getter of Country_code variables shouldn't be null value");
            assertNotNull(cit.getCity_district(), "getter of City_district variables shouldn't be null value");
        }
        assertNotNull(capcitiestoptenbycountry);
        System.out.println("The top 10 populated cities in a country. (Myanmar)");
        citoutput.printPopulation(capcitiestoptenbycountry);
    }
    /**
     * Tested Capital Cities
     */
    @Test
    void testGetCapCities()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CapCityMethod capmethod = new CapCityMethod(); // called CapCityMethod class
        CapCityOutput capout = new CapCityOutput(); // called CapCityOutput class
        ArrayList<CapCity> capcity = capmethod.getCapCities(app.con); // taking arraylist from the getCapCities(); method

        // Testing the output is equals to the first rows of cities by continent sorted with population largest to smallest
        assertEquals("Seoul", capcity.get(0).getCap_city_name(), "first row of the city name Seoul");
        assertEquals("South Korea", capcity.get(0).getCap_city_country(), "first row of the country South Korea");
        assertEquals(9981619, capcity.get(0).getCap_city_population(),  "first row of the city population 9,981,619");

        // Testing the last output is equals to the last rows
        assertEquals("Adamstown", capcity.get(capcity.size()-1).getCap_city_name(), "last row of city name Adamstown");
        assertEquals("Pitcairn", capcity.get(capcity.size()-1).getCap_city_country(), "last row of city name Pitcairn");
        assertEquals(42, capcity.get(capcity.size()-1).getCap_city_population(), "last row of the city population 42");

        // Testing get works or not
        for (CapCity cap : capcity){
            assertNotNull(cap.getCap_city_name(), "getter of cap_city_name variables shouldn't be null value");
            assertTrue(cap.getCap_city_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(cap.getCap_city_country(), "getter of cap_city_country variables shouldn't be null value");
        }
        assertNotNull(capcity);
        System.out.println("All the capital cities in the world organised by largest population to smallest.");
        capout.printPopulation(capcity);
    }

    /**
     * Tested Capital Cities by Continent
     */
    @Test
    void testGetCapCitiesByContinent()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CapCityMethod capmethod = new CapCityMethod();
        CapCityOutput capoutput = new CapCityOutput();
        ArrayList<CapCity> capcitiescontient = capmethod.getCapCitiesByContinent(app.con, "Asia");

        //Testing the first output is equals to the first rows of cities by continent sorted with population largest to smallest
        assertEquals("Seoul", capcitiescontient.get(0).getCap_city_name(), "first row of the cities by population Korea");
        assertEquals("South Korea", capcitiescontient.get(0).getCap_city_country(), "first row of the country South Korea");
        assertEquals(9981619, capcitiescontient.get(0).getCap_city_population(), "first row of the city population 9,981,619");

        // Testing the last output is equals to the last rows of the cities by continent sorted with population largest to smallest
        assertEquals("Bandar Seri Begawan", capcitiescontient.get(capcitiescontient.size()-1).getCap_city_name(), "last row of city name Bandar Seri Begawan");
        assertEquals("Brunei", capcitiescontient.get(capcitiescontient.size()-1).getCap_city_country(), "last row of city name Brunei");
        assertEquals(21484, capcitiescontient.get(capcitiescontient.size()-1).getCap_city_population(), "last row of the city population 21,484");

        // Testing getter does collect the data inside them
        for(CapCity cap: capcitiescontient) {
            assertNotNull(cap.getCap_city_name(), "getter of cap_city_name by continent variables shouldn't be null value");
            assertTrue(cap.getCap_city_population() > -1, "population shouldn't be less than 0");
            assertNotNull(cap.getCap_city_country(), "cap_city_country by continent shouldn't be null value");
        }
        assertNotNull(capcitiescontient);
        System.out.println("All the capital cities in a continent organised by largest population to smallest. (Asia)");
        capoutput.printPopulation(capcitiescontient);
    }

    /**
     * Tested Capital Cities by region which is organised by population largest to smallest
     */
    @Test
    void testGetCapCitiesByRegion()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CapCityMethod capmethod = new CapCityMethod();
        CapCityOutput capoutput = new CapCityOutput();
        ArrayList<CapCity> capcitiesregion = capmethod.getCapCitiesByRegion(app.con, "Caribbean");

        assertEquals("La Habana", capcitiesregion.get(0).getCap_city_name(), "first row of the region by population La Habana");
        assertEquals("Cuba", capcitiesregion.get(0).getCap_city_country(), "first row of the region by population Cuba");
        assertEquals(2256000, capcitiesregion.get(0).getCap_city_population(), "first row of the region population 2,256,000");

        // Testing the last output is equals to the last rows of the cities by continent sorted with population largest to smallest
        assertEquals("The Valley", capcitiesregion.get(capcitiesregion.size()-1).getCap_city_name(), "last row of city name Bandar Seri Begawan");
        assertEquals("Anguilla", capcitiesregion.get(capcitiesregion.size()-1).getCap_city_country(), "last row of city name Brunei");
        assertEquals(595, capcitiesregion.get(capcitiesregion.size()-1).getCap_city_population(), "last row of the city population 21,484");

        // Testing getter does collect the data inside them
        for(CapCity cap: capcitiesregion) {
            assertNotNull(cap.getCap_city_name(), "getter of cap_city_name by continent variables shouldn't be null value");
            assertTrue(cap.getCap_city_population() > -1, "population shouldn't be less than 0");
            assertNotNull(cap.getCap_city_country(), "cap_city_country by continent shouldn't be null value");
        }
        assertNotNull(capcitiesregion);
        System.out.println("All the capital cities in a region organised by largest population to smallest. (Caribbean)");
        capoutput.printPopulation(capcitiesregion);
    }

    /**
     * Tested top ten cities organised by population largest to smallest
     */
    @Test
    void testGetTopTenCities()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CapCityMethod capmethod = new CapCityMethod();
        CapCityOutput capoutput = new CapCityOutput();
        ArrayList<CapCity> capcitiestopten = capmethod.getTopTenCapCities(app.con, 10);

        //Testing the first output is equals to the first rows of cities by continent sorted with population largest to smallest
        assertEquals("Seoul", capcitiestopten.get(0).getCap_city_name(), "first row of the cities(top ten) by population Korea");
        assertEquals("South Korea", capcitiestopten.get(0).getCap_city_country(), "first row of the cities(top ten) by population South Korea");
        assertEquals(9981619, capcitiestopten.get(0).getCap_city_population(), "first row of the cities(top ten) by population 9,981,619");

        // Testing the last output is equals to the last rows of the cities by continent sorted with population largest to smallest
        assertEquals("Lima", capcitiestopten.get(capcitiestopten.size()-1).getCap_city_name(), "last row of city name Lima");
        assertEquals("Peru", capcitiestopten.get(capcitiestopten.size()-1).getCap_city_country(), "last row of city name Peru");
        assertEquals(6464693, capcitiestopten.get(capcitiestopten.size()-1).getCap_city_population(), "last row of the city population 6,464,693");

        // Testing getter does collect the data inside them
        for(CapCity cap: capcitiestopten) {
            assertNotNull(cap.getCap_city_name(), "getter of cap_city_name in topten variables shouldn't be null value");
            assertTrue(cap.getCap_city_population() > -1, "population shouldn't be less than 0");
            assertNotNull(cap.getCap_city_country(), "cap_city_country in topten cities shouldn't be null value");
        }
        assertNotNull(capcitiestopten);
        System.out.println("The top 10 populated capital cities in the world.");
        capoutput.printPopulation(capcitiestopten);

    }

    /**
     * Tested get top ten cities by continent which is organised with population largest to smallest
     */
    @Test
    void testGetTopTenCitiesByContinent()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CapCityMethod capmethod = new CapCityMethod();
        CapCityOutput capoutput = new CapCityOutput();
        ArrayList<CapCity> capcitiestencontinent = capmethod.getTopTenCapCitiesByContinent(app.con, "Asia", 10);

        //Testing the first output is equals to the first rows of cities by continent sorted with population largest to smallest
        assertEquals("Seoul", capcitiestencontinent.get(0).getCap_city_name(), "first row of the cities(top ten with continent) sorted by population Seoul");
        assertEquals("South Korea", capcitiestencontinent.get(0).getCap_city_country(), "first row of the cities(top ten continent) sorted by population South Korea");
        assertEquals(9981619, capcitiestencontinent.get(0).getCap_city_population(), "first row of the cities(top ten continent) sorted by population 9,981,619");

        // Testing the last output is equals to the last rows of the cities by continent sorted with population largest to smallest
        assertEquals("Rangoon (Yangon)", capcitiestencontinent.get(capcitiestencontinent.size()-1).getCap_city_name(), "last row of city name Rangoon (Yangon)");
        assertEquals("Myanmar", capcitiestencontinent.get(capcitiestencontinent.size()-1).getCap_city_country(), "last row of city (continent) name Myanmar");
        assertEquals(3361700, capcitiestencontinent.get(capcitiestencontinent.size()-1).getCap_city_population(), "last row of the city (continent) population 3,361,700");

        // Testing getter does collect the data inside them
        for(CapCity cap: capcitiestencontinent) {
            assertNotNull(cap.getCap_city_name(), "getter of cap_city_name by continent variables shouldn't be null value");
            assertTrue(cap.getCap_city_population() > -1, "population shouldn't be less than 0");
            assertNotNull(cap.getCap_city_country(), "cap_city_country by continent shouldn't be null value");
        }
        assertNotNull(capcitiestencontinent);
        System.out.println("The top 10 populated capital cities in a continent. (Asia)");
        capoutput.printPopulation(capcitiestencontinent);
    }

    /**
     * Tested get top ten cities by region which is organised with population largest to smallest
     */
    @Test
    void testGetTopTenCitiesByRegion()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        CapCityMethod capmethod = new CapCityMethod();
        CapCityOutput capoutput = new CapCityOutput();
        ArrayList<CapCity> capcitiestenregion = capmethod.getTopTenCapCitiesByRegion(app.con, "Caribbean", 10);

        //Testing the first output is equals to the first rows of cities by continent sorted with population largest to smallest
        assertEquals("La Habana", capcitiestenregion.get(0).getCap_city_name(), "first row of the cities(top ten with region) sorted by population La Habana");
        assertEquals("Cuba", capcitiestenregion.get(0).getCap_city_country(), "first row of the cities(top ten region) sorted by population Cuba");
        assertEquals(2256000, capcitiestenregion.get(0).getCap_city_population(), "first row of the cities(top ten region) sorted by population 2,256,000");

        // Testing the last output is equals to the last rows of the cities by continent sorted with population largest to smallest
        assertEquals("Saint John´s", capcitiestenregion.get(capcitiestenregion.size()-1).getCap_city_name(), "last row of city (region) name Lima organised by population");
        assertEquals("Antigua and Barbuda", capcitiestenregion.get(capcitiestenregion.size()-1).getCap_city_country(), "last row of city (region) name Peru organised by population");
        assertEquals(24000, capcitiestenregion.get(capcitiestenregion.size()-1).getCap_city_population(), "last row of the city (region) organised by population 24,000");

        // Testing getter does collect the data inside them
        for(CapCity cap: capcitiestenregion) {
            assertNotNull(cap.getCap_city_name(), "getter of cap_city_name by continent variables shouldn't be null value");
            assertTrue(cap.getCap_city_population() > -1, "population shouldn't be less than 0");
            assertNotNull(cap.getCap_city_country(), "cap_city_country by continent shouldn't be null value");
        }
        assertNotNull(capcitiestenregion);
        System.out.println("The top 10 populated capital cities in a Region. (Caribbean)");
        capoutput.printPopulation(capcitiestenregion);
    }

}
