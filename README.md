# Backend for SBAB code assignment

## Time keeping
15/9:
30 min - Setting up npm and Kotlin/Gradle envs on Windows machine through WSL2
30 min - WSL2 isn't a good match for Java/VSCode, setup on Windows native instead
45 min - Basic project structure, DTOs based on API
10 min - Realized that VSCode has bad support for Kotlin, and that the assigment states that Java should be used. Ported existing code to Java..
45 min - Getting API key, reading API spec, getting API calls to work and basic return structure for BE

16/9:
15 min - Documentation
60 min - Coding (API calls, mapping calls to assigment reqs)
60 min - Coding (working with streams, maps, lists)
30 min - Coding (first working BE version, remove duplicate stops)

Total: X hr Y min
Of which was setup/restarts: 1 hr 55 min
Of which was coding: X hr Y min

## Tech
* ~~Kotlin (new)~~
* ~~Gradle (new - used Maven before)~~
* Java
* Maven
* React

## Assumptions
* Number of stops will be interpreted as the number of distinct stops by name. Names with the same name but different DirectionCode will not be counted twice.

## Improvements/things left out
* Cache like.. everything (violates assignment spec)
* Use `Use Accept-Encoding gzip, deflate` (as stated by API docs) with WebClient
* API call error handling
* Tests - most critical for `LineAndStopServiceImpl.java`

## Reflections
* Wierd API
* A lot of time wasted on environment setup + Kotlin/Gradle-issues
* Assigment estimation time of max 4 hours is low. How would you estimate the creation of a completely new app (BE+FE - including starting from a new computer) with an external API consumption and semi-large data manipulation in your refinement meetings?

## My own notes
https://api.sl.se/api2/Linedata.json?key=[nyckel]&model=jour&DefaultTransportModeCode=BUS
Line -> Stop : JourneyPatternPointOnLine