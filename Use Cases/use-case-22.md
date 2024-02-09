# USE CASE: 22 Generate A Table Of Top 10 Populated Capital Cities Based On The Inputted Region

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out about the top 10 populated capital cities in a region so that I can make a report to find out the top 10 populated capital cities in a region for suitable for tourist visits*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has complete access to connect with world database.

### Successful End Condition

The system generates the table of the top 10 populated capital cities that are suitable for tourist visit in a region.

### Failed End Condition

The system does not generate the table of the top 10 populated capital cities that are suitable for tourist visit in a region.

### Primary Actor

Demographic Researcher

### Trigger

The organization requests the demographic researcher to make a report about the top 10 populated capital cities that are suitable for tourist visits in a region.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests a report about the top 10 populated capital cities that are suitable for tourist visits in a region.

2. The system has access to the World Database through fixed value of 10 capital cities and inputting the name of a region.

3. The system extracts and sorts the top 10 capital cities for a continent which has the most population growth that is suitable for tourist visit within that region.

4. The system generates the table of the top 10 populated capital cities that are suitable for tourist visit in that region.

## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 