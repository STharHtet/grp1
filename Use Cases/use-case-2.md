# USE CASE 2: Generate a sorted countries’ population table based on inputted continent from largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to see a list of countries in a continent sorted from largest population to smallest so that I can make a report on what are the most populated and least populated countries in a continent.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The demographic researcher has authorized access to the system, which includes the features to extract the required data from its updated World database.

### Successful End Condition

The system successfully generates a table for population of all countries within a specific continent, which is sorted from largest to smallest for the report.

### Failed End Condition

The system fails to generate a table population of all countries within a specific continent due to unavailable data or technical/system issues.

### Primary Actor

Demographic Researcher

### Trigger

The organization requests the demographic researcher to make a report on what are the most populated and least populated countries in a continent.


## MAIN SUCCESS SCENARIO

1. The demographic researcher requests an output for all the countries within a specific continent to make a population-related report on those countries.

2. The system is activated to get access to the World database, and the name of a continent is inserted as an input.

3. The system extracts and sorts the data related to all the countries within a specified continent from its database.

4. The system generates a table of countries sorted from largest population to smallest within that specified continent.



## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.    

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [2nd Feb 2024] Release v0.2 