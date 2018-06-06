This document defines the framework and its usage.
-

Definition:
-
Framework is developed for API automation. It does the POST,PUT,DELETE and GET functions. 

Dependencies:
-
1. Maven 
2. TestNG
3. ExtentReports.
4. jdk8

Usage:
-
Functions are grouped into 2 groups

1. SandC
2.commonfunctions

Function named MethodCalling_SG.java is the test driver function. It calls the functions based on requirement.

How it works:
-
User can run the test cases by defining them in excel sheet named TestNew.xlsx under location src\main\TestData. Excel sheet is self explanatory.

Limitations:
-
function names starting with/ending GET function can verify only two loop json fields as mentioned below.

example:

{
    "characteristicId": "MEASURE_MOUNTING_MODE",
    "translatedValue": null,
    "values": [
      {
        "valueId": "WITHOUT",
        "translatedValue": null,
        "isDefault": false
      }
    ]
  }
  
  