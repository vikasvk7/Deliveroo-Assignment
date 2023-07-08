# Deliveroo-Assignment

Problem Statement:

Write a command line application or script which parses a cron string and expands each field
to show the times at which it will run.

- Language and Unit testing : Java and jUnit
- Overview :

The root folder contains:

- CronField: What are the actual cronfields in a cron expression. i,e minutes, hours, dayOfMonth fields etc.
- CronFieldType: What is the range of and type of the cronfield. i,e minutes has MINUTES and range as (0,59)
- CronParser: The actual class where the initialisation of CronFields takes place. Also has the formatting of the result in toString() method.
- Main: The entry point of the code where in the CronParser is initalised with the command line arguments.


ParseHandlers contains:

- ParseHandlerInterface: This is the interface which has methods like parseField, parseNumber and populateValues.

As there can be 3 types of values present in the cronexpression, an interval, a range, or a fixed value.
So created the following Handlers to handle and parse the cronfield value.

- FixedValueHandler
- IntervalHandler
- RangeHandler


tests folder contains:

- CronParserTest


# How to run the script

Go to eclipse IDE, and in the Run button, go to Run as configurations.
Under "Arguments" write : 

`"*/15 0 1,15 * 1-5 /usr/bin/find"`
