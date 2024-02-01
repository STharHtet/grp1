# USE CASE 5: Generate a table of top 10 populated countries based on inputted continent

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out what are the top 10 populated countries in the world so that I can make a report about birth rates correlating to populations in a continent.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The demographic researcher has authorized access to the system, which includes the features to extract the required data from its updated World database.

### Successfully End Condition

The system succeeds in generating a table of the top 10 populated countries within a specific continent for the birth rates report.

### Failed End Condition

The system fails to generate a table of the top 10 populated countries within a specific continent due to unavailable data or technical/system issues.

### Primary Actor

Demographic Researcher

### Trigger

Data availability of the World database and successful system activation to generate the requested data.



## MAIN SUCCESS SCENARIO

1. The demographic researcher requests an output for the top 10 populated countries within a specific continent to make a birth rate-related report on populations.

2. The system is activated to get access to the World database, and the name of a continent is inserted as an input.

3. The system extracts only the data related to the top 10 populated countries within that specified continent from its database.

4. The system generates a table of 10 countries that are the most populated within that specified continent.


## EXTENSIONS

	When the system extracts the data from its database, in step 2 of the main scenario, the system will encounter an issue. Then, the error prompt will be displayed indicating the error's location in the program. Then, the user has a chance to fix the error and run the system again.   

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 