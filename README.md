# Backend for SBAB code assignment

## Requirements
* Env var `API_KEY` set to Trafiklab API key

## Added dependencies
* spring-boot-starter-webflux (for WebClient)

## Time keeping (BE only)
15/9:
* 45 min - Setting up npm and Java for Windows and VSCode (.NET configed machine)
* 45 min - Getting API key, reading API spec, getting API calls to work and basic return structure for BE

16/9:
* 15 min - Documentation
* 60 min - Coding (API calls, mapping calls to assigment reqs)
* 60 min - Coding (working with streams, maps, lists)
* 30 min - Coding (first working BE version, remove duplicate stops)
* 20 min - Coding (refactoring, comments)

* Total: 4 hr 35 min
* Of which was setup: 1 hr 30 min
* Of which was coding: 3 hr 5 min

## Tech
* Java
* Maven

## Assumptions
* Number of stops will be interpreted as the number of distinct stops by name. Names with the same name but different DirectionCode will not be counted twice.

## Improvements/things left out
* Cache like.. everything (violates assignment spec)
* Use `Use Accept-Encoding gzip, deflate` (as stated by API docs) with WebClient
* API call error handling
* Tests - most critical for `LineAndStopServiceImpl.java`
* Remove `block()` for API call, and use `subscribe()` instead

## Reflections
* Wierd API
