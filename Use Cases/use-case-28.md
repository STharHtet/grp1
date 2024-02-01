# USE CASE 28: Generate the population of the region based on inputted region ()

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *demographic researcher*, I want *to find out about the population of the region* so that *I can make a report dealing about the current population in a region.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has full access to find the population of the region from the World database.

### Successful End Condition

he system succeeds in generating the current region population table.

### Failed End Condition

The system fails to generate the region population table.

### Primary Actor

Demographic researcher.

### Trigger

The population data in the World database must be accessible for the system to utilize.

## MAIN SUCCESS SCENARIO

1. The demographic researcher inserts one region in the input.
2. The system then accesses the World Database. 
3. The system extracts the current population information of the input region from the World database. 
4. The system generates the current population information of the input region with a table.

## EXTENSIONS

In step 2 of scenario which extracts the data, if the system stopped working then there will be an error prompt to display where the error has occurred in the program. The user then has the chance to fix the error and run the system again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 