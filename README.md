# StudentGradesApp
Assignment SBA

Comments:
Probably still some exception handling to be done, and is currently unaccounted for.
Student class wasn't really used at all - original idea was to create student objects 
from reading each file. Instead I just used static methods in Application class to 
complete per the requirements.

Assignment: 
As a technical instructor, I need an application that will help me enter the students' names and grades per subject, calculate the class average score across subjects and then calculate the max & min score per subject cross all students.

When running the application, I expect to be able to interact with the console in the following way:

 

Please select one of the following options:

Create a new student
Enter students’ scores
Show class average score
Show subject minimum and maximum scores
 

When selecting option # 1:

The application will ask me to enter the studentName and the studentEmail. It will then create a text file named “studentName.txt” that contains the studentEmail.

 

When selecting option # 2:

The application will ask me to enter the studentName of which I want to enter his/her scores. It will then save this data into the student file.

 

When selecting option # 3:

The application will print the average score of all subjects for all students in the console.

 

When selecting option # 4:

The application will ask me to enter the subjectName and will print the minimum and maximum score in that subject across all students.
