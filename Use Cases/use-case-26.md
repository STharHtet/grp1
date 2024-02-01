# USE CASE: 26 Generate The Population Of The World

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out about the population of the world so that I can make a report detailing about the current population in the world*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has complete access to connect with world database.

### Successful End Condition

The system generates the table of current population in the world.

### Failed End Condition

The system does not generate the table of current population in the world.

### Primary Actor

Demographic Researcher

### Trigger

The population data in the World database must be accessible for the system to utilize.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests a report about the current population in the world.

2. The system has access to the World Database.

3. The system extracts the current population information of the world from the given database.

4. The system generates the table of current population information of the world.


## EXTENSIONS
	In step 2 of scenario which extracts the data, if the system stopped working then there will be an error prompt to display where the error has occurred in the program. The user then has the chance to fix the error and run the system again. 

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3