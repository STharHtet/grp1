# USE CASE: 19 Generate a Sorted Capital Cities' Population Table Based On Inputted Region From Largest To Smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out about all the capital cities in a region sorted from largest population to smallest so that I can make a report about trends that affect the population growth of all the capital cities in a region*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has complete access to connect with world database.

### Successful End Condition

The system generates the table of all capital cities in a region sorted from largest to smallest population growth.

### Failed End Condition

The system does not generate the table of all capital cities in a region sorted from largest to smallest population growth.

### Primary Actor

Demographic Researcher

### Trigger

The organization requests the demographic researcher to make a report on about trends that affect the population growth of all the capital cities in a region.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests a report about trends that affect the population growth of all the capital cities in a region.

2. The system has access to the World Database through inputting the name of a region.

3. The system extracts and sorts the largest to smallest population of all the capital cities in that region.

4. The system generates the table of all capital cities in that region sorted from largest to smallest population growth.

## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 