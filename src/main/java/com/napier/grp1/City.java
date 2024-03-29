package com.napier.grp1;

/**
 * The following class is to create getters and setters for
 * appropriate variables for CityMethod to work with.
 * Variables have been set to private and
 * getters and setters have been used for security reasons.
 */
public class City {

    private String city_name;

    private String country_code;

    private String city_district;

    private int city_population;

    private String country_name;

    private String city_continent;

    private String city_region;

    /**
     * Generate Getter and Setter
     * @return
     */
    public String getCity_region() {
        return city_region;
    }

    public void setCity_region(String city_region) {
        this.city_region = city_region;
    }

    public String getCity_continent() {
        return city_continent;
    }

    public void setCity_continent(String continent) {
        this.city_continent = continent;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCity_district() {
        return city_district;
    }

    public void setCity_district(String city_district) {
        this.city_district = city_district;
    }

    public int getCity_population() {
        return city_population;
    }

    public void setCity_population(int city_population) {
        this.city_population = city_population;
    }


}
