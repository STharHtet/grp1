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

### Successfully End Condition

The system successfully generates the table of the top 10 populated cities in the world for a report on population growth.

### Failed End Condition

The system fails to generate a table of the world’s top 10 populated cities due to unavailable data or technical/system issues.

### Primary Actor

Demographic Researcher

### Trigger

Data availability of the World database and successful system activation to generate the requested data.



## MAIN SUCCESS SCENARIO

1. The demographic researcher requests an output for the top 10 populated cities in the world to make a population growth-related report.

2. The system is activated to get access to the World database.

3. The system extracts all the data related to the top 10 populated cities in the world from its database.

4. The system generates a table of 10 cities that are the most populated in the world.



## EXTENSIONS

	When the system extracts the data from its database, in step 2 of the main scenario, the system will encounter an issue. Then, the error prompt will be displayed indicating the error's location in the program. Then, the user has a chance to fix the error and run the system again.  

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 