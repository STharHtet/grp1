# USE CASE: 23 Generate Table Of Population Of People, People Living In Cities And People Not Living In Cities In Each Continent

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out about the population of people, people living in cities and people not living in cities in each continent so that I can make report that compares urban and rural populations in each continent*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has complete access to connect with world database.

### Successful End Condition

The system generates the table of the population of the cities that are living and not living for each continent.

### Failed End Condition

The system does not generate the table of the population of the cities that are living and no living for each continent.

### Primary Actor

Demographic Researcher

### Trigger

The organization requests the demographic researcher to make a report about comparing urban and rural population in each continent

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests a report about comparing urban and rural population in each continent

2. The system has access to the World Database.

3. The system extracts the population of the cities that are living and no living for each continent.

4. The system generates the population of the cities that are living and not living for each continent in a table.

## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 