# USE CASE 4: Generate a table of top 10 populated countries in the world

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out what are the top 10 populated countries in the world so that I can make a report about birth rates correlating to populations in the world.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The demographic researcher has authorized access to the system, which includes the features to extract the required data from its updated World database.

### Successful End Condition

The system successfully generates the table of the top 10 populated countries in the world for the birth rates report.

### Failed End Condition

The system fails to generate a table of the world’s top 10 populated countries due to unavailable data or technical/system issues.

### Primary Actor

Demographic Researcher

### Trigger

Data availability of the World database and successful system activation to generate the requested data.



## MAIN SUCCESS SCENARIO

1. The demographic researcher requests an output for the top 10 populated countries in the world to make a birth rate-related report on populations.

2. The system is activated to get access to the World database.

3. The system extracts all the data related to the top 10 populated countries in the world from its database.

4. The system generates a table of 10 countries which are the most populated in the world.



## EXTENSIONS

    When the system extracts the data from its database, in step 3 of the main scenario, the system will encounter an issue. Then, the error prompt will be displayed indicating the error's location in the program. Then, the user has a chance to fix the error and run the system again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 