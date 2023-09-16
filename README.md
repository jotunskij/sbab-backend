# Backend for SBAB code assignment

## Time keeping
15/9:
45 min - Setting up npm and Java for Windows and VSCode (.NET configed machine)
45 min - Getting API key, reading API spec, getting API calls to work and basic return structure for BE

16/9:
15 min - Documentation
60 min - Coding (API calls, mapping calls to assigment reqs)
60 min - Coding (working with streams, maps, lists)
30 min - Coding (first working BE version, remove duplicate stops)
X min - Coding (BE: refactoring, comments, FE: project startup)

Total: X hr Y min
Of which was setup: 1 hr 30 min
Of which was coding: X hr Y min

## Tech
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
