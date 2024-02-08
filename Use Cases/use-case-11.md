# USE CASE 11: Generate a sorted cities’ population table based on inputted district from largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out about all the cities in a district sorted from largest population to smallest so that I can make a report on what are the most populated and least populated cities in a district.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The demographic researcher has authorized access to the system, which includes the features to extract the required data from its updated World database.

### Successful End Condition

The system successfully generates a table for population of all cities within a specific district, which is sorted from largest to smallest for the report.

### Failed End Condition

The system fails to generate a table for population of all cities within a specific district due to unavailable data or technical/system issues.

### Primary Actor

Demographic Researcher

### Trigger

The organization requests the demographic researcher to make a report on what are the most populated and least populated cities in a district.


## MAIN SUCCESS SCENARIO

1. The demographic researcher requests an output for all the cities within a specific district to make a population-related report on those cities.

2. The system is activated to get access to the World database, and the name of a district is inserted as an input.

3. The system extracts and sorts only the data related to all the cities within a specified district from its database.

4. The system generates a table of cities sorted from largest population to smallest within that specified district.



## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.   

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 