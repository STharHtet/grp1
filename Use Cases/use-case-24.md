# USE CASE: 24 Generate Table Of Population Of People, People Living In Cities And People Not Living In Cities In Each Region

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out about the population of people, people living in cities and people not living in cities in each region so that I can make report that compares urban and rural populations in each region.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has complete access to connect with world database.

### Successful End Condition

The system generates the table of the population of the cities that are living and no living for each region.

### Failed End Condition

The system does not generate the table of the population of the cities that are living and no living for each region.

### Primary Actor

Demographic Researcher

### Trigger

The population data in the World database must be accessible for the system to utilize.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests a report comparing urban and rural population in each region.

2. The system has access to the World Database.

3. The system extracts the population information of the cities in each region from the given database.

4. The system extracts the population of the cities that are living and not living for each region.

5. The system generates the population of the cities that are living and no living for each region in a table.

## EXTENSIONS
	In step 2 of scenario which extracts the data, if the system stopped working then there will be an error prompt to display where the error has occurred in the program. The user then has the chance to fix the error and run the system again. 

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3