# USE CASE: 32 Generate the sorted number of people (who speak the following language: Chinese, English, Hindi, Spanish and Arabic) from greatest to smallest number of speakers, with the percentage of the world population.

## CHARACTERISTIC INFORMATION

### Goal in Context

*As a demographic researcher, I want to find out the number of people who speak the following languages: Chinese, English, Hindi, Spanish and Arabic. Then, sort them from greatest number to smallest number of speakers, including the percentage of the world population so that I can make a report of the most popular languages spoken in the world.*

### Scope

Organization.

### Level

Primary task.

### Preconditions

The system has full access to find the population of the city from the World database.

### Successful End Condition

The system generates the sorted number of people (who speak the following language: Chinese, English, Hindi, Spanish and Arabic) from greatest to smallest number of speakers, along with the percentage of the world population. 

### Failed End Condition

The system does not generate the sorted number of people (who speak the following language: Chinese, English, Hindi, Spanish and Arabic) from greatest to smallest number of speakers, along with the percentage of the world population

### Primary Actor

Demographic Researcher.

### Trigger

The organization request the demographic researcher to make a report on the most popular languages spoken in the world.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests a report about the most popular languages spoken in the world (Chinese, English, Hindi, Spanish and Arabic) along with the percentage of the world population.

2. The system has access to the World Database through fixed value of languages which are  Chinese, English, Hindi, Spanish and Arabic.

3. The system extracts the number of people who speak Chinese, English, Hindi, Spanish and Arabic from the World Database.

4. The system calculates the number of speakers for each language relating to the percentage of the world population.

5. The system generate a table which include sorted number of people (who speak the following language: Chinese, English, Hindi, Spanish and Arabic) from greatest to smallest number of speakers, along with the percentage of the world population.

## EXTENSIONS

In the step 3 of scenario which extract the data, if the system cannot extract the data, then the user has to run the program again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 