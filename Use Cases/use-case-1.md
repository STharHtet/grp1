# USE CASE 1: Generate a sorted countries’ population table in the world from largest to smallest

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to see a list of countries in the world sorted from largest population to smallest so that I can make a report on what are the most populated and least populated countries in the world.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The demographic researcher has authorized access to the system, which includes the features to extract the required data from its updated World database.

### Successful End Condition

The system succeeds in generating the world’s population table which is sorted from largest to smallest for the report.

### Failed End Condition

The system fails to generate the world’s population table due to unavailable data or technical/system issues.

### Primary Actor

Demographic Researcher

### Trigger

Data availability of the World database and successful system activation to generate the requested data.



## MAIN SUCCESS SCENARIO

1. The demographic researcher requests an output for all the countries in the world to make a population-related report on countries.

2. The system is activated to get access to the World database.

3. The system extracts all the data related to the world’s countries from its database.

4. The system then sorts all those countries from largest population to smallest.

5. The system generates a table of countries sorted from largest population to smallest in the world.

## EXTENSIONS

	When the system extracts the data from its database, in step 3 of the main scenario, the system will encounter an issue. Then, the error prompt will be displayed indicating the error's location in the program. Then, the user has a chance to fix the error and run the system again. 

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [2nd Feb 2024] Release v0.2 