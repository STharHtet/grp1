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

    /**
     * The population of people, people living in cities, and people not living in cities in each continent.
     */
    @Test
    void testeachcontinent()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        population_lastfeatures_method eachcontinentmethod = new population_lastfeatures_method();
        population_in_lastfeatures_output eachcontinentoutput = new population_in_lastfeatures_output();
        ArrayList<populationppl> eachcontinenttest = eachcontinentmethod.eachcontinent(app.con);

        // Testing the output is equals to the first rows of living in cities and not living in cities data in each continent
        assertEquals("Asia", eachcontinenttest.get(0).getContinent_ppl(), "first row of the continent name is Asia");
        assertEquals(3705025700L, eachcontinenttest.get(0).getCountry_total_population(), "first row of total population of Asia is 3,705,025,700");
        assertEquals(697604103, eachcontinenttest.get(0).getCity_total_population(), "first row of total population living in city is 697,604,103");
        assertEquals("18.83%", eachcontinenttest.get(0).getLiving_in_cities(), "first row of total population living in cities in % is 18.83%");
        assertEquals(3007421597L , eachcontinenttest.get(0).getTotal_not_livingcites(), "first row of total population not living in cities is 3,007,421,597");
        assertEquals("81.17%", eachcontinenttest.get(0).getNot_living_in_cities(), "first row of the total population not living in cities % is 81.17%");

        // Testing the output is equals to the last rows of living in cities and not living in cities data in each continent
        assertEquals("South America", eachcontinenttest.get(eachcontinenttest.size()-1).getContinent_ppl(), "last row of the continent name is South America");
        assertEquals(345780000, eachcontinenttest.get(eachcontinenttest.size()-1).getCountry_total_population(), "last row of total population of South America is 345,780,000");
        assertEquals(172037859, eachcontinenttest.get(eachcontinenttest.size()-1).getCity_total_population(), "last row of total population living in city is 172,037,859");
        assertEquals("49.75%", eachcontinenttest.get(eachcontinenttest.size()-1).getLiving_in_cities(), "last row of total population living in cities in % is 49.75%");
        assertEquals(173742141 , eachcontinenttest.get(eachcontinenttest.size()-1).getTotal_not_livingcites(), "last row of total population not living in cities is 173,742,141");
        assertEquals("50.25%", eachcontinenttest.get(eachcontinenttest.size()-1).getNot_living_in_cities(), "last row of the total population not living in cities % is 50.25%");

        // Testing get works or not
        for (populationppl echcontinent : eachcontinenttest){
            assertNotNull(echcontinent.getContinent_ppl(), "getter of continent_name variables shouldn't be null value");
            assertTrue(echcontinent.getCountry_total_population() > -1 , "Population shouldn't be less than 0");
            assertTrue(echcontinent.getCity_total_population() > -1 , "Population shouldn't be less than 0");
            assertTrue(echcontinent.getTotal_not_livingcites() > -1 , "Population shouldn't be less than 0");
            assertNotNull(echcontinent.getLiving_in_cities(), "getter of Living in cities variables shouldn't be null value");
            assertNotNull(echcontinent.getNot_living_in_cities(), "getter of not living in cities variables shouldn't be null value");
        }
        assertNotNull(eachcontinenttest);
        System.out.println("The population of people, people living in cities, and people not living in cities in each continent.");
        eachcontinentoutput.printPopulationineachcontinent(eachcontinenttest);
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each region.
     */
    @Test
    void testeachregion()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        population_lastfeatures_method eachregionmethod = new population_lastfeatures_method();
        population_in_lastfeatures_output eachregionoutput = new population_in_lastfeatures_output();
        ArrayList<populationppl> eachregiontest = eachregionmethod.eachregion(app.con);

        // Testing the output is equals to the first rows of living in cities and not living in cities data in each region
        assertEquals("Southern and Central Asia", eachregiontest.get(0).getRegion_ppl(), "first row of the region name is Southern and Central Asia");
        assertEquals(1490776000, eachregiontest.get(0).getCountry_total_population(), "first row of total population of Southern and Central Asia is 1,490,776,000");
        assertEquals(207688970, eachregiontest.get(0).getCity_total_population(), "first row of total population living in city is 207,688,970");
        assertEquals("13.93%", eachregiontest.get(0).getLiving_in_cities(), "first row of total population living in cities in % is 13.93%");
        assertEquals(1283087030, eachregiontest.get(0).getTotal_not_livingcites(), "first row of total population not living in cities is 1,283,087,030");
        assertEquals("86.07%", eachregiontest.get(0).getNot_living_in_cities(), "first row of the total population not living in cities % is 81.17%");

        // Testing the output is equals to the last rows of living in cities and not living in cities data in each region
        assertEquals("Baltic Countries", eachregiontest.get(eachregiontest.size()-1).getRegion_ppl(), "last row of the region name is Baltic Countries");
        assertEquals(7561900, eachregiontest.get(eachregiontest.size()-1).getCountry_total_population(), "last row of total population of Baltic Countries is 7,561,900");
        assertEquals(2947140, eachregiontest.get(eachregiontest.size()-1).getCity_total_population(), "last row of total population living in city is 2,947,140");
        assertEquals("38.97%", eachregiontest.get(eachregiontest.size()-1).getLiving_in_cities(), "last row of total population living in cities in % is 38.97%");
        assertEquals(4614760, eachregiontest.get(eachregiontest.size()-1).getTotal_not_livingcites(), "last row of total population not living in cities is 4,614,760");
        assertEquals("61.03%", eachregiontest.get(eachregiontest.size()-1).getNot_living_in_cities(), "last row of the total population not living in cities % is 61.03%");

        // Testing get works or not
        for (populationppl echregion : eachregiontest){
            assertNotNull(echregion.getRegion_ppl(), "getter of region name variables shouldn't be null value");
            assertTrue(echregion.getCountry_total_population() > -1 , "Population shouldn't be less than 0");
            assertTrue(echregion.getCity_total_population() > -1 , "Population shouldn't be less than 0");
            assertTrue(echregion.getTotal_not_livingcites() > -1 , "Population shouldn't be less than 0");
            assertNotNull(echregion.getLiving_in_cities(), "getter of Living in cities variables shouldn't be null value");
            assertNotNull(echregion.getNot_living_in_cities(), "getter of not living in cities variables shouldn't be null value");
        }
        assertNotNull(eachregiontest);
        System.out.println("The population of people, people living in cities, and people not living in cities in each region.");
        eachregionoutput.printPopulationineachregion(eachregiontest);
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each country.
     */
    @Test
    void testeachcountry()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        population_lastfeatures_method eachcountrymethod = new population_lastfeatures_method();
        population_in_lastfeatures_output eachcountryoutput = new population_in_lastfeatures_output();
        ArrayList<populationppl> eachcountrytest = eachcountrymethod.eachcountry(app.con);

        // Testing the output is equals to the first rows of living in cities and not living in cities data in each country
        assertEquals("Afghanistan", eachcountrytest.get(0).getCountry_name(), "first row of the country name is Afghanistan");
        assertEquals(22720000, eachcountrytest.get(0).getCountry_total_population(), "first row of total population of Afghanistan is 22,720,000");
        assertEquals(2332100, eachcountrytest.get(0).getCity_total_population(), "first row of total population living in city is 2,332,100");
        assertEquals("10.26%", eachcountrytest.get(0).getLiving_in_cities(), "first row of total population living in cities in % is 10.26%");
        assertEquals(20387900, eachcountrytest.get(0).getTotal_not_livingcites(), "first row of total population not living in cities is 20,387,900");
        assertEquals("89.74%", eachcountrytest.get(0).getNot_living_in_cities(), "first row of the total population not living in cities % is 89.74%");

        // Testing the output is equals to the last rows of living in cities and not living in cities data in each country
        assertEquals("Palestine", eachcountrytest.get(eachcountrytest.size()-1).getCountry_name(), "last row of the country name is Palestine");
        assertEquals(3101000, eachcountrytest.get(eachcountrytest.size()-1).getCountry_total_population(), "last row of total population of Palestine is 3,101,000");
        assertEquals(902360, eachcountrytest.get(eachcountrytest.size()-1).getCity_total_population(), "last row of total population living in city is 902,360");
        assertEquals("29.10%", eachcountrytest.get(eachcountrytest.size()-1).getLiving_in_cities(), "last row of total population living in cities in % is 29.10%");
        assertEquals(2198640, eachcountrytest.get(eachcountrytest.size()-1).getTotal_not_livingcites(), "last row of total population not living in cities is 2,198,640");
        assertEquals("70.90%", eachcountrytest.get(eachcountrytest.size()-1).getNot_living_in_cities(), "last row of the total population not living in cities % is 70.90%");

        // Testing get works or not
        for (populationppl echcountry : eachcountrytest){
            assertNotNull(echcountry.getCountry_name(), "getter of region name variables shouldn't be null value");
            assertTrue(echcountry.getCountry_total_population() > -1 , "Population shouldn't be less than 0");
            assertTrue(echcountry.getCity_total_population() > -1 , "Population shouldn't be less than 0");
            assertNotNull(echcountry.getLiving_in_cities(), "getter of Living in cities variables shouldn't be null value");
            assertNotNull(echcountry.getNot_living_in_cities(), "getter of not living in cities variables shouldn't be null value");
        }
        assertNotNull(eachcountrytest);
        System.out.println("The population of people, people living in cities, and people not living in cities in each country.");
        eachcountryoutput.printPopulationineachcountry(eachcountrytest);
    }

    /**
     * The population of the world
     */
    @Test
    void testworldtotal()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        population_lastfeatures_method worldtotalmethod = new population_lastfeatures_method();
        population_in_lastfeatures_output worldtotaloutput = new population_in_lastfeatures_output();
        ArrayList<populationppl> worldtotaltest = worldtotalmethod.totalpopulationinworld(app.con);

        // Testing the population of the world.
        assertEquals(6078749450L, worldtotaltest.get(0).getWorld_total(), "test data of world total population is 6,078,749,450");
        assertTrue(worldtotaltest.get(0).getWorld_total() > -1 , "Population shouldn't be less than 0");

        assertNotNull(worldtotaltest);
        System.out.println("The population of the world.");
        worldtotaloutput.printPopulationinworld(worldtotaltest);
    }
    @Test
    void testinacontinenttotal()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        population_lastfeatures_method acontinenttotalmethod = new population_lastfeatures_method();
        population_in_lastfeatures_output acontinenttotaloutput = new population_in_lastfeatures_output();
        ArrayList<populationppl> inacontinenttotaltest = acontinenttotalmethod.totalpopulationinacontinent(app.con, "Asia");

        // Testing the population of a continent.
        assertEquals(3705025700L, inacontinenttotaltest.get(0).getPopulationinacontinent(), "test data of a continent (Asia) total population is 3,705,025,700");
        assertEquals("Asia", inacontinenttotaltest.get(0).getContinent_name(), "test data of a continent name is Asia");
        assertTrue(inacontinenttotaltest.get(0).getWorld_total() > -1 , "Population shouldn't be less than 0");

        assertNotNull(inacontinenttotaltest);
        System.out.println("The population of a continent.");
        acontinenttotaloutput.printPopulationinacontinent(inacontinenttotaltest);
    }

    /**
     * The population of a region
     */
    @Test
    void testinaregiontotal()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        population_lastfeatures_method aregiontotalmethod = new population_lastfeatures_method();
        population_in_lastfeatures_output aregiontotaloutput = new population_in_lastfeatures_output();
        ArrayList<populationppl> inaregiontotaltest = aregiontotalmethod.totalpopulationinaregion(app.con, "Eastern Asia");

        // Testing the population of a continent.
        assertEquals(1507328000, inaregiontotaltest.get(0).getPopulationinaregion(), "test data of a region (Eastern Asia) total population is 1,507,328,000");
        assertEquals("Eastern Asia", inaregiontotaltest.get(0).getRegion_name(), "test data of a region name is Asia");
        assertTrue(inaregiontotaltest.get(0).getPopulationinaregion() > -1 , "Population shouldn't be less than 0");

        assertNotNull(inaregiontotaltest);
        System.out.println("The population of a region.");
        aregiontotaloutput.printPopulationinaregion(inaregiontotaltest);
    }

    /**
     * The population of a country
     */
    @Test
    void testinacountrytotal()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        population_lastfeatures_method acountrytotalmethod = new population_lastfeatures_method();
        population_in_lastfeatures_output acountrytotaloutput = new population_in_lastfeatures_output();
        ArrayList<populationppl> inacountrytotaltest = acountrytotalmethod.totalpopulationinacountry(app.con, "China");

        // Testing the population of a country.
        assertEquals(1277558000, inacountrytotaltest.get(0).getPopulationinacountry(), "test data of a country (China) total population is 1,277,558,000");
        assertEquals("China", inacountrytotaltest.get(0).getCountry_name(), "test data of a country name is China");
        assertTrue(inacountrytotaltest.get(0).getPopulationinaregion() > -1 , "Population shouldn't be less than 0");

        assertNotNull(inacountrytotaltest);
        System.out.println("The population of a country.");
        acountrytotaloutput.printPopulationinacountry(inacountrytotaltest);
    }

    /**
     * The population of a district
     */
    @Test
    void testinadistricttotal()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        population_lastfeatures_method adistricttotalmethod = new population_lastfeatures_method();
        population_in_lastfeatures_output adistricttotaloutput = new population_in_lastfeatures_output();
        ArrayList<populationppl> inadistricttotaltest = adistricttotalmethod.totalpopulationinadistrict(app.con, "Maharashtra");

        // Testing the population of a country.
        assertEquals(23659433, inadistricttotaltest.get(0).getDistrict_total_population(), "test data of a district (Maharashtra) total population is 23,659,433");
        assertEquals("Maharashtra", inadistricttotaltest.get(0).getDistrict_name(), "test data of a district name is Maharashtra");
        assertTrue(inadistricttotaltest.get(0).getPopulationinaregion() > -1 , "Population shouldn't be less than 0");

        assertNotNull(inadistricttotaltest);
        System.out.println("The population of a district.");
        adistricttotaloutput.printPopulationinadistrict(inadistricttotaltest);
    }

    /**
     * The population of a city
     */
    @Test
    void testinacitytotal()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        population_lastfeatures_method acitytotalmethod = new population_lastfeatures_method();
        population_in_lastfeatures_output acitytotaloutput = new population_in_lastfeatures_output();
        ArrayList<populationppl> inacitytotaltest = acitytotalmethod.totalpopulationinacity(app.con, "Melbourne");

        // Testing the population of a country.
        assertEquals(2865329, inacitytotaltest.get(0).getInacity_total_population(), "test data of a city (Melbourne) total population is 2,865,329");
        assertEquals("Melbourne", inacitytotaltest.get(0).getCity_name(), "test data of a city name is Melbourne");
        assertTrue(inacitytotaltest.get(0).getPopulationinaregion() > -1 , "Population shouldn't be less than 0");

        assertNotNull(inacitytotaltest);
        System.out.println("The population of a city.");
        acitytotaloutput.printPopulationinacity(inacitytotaltest);
    }

    /**
     * All the countries in the world organised by largest population to smallest.
     */
    @Test
    void testGetLanguages()
    {
        assertNotNull(app.con, "connection shouldn't be null values"); //testing connection is not null value
        populationoflanguagesmethod populationlanguages = new populationoflanguagesmethod();
        populationwithlanguagesoutput languagesoutput = new populationwithlanguagesoutput();
        ArrayList<languages> languagesdata = populationlanguages.countrylanguages(app.con);

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("Chinese", languagesdata.get(0).getLanguages_data(), "first row of the language is Chinese");
        assertEquals(1191843539, languagesdata.get(0).getPopulation_with_languages(), "first row of population for the languages is 1,191,843,539");
        assertEquals("19.61%", languagesdata.get(0).getPercentage_population(), "first row of population for the languages in percentage is 19.61%");

        // Testing the output is equals to the first rows of cities data in the world sorted by population
        assertEquals("Arabic", languagesdata.get(languagesdata.size()-1).getLanguages_data(), "last row of the language is Arabic");
        assertEquals(233839238, languagesdata.get(languagesdata.size()-1).getPopulation_with_languages(), "last row of population for the languages is 233,839,238");
        assertEquals("3.85%", languagesdata.get(languagesdata.size()-1).getPercentage_population(), "last row of population for the languages in percentage is 3.85%");

        // Testing get works or not
        for (languages ldata : languagesdata){
            assertNotNull(ldata.getLanguages_data(), "getter of languages data variables shouldn't be null value");
            assertTrue(ldata.getPopulation_with_languages() > -1 , "Population shouldn't be less than 0");
            assertNotNull(ldata.getPercentage_population(), "getter of percentage population variables shouldn't be null value");
        }
        assertNotNull(languagesdata);
        System.out.println("Population of people who spoke these languages in percentage and organised by largest population to smallest.");
        languagesoutput.printPopulationoflanguages(languagesdata);
    }
}
