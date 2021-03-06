# startup
assignment
=================Objective=============================

The aim of this document is to guide the user for setting up the environment for the framework and execute the test suite.

Environment Setup:
-------------------

Tools required:
1. Eclipse IDE
2. JDK 8
3. Maven
4.Framework

-->Download the Eclipse from http://www.eclipse.org/downloads/eclipse-packages/ and unzip in your system.
-->Download the JDK 8 from http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html and install in your system.
-->configure the maven in eclipse.
-->Download the framework from 'https://github.com/srinivasaraojyothi/startup/'
-->Import the downloaded project into maven project.
-->Verify following files/folders available in the imported project.
packages:zycus.assignment.common, zycus.assignment.core, zycus.assignment.utilities
folders: src/main/resources, src/main/TestData
Files:src/main/TestData/Zycus-Assignment.xlsx

Executing the Test Suite:
------------------------
Test case sheet Zycus-Assignment.xlsx under src\main\TestCases has all the test cases defined. Header columns represents Test Case,Test Step,Function,API Url,Test Data,Expected HTTPS Code,Expected HTTPS Entity Message/Body respectively. Provide the data accordingly.
Test data is placed under src\main\resources\InputData in .json format.

Update the config.properties file with base urls.
Run the test suite by providing maven build with -clean test -DargLine="-Denv=vnv -Dtest=Zycus-Assignment".
Refer the \target\surefire-reports\ExtentReport.html for test results.
