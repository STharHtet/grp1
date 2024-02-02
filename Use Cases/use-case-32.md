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

The World database must be accessible for the system to utilize.

## MAIN SUCCESS SCENARIO

1. Demographic Researcher requests a report about the most popular languages spoken in the world (Chinese, English, Hindi, Spanish and Arabic) along with the percentage of the world population.

2. The system has access to the World Database through fixed value of languages which are  Chinese, English, Hindi, Spanish and Arabic.

3. The system extracts the number of people who speak Chinese, English, Hindi, Spanish and Arabic from the World Database.

4. The system calculates the number of speakers for each language relating to the percentage of the world population.

5. The system generate a table which include sorted number of people (who speak the following language: Chinese, English, Hindi, Spanish and Arabic) from greatest to smallest number of speakers, along with the percentage of the world population.

## EXTENSIONS

In step 3 of scenario which extracts the data, if the system stopped working then there will be an error prompt to display where the error has occurred in the program. The user then has the chance to fix the error and run the system again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: [9th Feb 2024] Release v0.3 