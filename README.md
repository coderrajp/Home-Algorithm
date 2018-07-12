******************************
STEPS TO RUN THE SOURCE FILES
******************************

1. Open the java project in any of the IDE you are comfortable with.
2. Open the Main_2.java from the src folder.
3. Main_2.java is the class file which contains the required getHomeLocation() method.
4. The method takes List<Visit> as input and returns the Location (Home Location).
5. I have put logs in each condition (pass/fail) in the method, so that result of each Visit object is known.
6. At the end of the method, the log prints the HOME LOCATION from the provided list and the Hours spent.
7. If the method does not find the home location it returns null in the output.
8. Dummy.java contains few dummy visits. (the time is input in milliseconds).

Note:
- If the arrival_time is before 8pm then the duration is calculated from 8pm.
- Similarly, if departure_time is after 8am then the duration is calculated till 8am.