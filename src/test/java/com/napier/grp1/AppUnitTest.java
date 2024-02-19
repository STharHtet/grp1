package com.napier.grp1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.*;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class AppUnitTest {
    private static App app;
    private static CountryOutput countryout;
    private static CityOutput cityout;
    private static CapCityOutput capitalout;


    @BeforeAll
    static void init() {
        app = new App();
        countryout = new CountryOutput();

        cityout = new CityOutput();

        capitalout = new CapCityOutput();
    }

    @Test
    void countryListNullTest(){
        ArrayList<Country> countrylist = null;
        countryout.printPopulation(countrylist);
    }

    @Test
    void noCountryTest(){
        ArrayList<Country> countrylist = new ArrayList<Country>();
        countryout.printPopulation(countrylist);
    }

    @Test
    void nullCountryTest(){
        ArrayList<Country> countrylist = new ArrayList<Country>();
        Country cou = new Country();
        cou.setCountry_code("ANT");
        cou.setCountry_name("Netherlands Antilles");
        cou.setContinent("North America");
        cou.setRegion("Caribbean");
        cou.setPopulation(217000);
        cou.setCity_name("Willemstad");

        Country cou1 = null;

        Country cou2 = new Country();
        cou2.setCountry_code("MMR");
        cou2.setCountry_name("Myanmar");
        cou2.setContinent("Asia");
        cou2.setRegion("Southeast Asia");
        cou2.setPopulation(337000);
        cou2.setCity_name("Yangon");

        countrylist.add(cou);
        countrylist.add(cou1);
        countrylist.add(cou2);
        countryout.printPopulation(countrylist);
    }
    @Test
    void countryListInput(){
        ArrayList<Country> countrylist = new ArrayList<Country>();
        Country cou = new Country();
        cou.setCountry_code("ANT");
        cou.setCountry_name("Netherlands Antilles");
        cou.setContinent("North America");
        cou.setRegion("Caribbean");
        cou.setPopulation(217000);
        cou.setCity_name("Willemstad");
        countrylist.add(cou);
        countryout.printPopulation(countrylist);
    }

    @Test
    void cityListNullTest(){
        ArrayList<City> citylist = null;
        cityout.printPopulation(citylist);
    }

    @Test
    void noCityTest(){
        ArrayList<City> citylist = new ArrayList<City>();
        cityout.printPopulation(citylist);
    }

    @Test
    void nullCityTest(){
        ArrayList<City> citylist = new ArrayList<City>();
        City cit = new City();
        cit.setCity_name("Yangon");
        cit.setCountry_code("MMR");
        cit.setCountry_name("Myanmar");
        cit.setCity_continent("Asia");
        cit.setCity_district("Yangon");
        cit.setCity_population(123500);
        citylist.add(cit);

        City cit1 = null;
        citylist.add(cit1);

        City cit2 = new City();
        cit2.setCity_name("Tokyo");
        cit2.setCountry_code("JPN");
        cit2.setCountry_name("Japan");
        cit2.setCity_continent("Asia");
        cit2.setCity_district("Tokyo");
        cit2.setCity_population(23700);
        citylist.add(cit2);

        cityout.printPopulation(citylist);
    }

    @Test
    void citListInput(){
        ArrayList<City> citylist = new ArrayList<City>();
        City cit = new City();
        cit.setCity_name("Yangon");
        cit.setCountry_code("MMR");
        cit.setCountry_name("Myanmar");
        cit.setCity_continent("Asia");
        cit.setCity_region("Southeast Asia");
        cit.setCity_district("Yangon");
        cit.setCity_population(123500);
        citylist.add(cit);
        cityout.printPopulation(citylist);
    }

    @Test
    void capitalListNullTest(){
        ArrayList<CapCity> capitallist = null;
        capitalout.printPopulation(capitallist);
    }

    @Test
    void noCapitalTest(){
        ArrayList<CapCity> capitallist = new ArrayList<CapCity>();
        capitalout.printPopulation(capitallist);
    }

    @Test
    void nullCapitalTest(){
        ArrayList<CapCity> capitallist = new ArrayList<CapCity>();
        CapCity cap = new CapCity();
        cap.setCap_city_name("Yangon");
        cap.setCap_city_country("Myanmar");
        cap.setCap_city_population(125000);

        CapCity cap1 = null;
        capitallist.add(cap1);

        CapCity cap2 = new CapCity();
        cap2.setCap_city_name("Tokyo");
        cap2.setCap_city_country("Japan");
        cap2.setCap_city_population(255000);

        capitalout.printPopulation(capitallist);
    }

    @Test
    void capitalListInput(){
        ArrayList<CapCity> capitallist = new ArrayList<CapCity>();
        CapCity cap = new CapCity();
        cap.setCap_city_name("Yangon");
        cap.setCap_city_country("Myanmar");
        cap.setCap_city_population(125000);
        capitallist.add(cap);
        capitalout.printPopulation(capitallist);
    }


    @Test
    public void testGetCountry() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("country.Code"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("TestContinent");
        when(mockResultSet.getString(eq("country.Region"))).thenReturn("TestRegion");
        when(mockResultSet.getInt(eq("country.Population"))).thenReturn(1000000);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");

        // Create an instance of the CountryMethod class
        CountryMethod countryMethod = new CountryMethod();

        // Call the method with the mocked connection
        ArrayList<Country> countries = countryMethod.getCountry(mockConnection);

        // Verify the results
        assertEquals(1, countries.size());

        Country country = countries.get(0);
        assertEquals("ABC", country.getCountry_code());
        assertEquals("TestCountry", country.getCountry_name());
        assertEquals("TestContinent", country.getContinent());
        assertEquals("TestRegion", country.getRegion());
        assertEquals(1000000, country.getPopulation());
        assertEquals("TestCity", country.getCity_name());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetCountriesByContinent() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("country.Code"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("TestContinent");
        when(mockResultSet.getString(eq("country.Region"))).thenReturn("TestRegion");
        when(mockResultSet.getInt(eq("country.Population"))).thenReturn(1000000);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");

        // Create an instance of the CountryMethod class
        CountryMethod countryMethod = new CountryMethod();

        // Call the method with the mocked connection
        ArrayList<Country> countries = countryMethod.getCountriesByContinent(mockConnection, "TestContinent");

        // Verify the results
        assertEquals(1, countries.size());

        Country country = countries.get(0);
        assertEquals("ABC", country.getCountry_code());
        assertEquals("TestCountry", country.getCountry_name());
        assertEquals("TestContinent", country.getContinent());
        assertEquals("TestRegion", country.getRegion());
        assertEquals(1000000, country.getPopulation());
        assertEquals("TestCity", country.getCity_name());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockStatement, times(1)).setString(eq(1), eq("TestContinent"));
        verify(mockStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testRegionData() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("country.Code"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("TestContinent");
        when(mockResultSet.getString(eq("country.Region"))).thenReturn("TestRegion");
        when(mockResultSet.getInt(eq("country.Population"))).thenReturn(1000000);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");

        // Create an instance of the CountryMethod class
        CountryMethod countryMethod = new CountryMethod();

        // Call the method with the mocked connection
        ArrayList<Country> countries = countryMethod.region_data(mockConnection, "TestRegion");

        // Verify the results
        assertEquals(1, countries.size());

        Country country = countries.get(0);
        assertEquals("ABC", country.getCountry_code());
        assertEquals("TestCountry", country.getCountry_name());
        assertEquals("TestContinent", country.getContinent());
        assertEquals("TestRegion", country.getRegion());
        assertEquals(1000000, country.getPopulation());
        assertEquals("TestCity", country.getCity_name());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockStatement, times(1)).setString(eq(1), eq("TestRegion"));
        verify(mockStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetTenCountry() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("country.Code"))).thenReturn("US");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("United States");
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("North America");
        when(mockResultSet.getString(eq("country.Region"))).thenReturn("North America");
        when(mockResultSet.getInt(eq("country.Population"))).thenReturn(331000000);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("Washington, D.C.");

        // Create an instance of the CountryMethod class
        CountryMethod countryMethod = new CountryMethod();

        // Call the method with the mocked connection
        ArrayList<Country> countries = countryMethod.getTenCountry(mockConnection, 10);

        // Verify the results
        assertEquals(1, countries.size());

        Country country = countries.get(0);
        assertEquals("US", country.getCountry_code());
        assertEquals("United States", country.getCountry_name());
        assertEquals("North America", country.getContinent());
        assertEquals("North America", country.getRegion());
        assertEquals(331000000, country.getPopulation());
        assertEquals("Washington, D.C.", country.getCity_name());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setInt(1, 10);
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetTenCountriesByContinent() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("country.Code"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("TestContinent");
        when(mockResultSet.getString(eq("country.Region"))).thenReturn("TestRegion");
        when(mockResultSet.getInt(eq("country.Population"))).thenReturn(1000000);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");

        // Create an instance of the CountryMethod class
        CountryMethod countryMethod = new CountryMethod();

        // Call the method with the mocked connection, continent, and limit
        ArrayList<Country> countries = countryMethod.getTenCountriesByContinent(mockConnection, "TestContinent", 10);

        // Verify the results
        assertEquals(1, countries.size());

        Country country = countries.get(0);
        assertEquals("ABC", country.getCountry_code());
        assertEquals("TestCountry", country.getCountry_name());
        assertEquals("TestContinent", country.getContinent());
        assertEquals("TestRegion", country.getRegion());
        assertEquals(1000000, country.getPopulation());
        assertEquals("TestCity", country.getCity_name());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockStatement, times(1)).setString(eq(1), eq("TestContinent"));
        verify(mockStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetTenCountriesByRegion() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("country.Code"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("TestContinent");
        when(mockResultSet.getString(eq("country.Region"))).thenReturn("TestRegion");
        when(mockResultSet.getInt(eq("country.Population"))).thenReturn(1000000);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");

        // Create an instance of the CountryMethod class
        CountryMethod countryMethod = new CountryMethod();

        // Call the method with the mocked connection, region, and limit
        ArrayList<Country> countries = countryMethod.getTenCountriesByRegion(mockConnection, "TestRegion", 10);

        // Verify the results
        assertEquals(1, countries.size());

        Country country = countries.get(0);
        assertEquals("ABC", country.getCountry_code());
        assertEquals("TestCountry", country.getCountry_name());
        assertEquals("TestContinent", country.getContinent());
        assertEquals("TestRegion", country.getRegion());
        assertEquals(1000000, country.getPopulation());
        assertEquals("TestCity", country.getCity_name());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockStatement, times(1)).setString(eq(1), eq("TestRegion"));
        verify(mockStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetCities() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("city.CountryCode"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("TestContinent");
        when(mockResultSet.getString(eq("city.District"))).thenReturn("TestDistrict");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CountryMethod class
        CityMethod cityMethod = new CityMethod();

        // Call the method with the mocked connection
        ArrayList<City> cities = cityMethod.getCities(mockConnection);

        // Verify the results
        assertEquals(1, cities.size());

        City city = cities.get(0);
        assertEquals("TestCity", city.getCity_name());
        assertEquals("ABC", city.getCountry_code());
        assertEquals("TestCountry", city.getCountry_name());
        assertEquals("TestContinent", city.getCity_continent());
        assertEquals("TestDistrict", city.getCity_district());
        assertEquals(1000000, city.getCity_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetCitiesByContinent() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("city.CountryCode"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("TestContinent");
        when(mockResultSet.getString(eq("city.District"))).thenReturn("TestDistrict");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CityMethod class
        CityMethod cityMethod = new CityMethod();

        // Call the method with the mocked connection
        ArrayList<City> cities = cityMethod.getCitiesByContinent(mockConnection, "TestContinent");

        // Verify the results
        assertEquals(1, cities.size());

        City city = cities.get(0);
        assertEquals("TestCity", city.getCity_name());
        assertEquals("ABC", city.getCountry_code());
        assertEquals("TestCountry", city.getCountry_name());
        assertEquals("TestContinent", city.getCity_continent());
        assertEquals("TestDistrict", city.getCity_district());
        assertEquals(1000000, city.getCity_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(eq(1), eq("TestContinent"));
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetCitiesByRegion() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("city.CountryCode"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("country.Region"))).thenReturn("TestRegion");
        when(mockResultSet.getString(eq("city.District"))).thenReturn("TestDistrict");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CityMethod class
        CityMethod cityMethod = new CityMethod();

        // Call the method with the mocked connection
        ArrayList<City> cities = cityMethod.getCitiesByRegion(mockConnection, "TestRegion");

        // Verify the results
        assertEquals(1, cities.size());

        City city = cities.get(0);
        assertEquals("TestCity", city.getCity_name());
        assertEquals("ABC", city.getCountry_code());
        assertEquals("TestCountry", city.getCountry_name());
        assertEquals("TestRegion", city.getCity_region());
        assertEquals("TestDistrict", city.getCity_district());
        assertEquals(1000000, city.getCity_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(eq(1), eq("TestRegion"));
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetCitiesByCountry() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("city.CountryCode"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("city.District"))).thenReturn("TestDistrict");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CityMethod class
        CityMethod cityMethod = new CityMethod();

        // Call the method with the mocked connection
        ArrayList<City> cities = cityMethod.getCitiesByCountry(mockConnection, "TestCountry");

        // Verify the results
        assertEquals(1, cities.size());

        City city = cities.get(0);
        assertEquals("TestCity", city.getCity_name());
        assertEquals("ABC", city.getCountry_code());
        assertEquals("TestCountry", city.getCountry_name());
        assertEquals("TestDistrict", city.getCity_district());
        assertEquals(1000000, city.getCity_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(eq(1), eq("TestCountry"));
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetCitiesByDistrict() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("city.CountryCode"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("city.District"))).thenReturn("TestDistrict");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CityMethod class
        CityMethod cityMethod = new CityMethod();

        // Call the method with the mocked connection
        ArrayList<City> cities = cityMethod.getCitiesByDistrict(mockConnection, "TestDistrict");

        // Verify the results
        assertEquals(1, cities.size());

        City city = cities.get(0);
        assertEquals("TestCity", city.getCity_name());
        assertEquals("ABC", city.getCountry_code());
        assertEquals("TestCountry", city.getCountry_name());
        assertEquals("TestDistrict", city.getCity_district());
        assertEquals(1000000, city.getCity_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(eq(1), eq("TestDistrict"));
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetTopTenCities() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("city.CountryCode"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("TestContinent");
        when(mockResultSet.getString(eq("city.District"))).thenReturn("TestDistrict");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CityMethod class
        CityMethod cityMethod = new CityMethod();

        // Call the method with the mocked connection
        ArrayList<City> cities = cityMethod.getTopTenCities(mockConnection, 10);

        // Verify the results
        assertEquals(1, cities.size());

        City city = cities.get(0);
        assertEquals("TestCity", city.getCity_name());
        assertEquals("ABC", city.getCountry_code());
        assertEquals("TestCountry", city.getCountry_name());
        assertEquals("TestContinent", city.getCity_continent());
        assertEquals("TestDistrict", city.getCity_district());
        assertEquals(1000000, city.getCity_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetTopTenCitiesByContinent() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("city.CountryCode"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("TestContinent");
        when(mockResultSet.getString(eq("city.District"))).thenReturn("TestDistrict");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CityMethod class
        CityMethod cityMethod = new CityMethod();

        // Call the method with the mocked connection
        ArrayList<City> cities = cityMethod.getTopTenCitiesByContinent(mockConnection, "TestContinent", 10);

        // Verify the results
        assertEquals(1, cities.size());

        City city = cities.get(0);
        assertEquals("TestCity", city.getCity_name());
        assertEquals("ABC", city.getCountry_code());
        assertEquals("TestCountry", city.getCountry_name());
        assertEquals("TestContinent", city.getCity_continent());
        assertEquals("TestDistrict", city.getCity_district());
        assertEquals(1000000, city.getCity_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(1, "TestContinent");
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetTopTenCitiesByRegion() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("city.CountryCode"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("country.Region"))).thenReturn("TestRegion");
        when(mockResultSet.getString(eq("city.District"))).thenReturn("TestDistrict");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CityMethod class
        CityMethod cityMethod = new CityMethod();

        // Call the method with the mocked connection
        ArrayList<City> cities = cityMethod.getTopTenCitiesByRegion(mockConnection, "TestRegion", 10);

        // Verify the results
        assertEquals(1, cities.size());

        City city = cities.get(0);
        assertEquals("TestCity", city.getCity_name());
        assertEquals("ABC", city.getCountry_code());
        assertEquals("TestCountry", city.getCountry_name());
        assertEquals("TestRegion", city.getCity_region());
        assertEquals("TestDistrict", city.getCity_district());
        assertEquals(1000000, city.getCity_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(1, "TestRegion");
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetTopTenCitiesByCountry() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("city.CountryCode"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("city.District"))).thenReturn("TestDistrict");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CityMethod class
        CityMethod cityMethod = new CityMethod();

        // Call the method with the mocked connection
        ArrayList<City> cities = cityMethod.getTopTenCitiesByCountry(mockConnection, "TestCountry", 10);

        // Verify the results
        assertEquals(1, cities.size());

        City city = cities.get(0);
        assertEquals("TestCity", city.getCity_name());
        assertEquals("ABC", city.getCountry_code());
        assertEquals("TestCountry", city.getCountry_name());
        assertEquals("TestDistrict", city.getCity_district());
        assertEquals(1000000, city.getCity_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(1, "TestCountry");
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetTopTenCitiesByDistrict() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("city.CountryCode"))).thenReturn("ABC");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getString(eq("city.District"))).thenReturn("TestDistrict");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CityMethod class
        CityMethod cityMethod = new CityMethod();

        // Call the method with the mocked connection
        ArrayList<City> cities = cityMethod.getTopTenCitiesByDistrict(mockConnection, "TestDistrict", 10);

        // Verify the results
        assertEquals(1, cities.size());

        City city = cities.get(0);
        assertEquals("TestCity", city.getCity_name());
        assertEquals("ABC", city.getCountry_code());
        assertEquals("TestCountry", city.getCountry_name());
        assertEquals("TestDistrict", city.getCity_district());
        assertEquals(1000000, city.getCity_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(1, "TestDistrict");
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetCapCities() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CapCityMethod class
        CapCityMethod capCityMethod = new CapCityMethod();

        // Call the method with the mocked connection
        ArrayList<CapCity> capitals = capCityMethod.getCapCities(mockConnection);

        // Verify the results
        assertEquals(1, capitals.size());

        CapCity capCity = capitals.get(0);
        assertEquals("TestCity", capCity.getCap_city_name());
        assertEquals("TestCountry", capCity.getCap_city_country());
        assertEquals(1000000, capCity.getCap_city_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetCapCitiesByContinent() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CapCityMethod class
        CapCityMethod capCityMethod = new CapCityMethod();

        // Call the method with the mocked connection
        ArrayList<CapCity> capitals = capCityMethod.getCapCitiesByContinent(mockConnection, "TestContinent");

        // Verify the results
        assertEquals(1, capitals.size());

        CapCity capCity = capitals.get(0);
        assertEquals("TestCity", capCity.getCap_city_name());
        assertEquals("TestCountry", capCity.getCap_city_country());
        assertEquals(1000000, capCity.getCap_city_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(1, "TestContinent");
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetCapCitiesByRegion() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CapCityMethod class
        CapCityMethod capCityMethod = new CapCityMethod();

        // Call the method with the mocked connection
        ArrayList<CapCity> capitals = capCityMethod.getCapCitiesByRegion(mockConnection, "TestRegion");

        // Verify the results
        assertEquals(1, capitals.size());

        CapCity capCity = capitals.get(0);
        assertEquals("TestCity", capCity.getCap_city_name());
        assertEquals("TestCountry", capCity.getCap_city_country());
        assertEquals(1000000, capCity.getCap_city_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(1, "TestRegion");
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetTopTenCapCities() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);

        // Create an instance of the CapCityMethod class
        CapCityMethod capCityMethod = new CapCityMethod();

        // Call the method with the mocked connection
        ArrayList<CapCity> capitals = capCityMethod.getTopTenCapCities(mockConnection, 10);

        // Verify the results
        assertEquals(1, capitals.size());

        CapCity capCity = capitals.get(0);
        assertEquals("TestCity", capCity.getCap_city_name());
        assertEquals("TestCountry", capCity.getCap_city_country());
        assertEquals(1000000, capCity.getCap_city_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetTopTenCapCitiesByContinent() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("TestContinent");

        // Create an instance of the CapCityMethod class
        CapCityMethod capCityMethod = new CapCityMethod();

        // Call the method with the mocked connection
        ArrayList<CapCity> capitals = capCityMethod.getTopTenCapCitiesByContinent(mockConnection, "TestContinent", 10);

        // Verify the results
        assertEquals(1, capitals.size());

        CapCity capCity = capitals.get(0);
        assertEquals("TestCity", capCity.getCap_city_name());
        assertEquals("TestCountry", capCity.getCap_city_country());
        assertEquals(1000000, capCity.getCap_city_population());
        assertEquals("TestContinent", capCity.getCap_city_continent());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(1, "TestContinent");
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testGetTopTenCapCitiesByRegion() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("city.Name"))).thenReturn("TestCity");
        when(mockResultSet.getString(eq("country.Name"))).thenReturn("TestCountry");
        when(mockResultSet.getInt(eq("city.Population"))).thenReturn(1000000);
        when(mockResultSet.getString(eq("country.Region"))).thenReturn("TestRegion");

        // Create an instance of the CapCityMethod class
        CapCityMethod capCityMethod = new CapCityMethod();

        // Call the method with the mocked connection
        ArrayList<CapCity> capitals = capCityMethod.getTopTenCapCitiesByRegion(mockConnection, "TestRegion", 10);

        // Verify the results
        assertEquals(1, capitals.size());

        CapCity capCity = capitals.get(0);
        assertEquals("TestCity", capCity.getCap_city_name());
        assertEquals("TestCountry", capCity.getCap_city_country());
        assertEquals(1000000, capCity.getCap_city_population());
        assertEquals("TestRegion", capCity.getCap_city_continent());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(1, "TestRegion");
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testEachContinent() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("CTP.Continent"))).thenReturn("Europe");
        when(mockResultSet.getLong(eq("COP.CountryTotalPopulation"))).thenReturn(500000000L);
        when(mockResultSet.getLong(eq("CTP.CityTotalPopulation"))).thenReturn(300000000L);
        when(mockResultSet.getLong(eq("TotalNotLivingCities"))).thenReturn(200000000L);
        when(mockResultSet.getString(eq("LivingInCities"))).thenReturn("60.00%");
        when(mockResultSet.getString(eq("NotLivingInCities"))).thenReturn("40.00%");

        // Create an instance of the PopulationPplMethod class
        population_lastfeatures_method populationPplMethod = new population_lastfeatures_method();

        // Call the method with the mocked connection
        ArrayList<populationppl> populationList = populationPplMethod.eachcontinent(mockConnection);

        // Verify the results
        assertEquals(1, populationList.size());

        populationppl population = populationList.get(0);
        assertEquals("Europe", population.getContinent_ppl());
        assertEquals(500000000L, population.getCountry_total_population());
        assertEquals(300000000L, population.getCity_total_population());
        assertEquals(200000000L, population.getTotal_not_livingcites());
        assertEquals("60.00%", population.getLiving_in_cities());
        assertEquals("40.00%", population.getNot_living_in_cities());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testEachRegion() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("RTP.Region"))).thenReturn("Southern");
        when(mockResultSet.getLong(eq("ROP.CountryTotalPopulation"))).thenReturn(300000000L);
        when(mockResultSet.getLong(eq("RTP.CityTotalPopulation"))).thenReturn(200000000L);
        when(mockResultSet.getLong(eq("TotalNotLivingCities"))).thenReturn(100000000L);
        when(mockResultSet.getString(eq("LivingInCities"))).thenReturn("66.67%");
        when(mockResultSet.getString(eq("NotLivingInCities"))).thenReturn("33.33%");

        // Create an instance of the PopulationPplMethod class
        population_lastfeatures_method populationPplMethod = new population_lastfeatures_method();

        // Call the method with the mocked connection
        ArrayList<populationppl> populationList = populationPplMethod.eachregion(mockConnection);

        // Verify the results
        assertEquals(1, populationList.size());

        populationppl population = populationList.get(0);
        assertEquals("Southern", population.getRegion_ppl());
        assertEquals(300000000L, population.getCountry_total_population());
        assertEquals(200000000L, population.getCity_total_population());
        assertEquals(100000000L, population.getTotal_not_livingcites());
        assertEquals("66.67%", population.getLiving_in_cities());
        assertEquals("33.33%", population.getNot_living_in_cities());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testEachCountry() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("COUTP.Name"))).thenReturn("United States");
        when(mockResultSet.getLong(eq("CUOP.CountryTotalPopulation"))).thenReturn(330000000L);
        when(mockResultSet.getLong(eq("COUTP.CityTotalPopulation"))).thenReturn(200000000L);
        when(mockResultSet.getLong(eq("TotalNotLivingCities"))).thenReturn(130000000L);
        when(mockResultSet.getString(eq("LivingInCities"))).thenReturn("60.61%");
        when(mockResultSet.getString(eq("NotLivingInCities"))).thenReturn("39.39%");

        // Create an instance of the PopulationPplMethod class
        population_lastfeatures_method populationPplMethod = new population_lastfeatures_method();

        // Call the method with the mocked connection
        ArrayList<populationppl> populationList = populationPplMethod.eachcountry(mockConnection);

        // Verify the results
        assertEquals(1, populationList.size());

        populationppl population = populationList.get(0);
        assertEquals("United States", population.getCountry_name());
        assertEquals(330000000L, population.getCountry_total_population());
        assertEquals(200000000L, population.getCity_total_population());
        assertEquals(130000000L, population.getTotal_not_livingcites());
        assertEquals("60.61%", population.getLiving_in_cities());
        assertEquals("39.39%", population.getNot_living_in_cities());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testTotalPopulationInWorld() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getLong(eq("WorldTotal"))).thenReturn(7800000000L); // Replace with your expected total world population

        // Create an instance of the PopulationPplMethod class
        population_lastfeatures_method populationPplMethod = new population_lastfeatures_method();

        // Call the method with the mocked connection
        ArrayList<populationppl> populationList = populationPplMethod.totalpopulationinworld(mockConnection);

        // Verify the results
        assertEquals(1, populationList.size());

        populationppl population = populationList.get(0);
        assertEquals(7800000000L, population.getWorld_total());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testTotalPopulationInAContinent() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getLong(eq("ContinentTotal"))).thenReturn(500000000L); // Replace with your expected total continent population
        when(mockResultSet.getString(eq("country.Continent"))).thenReturn("Asia"); // Replace with your expected continent name

        // Create an instance of the PopulationPplMethod class
        population_lastfeatures_method populationPplMethod = new population_lastfeatures_method();

        // Call the method with the mocked connection
        ArrayList<populationppl> populationList = populationPplMethod.totalpopulationinacontinent(mockConnection, "Asia");

        // Verify the results
        assertEquals(1, populationList.size());

        populationppl population = populationList.get(0);
        assertEquals(500000000L, population.getPopulationinacontinent());
        assertEquals("Asia", population.getContinent_name());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(1, "Asia");
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testTotalPopulationInARegion() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getLong(eq("RegionTotal"))).thenReturn(200000000L); // Replace with your expected total region population
        when(mockResultSet.getString(eq("country.Region"))).thenReturn("Northern"); // Replace with your expected region name

        // Create an instance of the PopulationPplMethod class
        population_lastfeatures_method populationPplMethod = new population_lastfeatures_method();

        // Call the method with the mocked connection
        ArrayList<populationppl> populationList = populationPplMethod.totalpopulationinaregion(mockConnection, "Northern");

        // Verify the results
        assertEquals(1, populationList.size());

        populationppl population = populationList.get(0);
        assertEquals(200000000L, population.getPopulationinaregion());
        assertEquals("Northern", population.getRegion_name());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockPreparedStatement, times(1)).setString(1, "Northern");
        verify(mockPreparedStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testTotalPopulationInACountry() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getLong(eq("CountryTotal"))).thenReturn(50000000L); // Replace with your expected country population

        // Create an instance of the PopulationPplMethod class
        population_lastfeatures_method populationPplMethod = new population_lastfeatures_method();

        // Call the method with the mocked connection
        ArrayList<populationppl> populationList = populationPplMethod.totalpopulationinacountry(mockConnection, "CountryName"); // Replace with your actual country name

        // Verify the results
        assertEquals(1, populationList.size());

        populationppl population = populationList.get(0);
        assertEquals(50000000L, population.getPopulationinacountry());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testTotalPopulationInADistrict() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getLong(eq("DistrictTotal"))).thenReturn(2000000L); // Replace with your expected district population

        // Create an instance of the PopulationPplMethod class
        population_lastfeatures_method populationPplMethod = new population_lastfeatures_method();

        // Call the method with the mocked connection
        ArrayList<populationppl> populationList = populationPplMethod.totalpopulationinadistrict(mockConnection, "DistrictName"); // Replace with your actual district name

        // Verify the results
        assertEquals(1, populationList.size());

        populationppl population = populationList.get(0);
        assertEquals(2000000L, population.getDistrict_total_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testTotalPopulationInACity() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getLong(eq("CityTotal"))).thenReturn(1000000L); // Replace with your expected city population

        // Create an instance of the PopulationPplMethod class
        population_lastfeatures_method populationPplMethod = new population_lastfeatures_method();

        // Call the method with the mocked connection
        ArrayList<populationppl> populationList = populationPplMethod.totalpopulationinacity(mockConnection, "CityName"); // Replace with your actual city name

        // Verify the results
        assertEquals(1, populationList.size());

        populationppl population = populationList.get(0);
        assertEquals(1000000L, population.getInacity_total_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).prepareStatement(anyString());
        verify(mockStatement, times(1)).executeQuery();
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testPrintPopulationInEachContinent() {
        // Mock the populationppl data
        populationppl mockPpl1 = mock(populationppl.class);
        when(mockPpl1.getContinent_ppl()).thenReturn("Continent1");
        when(mockPpl1.getCountry_total_population()).thenReturn(1000000L);
        when(mockPpl1.getCity_total_population()).thenReturn(800000L);
        when(mockPpl1.getTotal_not_livingcites()).thenReturn(200000L);
        when(mockPpl1.getLiving_in_cities()).thenReturn("80%");
        when(mockPpl1.getNot_living_in_cities()).thenReturn("20%");

        ArrayList<populationppl> mockData = new ArrayList<>();
        mockData.add(mockPpl1);

        // Create an instance of the PopulationPplMethod class
        population_in_lastfeatures_output populationPplMethod = new population_in_lastfeatures_output();

        // Call the method with the mocked data
        populationPplMethod.printPopulationineachcontinent(mockData);

        // You can add assertions here based on the behavior of the method or the state of the mocked data
        verify(mockPpl1, times(1)).getContinent_ppl();
        verify(mockPpl1, times(1)).getCountry_total_population();
        verify(mockPpl1, times(1)).getCity_total_population();
        verify(mockPpl1, times(1)).getTotal_not_livingcites();
        verify(mockPpl1, times(1)).getLiving_in_cities();
        verify(mockPpl1, times(1)).getNot_living_in_cities();

        // You can add more assertions based on your requirements
    }

    @Test
    public void testPrintPopulationInEachRegion() {
        // Mock the populationppl data
        populationppl mockPpl1 = mock(populationppl.class);
        when(mockPpl1.getRegion_ppl()).thenReturn("Region1");
        when(mockPpl1.getCountry_total_population()).thenReturn(1000000L);
        when(mockPpl1.getCity_total_population()).thenReturn(800000L);
        when(mockPpl1.getTotal_not_livingcites()).thenReturn(200000L);
        when(mockPpl1.getLiving_in_cities()).thenReturn("80%");
        when(mockPpl1.getNot_living_in_cities()).thenReturn("20%");

        ArrayList<populationppl> mockData = new ArrayList<>();
        mockData.add(mockPpl1);

        // Create an instance of the PopulationPplMethod class
        population_in_lastfeatures_output populationPplMethod = new population_in_lastfeatures_output();

        // Call the method with the mocked data
        populationPplMethod.printPopulationineachregion(mockData);

        // You can add assertions here based on the behavior of the method or the state of the mocked data
        verify(mockPpl1, times(1)).getRegion_ppl();
        verify(mockPpl1, times(1)).getCountry_total_population();
        verify(mockPpl1, times(1)).getCity_total_population();
        verify(mockPpl1, times(1)).getTotal_not_livingcites();
        verify(mockPpl1, times(1)).getLiving_in_cities();
        verify(mockPpl1, times(1)).getNot_living_in_cities();

        // You can add more assertions based on your requirements
    }

    @Test
    public void testPrintPopulationInEachCountry() {
        // Mock the populationppl data
        populationppl mockPpl1 = mock(populationppl.class);
        when(mockPpl1.getCountry_name()).thenReturn("Country1");
        when(mockPpl1.getCountry_total_population()).thenReturn(1000000L);
        when(mockPpl1.getCity_total_population()).thenReturn(800000L);
        when(mockPpl1.getTotal_not_livingcites()).thenReturn(200000L);
        when(mockPpl1.getLiving_in_cities()).thenReturn("80%");
        when(mockPpl1.getNot_living_in_cities()).thenReturn("20%");

        ArrayList<populationppl> mockData = new ArrayList<>();
        mockData.add(mockPpl1);

        // Create an instance of the PopulationPplMethod class
        population_in_lastfeatures_output populationPplMethod = new population_in_lastfeatures_output();

        // Call the method with the mocked data
        populationPplMethod.printPopulationineachcountry(mockData);

        // You can add assertions here based on the behavior of the method or the state of the mocked data
        verify(mockPpl1, times(1)).getCountry_name();
        verify(mockPpl1, times(1)).getCountry_total_population();
        verify(mockPpl1, times(1)).getCity_total_population();
        verify(mockPpl1, times(1)).getTotal_not_livingcites();
        verify(mockPpl1, times(1)).getLiving_in_cities();
        verify(mockPpl1, times(1)).getNot_living_in_cities();

        // You can add more assertions based on your requirements
    }

    @Test
    public void testPrintPopulationInWorld() {
        // Mock the populationppl data
        populationppl mockPpl1 = mock(populationppl.class);
        when(mockPpl1.getWorld_total()).thenReturn(7000000000L); // Replace this with the expected world population

        ArrayList<populationppl> mockData = new ArrayList<>();
        mockData.add(mockPpl1);

        // Create an instance of the PopulationPplMethod class
        population_in_lastfeatures_output populationPplMethod = new population_in_lastfeatures_output();

        // Call the method with the mocked data
        populationPplMethod.printPopulationinworld(mockData);

        // You can add assertions here based on the behavior of the method or the state of the mocked data
        verify(mockPpl1, times(1)).getWorld_total();

        // You can add more assertions based on your requirements
    }

    @Test
    public void testPrintPopulationInContinent() {
        // Mock the populationppl data
        populationppl mockPpl1 = mock(populationppl.class);
        when(mockPpl1.getContinent_name()).thenReturn("Asia"); // Replace this with the expected continent name
        when(mockPpl1.getPopulationinacontinent()).thenReturn(4500000000L); // Replace this with the expected population in Asia

        ArrayList<populationppl> mockData = new ArrayList<>();
        mockData.add(mockPpl1);

        // Create an instance of the PopulationPplMethod class
        population_in_lastfeatures_output populationPplMethod = new population_in_lastfeatures_output();

        // Call the method with the mocked data
        populationPplMethod.printPopulationinacontinent(mockData);

        // You can add assertions here based on the behavior of the method or the state of the mocked data
        verify(mockPpl1, times(1)).getContinent_name();
        verify(mockPpl1, times(1)).getPopulationinacontinent();

        // You can add more assertions based on your requirements
    }

    @Test
    public void testPrintPopulationInRegion() {
        // Mock the populationppl data
        populationppl mockPpl1 = mock(populationppl.class);
        when(mockPpl1.getRegion_name()).thenReturn("Southeast Asia"); // Replace this with the expected region name
        when(mockPpl1.getPopulationinaregion()).thenReturn(1200000000L); // Replace this with the expected population in Southeast Asia

        ArrayList<populationppl> mockData = new ArrayList<>();
        mockData.add(mockPpl1);

        // Create an instance of the PopulationPplMethod class
        population_in_lastfeatures_output populationPplMethod = new population_in_lastfeatures_output();

        // Call the method with the mocked data
        populationPplMethod.printPopulationinaregion(mockData);

        // You can add assertions here based on the behavior of the method or the state of the mocked data
        verify(mockPpl1, times(1)).getRegion_name();
        verify(mockPpl1, times(1)).getPopulationinaregion();

        // You can add more assertions based on your requirements
    }

    @Test
    public void testPrintPopulationInACountry() {
        // Mock the populationppl data
        populationppl mockPpl1 = mock(populationppl.class);
        when(mockPpl1.getCountry_name()).thenReturn("United States"); // Replace this with the expected country name
        when(mockPpl1.getPopulationinacountry()).thenReturn(331000000L); // Replace this with the expected population in the United States

        ArrayList<populationppl> mockData = new ArrayList<>();
        mockData.add(mockPpl1);

        // Create an instance of the PopulationPplMethod class
        population_in_lastfeatures_output populationPplMethod = new population_in_lastfeatures_output();

        // Call the method with the mocked data
        populationPplMethod.printPopulationinacountry(mockData);

        // You can add assertions here based on the behavior of the method or the state of the mocked data
        verify(mockPpl1, times(1)).getCountry_name();
        verify(mockPpl1, times(1)).getPopulationinacountry();

        // You can add more assertions based on your requirements
    }

    @Test
    public void testPrintPopulationInADistrict() {
        // Mock the populationppl data
        populationppl mockPpl1 = mock(populationppl.class);
        when(mockPpl1.getDistrict_name()).thenReturn("Manhattan"); // Replace this with the expected district name
        when(mockPpl1.getDistrict_total_population()).thenReturn(1694251L); // Replace this with the expected population in Manhattan

        ArrayList<populationppl> mockData = new ArrayList<>();
        mockData.add(mockPpl1);

        // Create an instance of the PopulationPplMethod class
        population_in_lastfeatures_output populationPplMethod = new population_in_lastfeatures_output();

        // Call the method with the mocked data
        populationPplMethod.printPopulationinadistrict(mockData);

        // You can add assertions here based on the behavior of the method or the state of the mocked data
        verify(mockPpl1, times(1)).getDistrict_name();
        verify(mockPpl1, times(1)).getDistrict_total_population();

        // You can add more assertions based on your requirements
    }

    @Test
    public void testPrintPopulationInACity() {
        // Mock the populationppl data
        populationppl mockPpl1 = mock(populationppl.class);
        when(mockPpl1.getCity_name()).thenReturn("New York City"); // Replace this with the expected city name
        when(mockPpl1.getInacity_total_population()).thenReturn(8419600L); // Replace this with the expected population in New York City

        ArrayList<populationppl> mockData = new ArrayList<>();
        mockData.add(mockPpl1);

        // Create an instance of the PopulationPplMethod class
        population_in_lastfeatures_output populationPplMethod = new population_in_lastfeatures_output();

        // Call the method with the mocked data
        populationPplMethod.printPopulationinacity(mockData);

        // You can add assertions here based on the behavior of the method or the state of the mocked data
        verify(mockPpl1, times(1)).getCity_name();
        verify(mockPpl1, times(1)).getInacity_total_population();

        // You can add more assertions based on your requirements
    }

    @Test
    public void testCountryLanguages() throws Exception {
        // Mock the objects needed for the test
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Set up the behavior of the mocks
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getString(eq("countrylanguage.Language"))).thenReturn("English"); // Replace with your expected language
        when(mockResultSet.getLong(eq("TotalPopulationwithlanguages"))).thenReturn(800000000L); // Replace with your expected population
        when(mockResultSet.getString(eq("Percentageofpopulationlanguages"))).thenReturn("20%"); // Replace with your expected percentage

        // Create an instance of the LanguagesMethod class
        populationoflanguagesmethod languagesMethod = new populationoflanguagesmethod();

        // Call the method with the mocked connection
        ArrayList<languages> languagesList = languagesMethod.countrylanguages(mockConnection);

        // Verify the results
        assertEquals(1, languagesList.size());

        languages language = languagesList.get(0);
        assertEquals("English", language.getLanguages_data());
        assertEquals(800000000L, language.getPopulation_with_languages());
        assertEquals("20%", language.getPercentage_population());

        // Verify that the necessary methods were called on the mocks
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeQuery(anyString());
        verify(mockResultSet, times(2)).next();
    }

    @Test
    public void testPrintPopulationOfLanguages() {
        // Mock the languages data
        languages mockLang1 = mock(languages.class);
        when(mockLang1.getLanguages_data()).thenReturn("English"); // Replace this with the expected language
        when(mockLang1.getPopulation_with_languages()).thenReturn(500000000L); // Replace this with the expected population of English speakers
        when(mockLang1.getPercentage_population()).thenReturn("20%"); // Replace this with the expected percentage

        ArrayList<languages> mockData = new ArrayList<>();
        mockData.add(mockLang1);

        // Create an instance of the Languages class
        populationwithlanguagesoutput languages = new populationwithlanguagesoutput();

        // Call the method with the mocked data
        languages.printPopulationoflanguages(mockData);

        // You can add assertions here based on the behavior of the method or the state of the mocked data
        verify(mockLang1, times(1)).getLanguages_data();
        verify(mockLang1, times(1)).getPopulation_with_languages();
        verify(mockLang1, times(1)).getPercentage_population();

        // You can add more assertions based on your requirements
    }

}
