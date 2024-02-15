
  <h1 align="center">Bug Report</h1>

**Bug 1**

The bug caused by using the incompatible version of Java which leads to docker openjdk not to run properly.  

**To Reproduce**

1. Create a new project using Java Version "21" in Intellij 
2. Retrieve docker image for openjdk 
3. There will be error message display in the console about using unmatched version of Java.

**Expected behavior**
The project will not be able to continue due to unmatched Java version which is "21".The updated version of docker image does not exist for the process. 

**Screenshots**
If applicable, add screenshots to help explain your problem.

**Desktop (please complete the following information):**
 - OS: Windows 11/MacOs 
 - IDE: IntelliJ IDEA 
 - Version 2023.3.2 (Ultimate Version)

**Additional context**
None

