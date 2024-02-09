# USE CASE: 15 Generate A Table Of Top 10 Populated Cities Based On Inputted Country

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out what are the top 10 populated cities in a country so that I can make a report on the population growth of the top 10 cities in a country.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has complete access to connect with world database.

### Successful End Condition

The system generates the table of top 10 cities which has the most population growth for a country.

### Failed End Condition

The system does not generate the table of top 10 cities which has the most population growth for a country.

### Primary Actor

Demographic Researcher

### Trigger

The organization requests the demographic researcher to make a report on the population growth of the top 10 Cities in a country.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests the report on the population growth of the top 10 Cities in a country

2. The system has access to the World Database through fixed value of 10 cities and inputting the name of a country.

3. The system extracts and sorts population information of the 10 cities for that country from the given database.

4. The system generates the table of top 10 cities which has the most population growth  for that country.

## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 