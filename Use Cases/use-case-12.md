# USE CASE 12: Generate a table of top 10 populated cities in the world

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out what are the top 10 populated cities in the world so that I can make a report on the population growth of the top 10 cities in the world.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The demographic researcher has authorized access to the system, which includes the features to extract the required data from its updated World database.

### Successful End Condition

The system successfully generates the table of the top 10 populated cities in the world for a report on population growth.

### Failed End Condition

The system fails to generate a table of the world’s top 10 populated cities due to unavailable data or technical/system issues.

### Primary Actor

Demographic Researcher

### Trigger

The organization requests the demographic researcher to make a report on the population growth of the top 10 cities in the world.


## MAIN SUCCESS SCENARIO

1. The demographic researcher requests an output for the top 10 populated cities in the world to make a population growth-related report.

2. The system is activated to get access to the World database.

3. The system extracts all the data related to the top 10 populated cities in the world from its database.

4. The system generates a table of 10 cities that are the most populated in the world.


## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.   

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 