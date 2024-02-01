# USE CASE: 18 Generate A Sorted Capital Cities' Population Table Based On Inputted Continent From Largest To Smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out about all the capital cities in a continent sorted from largest population to smallest so that I can make a report about trends that affect the population growth of all the capital cities in a continent.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has complete access to connect with world database.

### Success End Condition

The system generates the table of all the capital cities in a continent sorted from largest population to smallest.

### Failed End Condition

The system does not generate the table of all the capital cities in a continent sorted from largest population to smallest.

### Primary Actor

Demographic Researcher

### Trigger

The population data in the World database must be accessible for the system to utilize.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests a report about trends that affect the population growth of all the capital cities in a continent.

2. The system has access to the World Database through inputting the name of the continent.

3. The system extracts the population information from the given database for the continent.

4. The system sorts the largest to smallest population of all the capital cities in that continent.

5. The system generates the table of all capital cities in that continent sorted from largest to smallest population growth.

## EXTENSIONS
	In step 2 of scenario which extracts the data, if the system stopped working then there will be an error prompt to display where the error has occurred in the program. The user then has the chance to fix the error and run the system again.  

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 