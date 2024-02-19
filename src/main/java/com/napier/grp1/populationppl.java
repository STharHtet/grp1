package com.napier.grp1;

/**
 * To take population with living in cities and not living in cities
 */
public class populationppl {

    // Continent PPL
    private String continent_ppl;
    public String getContinent_ppl() { return continent_ppl;}
    public void setContinent_ppl(String continent_ppl) { this.continent_ppl = continent_ppl; }

    // Region PPL
    private String region_ppl;
    public String getRegion_ppl() {
        return region_ppl;
    }
    public void setRegion_ppl(String region_ppl) {
        this.region_ppl = region_ppl;
    }

    // Country Name
    private String country_name;
    public String getCountry_name() {
        return country_name;
    }
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    private long populationinacountry;
    public long getPopulationinacountry() {
        return populationinacountry;
    }
    public void setPopulationinacountry(long populationinacountry) {
        this.populationinacountry = populationinacountry;
    }

    // total population of world
    private long world_total;
    public long getWorld_total() {
        return world_total;
    }
    public void setWorld_total(long world_total) {
        this.world_total = world_total;
    }

    // total population in a continent
    private long populationinacontinent;
    public long getPopulationinacontinent() {
        return populationinacontinent;
    }
    public void setPopulationinacontinent(long populationinacontinent) {
        this.populationinacontinent = populationinacontinent;
    }

    // collect continent name
    private String continent_name;
    public String getContinent_name() {
        return continent_name;
    }
    public void setContinent_name(String continent_name) {
        this.continent_name = continent_name;
    }

    // total population in a region
    private long populationinaregion;
    public long getPopulationinaregion() {
        return populationinaregion;
    }
    public void setPopulationinaregion(long populationinaregion) {
        this.populationinaregion = populationinaregion;
    }

    // collect region name
    private String region_name;
    public String getRegion_name() {
        return region_name;
    }
    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    // collect district name
    private String district_name;
    public String getDistrict_name() {
        return district_name;
    }
    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    // collect a city name
    private String city_name;
    public String getCity_name() {
        return city_name;
    }
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    // in a city total population
    private long inacity_total_population;
    public long getInacity_total_population() {
        return inacity_total_population;
    }
    public void setInacity_total_population(long inacity_total_population) {
        this.inacity_total_population = inacity_total_population;
    }

    // in a district total population
    private long district_total_population;
    public long getDistrict_total_population() {
        return district_total_population;
    }
    public void setDistrict_total_population(long district_total_population) {
        this.district_total_population = district_total_population;
    }

    // City Total Population
    private long city_total_population;
    public long getCity_total_population() {
        return city_total_population;
    }
    public void setCity_total_population(long city_total_population) { this.city_total_population = city_total_population; }

    // Country Total Population
    private long country_total_population;
    public long getCountry_total_population() {
        return country_total_population;
    }
    public void setCountry_total_population(long country_total_population) { this.country_total_population = country_total_population; }

    // Not Living in cities
    private String not_living_in_cities;
    public String getNot_living_in_cities() {
        return not_living_in_cities;
    }
    public void setNot_living_in_cities(String not_living_in_cities) {
        this.not_living_in_cities = not_living_in_cities;
    }

    // Total Not Living In cities
    private long Total_not_livingcites;
    public long getTotal_not_livingcites() {
        return Total_not_livingcites;
    }
    public void setTotal_not_livingcites(long total_not_livingcites) {
        Total_not_livingcites = total_not_livingcites;
    }

    //living in cities
    private String living_in_cities;
    public String getLiving_in_cities() {
        return living_in_cities;
    }
    public void setLiving_in_cities(String living_in_cities) {
        this.living_in_cities = living_in_cities;
    }
}
