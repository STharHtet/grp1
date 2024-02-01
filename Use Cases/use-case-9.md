# USE CASE 9: Generate a sorted cities’ population table based on inputted region from largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out about all the cities in a region sorted from largest population to smallest so that I can make a report on what are the most populated and least populated cities in a region.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The demographic researcher has authorized access to the system, which includes the features to extract the required data from its updated World database.

### Successfully End Condition

The system successfully generates a table for population of all cities within a specific region, which is sorted from largest to smallest for the report.

### Failed End Condition

The system fails to generate a table for population of all cities within a specific region due to unavailable data or technical/system issues.

### Primary Actor

Demographic Researcher

### Trigger

Data availability of the World database and successful system activation to generate the requested data.



## MAIN SUCCESS SCENARIO

1. The demographic researcher requests an output for all the cities within a specific region to make a population-related report on those cities.

2. The system is activated to get access to the World database, and the name of a region is inserted as an input.

3. The system extracts only the data related to all the cities within a specified region from its database.

4. The system then sorts all those cities from largest population to smallest.

5. The system generates a table of cities sorted from largest population to smallest within that specified region.



## EXTENSIONS

	When the system extracts the data from its database, in step 2 of the main scenario, the system will encounter an issue. Then, the error prompt will be displayed indicating the error's location in the program. Then, the user has a chance to fix the error and run the system again.   

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 