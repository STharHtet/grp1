# USE CASE 14: Generate a table of top 10 populated cities based on inputted region

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out what the top 10 populated cities in a region so that I can make a report on the population growth of the top 10 cities in a region.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The demographic researcher has authorized access to the system, which includes the features to extract the required data from its updated World database.

### Successful End Condition

The system successfully generates the table of the top 10 populated cities within a specific continent for a report on population growth.

### Failed End Condition

The system fails to generate a table of the world’s top 10 populated cities due to unavailable data or technical/system issues.

### Primary Actor

Demographic Researcher

### Trigger

The organization requests the demographic researcher to make a report on the population growth of the top 10 cities in a region.


## MAIN SUCCESS SCENARIO

1. The demographic researcher requests an output for the top 10 populated cities within a specific region to make a birth rate-related report on populations.

2. The system is activated to get access to the World database, and the name of a region is inserted as an input.

3. The system extracts all the data related to the top 10 populated cities within that specified region from its database.

4. The system generates a table of 10 cities that are the most populated within that specified region.



## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.   

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 