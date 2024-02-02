# USE CASE: 20 Generate A Table Of Top 10 Populated Capital Cities In The World

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out about the top 10 populated capital cities in the world so that I can make a report to find out the top 10 populated capital cities in the world suitable for tourist visits*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has complete access to connect with world database.

### Successful End Condition

The system generates the table of top 10 capital cities that suitable for tourist visit in the world.

### Failed End Condition

The system does not generate the table of top 10 capital cities that suitable for tourist visit in the world.

### Primary Actor

Demographic Researcher

### Trigger

The population data in the World database must be accessible for the system to utilize.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher request a report about the top 10 populated capital cities that suitable for tourist visits in the world.

2. The system has access to the World Database through fixed value of 10 capital cities.

3. The system extracts the population information of the capital cities in the world from the given database.

4. The system sorts the top 10 capital cities for a country which has the most population growth that is suitable for tourist visit in the world.

5. The system generates the table of the top 10 populated capital cities that are suitable for tourist visit in the world.

## EXTENSIONS
	In step 2 of scenario which extracts the data, if the system stopped working then there will be an error prompt to display where the error has occurred in the program. The user then has the chance to fix the error and run the system again.  

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 