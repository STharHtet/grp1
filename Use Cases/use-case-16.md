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

The organization requests the demographic researcher to make a report on the population growth of the top 10 cities in a district.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests a report on the population growth of the top 10 cities in a district.

2. The system has access to the World Database through fixed value of 10 cities and inputting the name of a district.

3. The system extracts and sorts the 10 cities which have the most population growth for that district.

4. The system generates the table of the top 10 cities which have the most population growth for that district.

## EXTENSIONS
In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.

## SUB-VARIATIONS
None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 