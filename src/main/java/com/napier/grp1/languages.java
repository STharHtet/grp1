package com.napier.grp1;

/**
 * to collect the data from the query
 * with getter and setter
 */
public class languages {

    // To collect languages data
    private String languages_data;
    public String getLanguages_data() {
        return languages_data;
    }
    public void setLanguages_data(String languages_data) {
        this.languages_data = languages_data;
    }

    // To collect population of people who spoke these languages
    private long population_with_languages;
    public long getPopulation_with_languages() {
        return population_with_languages;
    }
    public void setPopulation_with_languages(long population_with_languages) {
        this.population_with_languages = population_with_languages;
    }

    // to collect population of people who spoke these languages
    private String percentage_population;
    public String getPercentage_population() {
        return percentage_population;
    }
    public void setPercentage_population(String percentage_population) {
        this.percentage_population = percentage_population;
    }
}
