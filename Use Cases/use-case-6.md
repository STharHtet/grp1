# USE CASE 6: Generate a table of top 10 populated countries based on inputted region

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out what are the top 10 populated countries in the world so that I can make a report about birth rates correlating to populations in a region.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The demographic researcher has authorized access to the system, which includes the features to extract the required data from its updated World database.

### Successful End Condition

The system succeeds in generating a table of the top 10 populated countries within a specific region for the birth rates report.

### Failed End Condition

The system fails to generate a table of the top 10 populated countries within a specific region due to unavailable data or technical/system issues.

### Primary Actor

Demographic Researcher

### Trigger

The organization requests the demographic researcher to make a report about birth rates correlating to populations in  a region.


## MAIN SUCCESS SCENARIO

1. The demographic researcher requests an output for the top 10 populated countries within a specific region to make a birth rate-related report on populations.

2. The system is activated to get access to the World database, and the name of a region is inserted as an input.

3. The system extracts only the data related to the top 10 populated countries within that specified region from its database.

4. The system generates a table of 10 countries that are the most populated within that specified region.


## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.   

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 