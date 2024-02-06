# USE CASE 30: Generate the population of the district based on inputted district

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *demographic researcher*, I want *to find out about the population of the district* so that *I can make a report dealing about the current population in a district.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has full access to find the population of the district from the World database.

### Successful End Condition

The system succeeds in generating the current district population table.

### Failed End Condition

The system fails to generate the district population table.

### Primary Actor

Demographic researcher.

### Trigger

The organization request the demographic researcher to make a report on the current population of the inputted district.

## MAIN SUCCESS SCENARIO

1. The demographic researcher inserts one district in the input. 
2. The system then accesses the World Database. 
3. The system extracts the current population information of the input district from the World database. 
4. The system generates the current population information of the input district with a table.

## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 