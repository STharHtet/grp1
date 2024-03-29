package com.napier.grp1;


/**
 * The following class is to create getters and setters for
 * appropriate variables for CapCityMethod to work with.
 * Variables have been set to private and
 * getters and setters have been used for security reasons.
 */
public class CapCity {

    private String cap_city_name;

    private String cap_city_country;

    private int cap_city_population;

    private String cap_city_continent;

    private String cap_city_region;

    public String getCap_city_continent() {
        return cap_city_continent;
    }

    public void setCap_city_continent(String cap_city_continent) {
        this.cap_city_continent = cap_city_continent;
    }

    public String getCap_city_name() {
        return cap_city_name;
    }

    public void setCap_city_name(String cap_city_name) {
        this.cap_city_name = cap_city_name;
    }

    public String getCap_city_country() {
        return cap_city_country;
    }

    public void setCap_city_country(String cap_city_country) {
        this.cap_city_country = cap_city_country;
    }

    public int getCap_city_population() {
        return cap_city_population;
    }

    public void setCap_city_population(int cap_city_population) {
        this.cap_city_population = cap_city_population;
    }
}

