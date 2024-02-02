# USE CASE: 16 Generate A Table Of Top 10 Populated Cities Based On Inputted District

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out what are the top 10 populated cities in a district so that I can make a report on the population growth of the top 10 cities in a district.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has complete access to connect with world database.

### Successful End Condition

The system generates the table of top 10 cities which has the most population growth in a district.

### Failed End Condition

The system does not generate the table of top 10 cities which has the most population growth in a district.

### Primary Actor

Demographic Researcher

### Trigger

The population data in the World database must be accessible for the system to utilize.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests a report on the population growth of the top 10 cities in a district.

2. The system has access to the World Database through fixed value of 10 cities and inputting the name of a district.

3. The system extracts the population information from the given database within that district.

4. The system sorts the 10 cities which have the most population growth for that district.

5. The system generates the table of the top 10 cities which have the most population growth for that district.

## EXTENSIONS
	In step 2 of scenario which extracts the data, if the system stopped working then there will be an error prompt to display where the error has occurred in the program. The user then has the chance to fix the error and run the system again.  

## SUB-VARIATIONS
None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 