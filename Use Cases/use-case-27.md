# USE CASE: 27 Generate The Population Of The Continent Based On Inputted Continent

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out about the population of a continent so that I can make a report detailing about the current population in a continent*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system generates the table of current population in a continent.

### Successful End Condition

The system generates the table of current population in the world.

### Failed End Condition

The system does not generate the table of current population in a continent.

### Primary Actor

Demographic Researcher

### Trigger

The organization requests the demographic researcher to make a report on about the current population in a continent.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests a report about the current population in a continent.

2. The system has access to the World Database through inputting the name of a continent.

3. The system extracts the current population information of that continent from the given database.

4. The system generates the table of current population information of that continent.


## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [16th Feb 2024] Release v0.4 