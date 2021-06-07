# DisplayJobs
Parse a list of jobs and applicants (jobs.csv) and render it in a page.


Write code (no GUI) to read the CSV file and store the data in a structured way (assume applicant names are unique).
A job has many applicants and one applicant can apply to multiple jobs.
Users should be able to view a list of jobs with title, location and date.
Users should be able to click on a job to view more details about it.
The detail view should include title, description, location, date and the list of applicants.
The frontend should connect to the backend to request information. The backend should
use a MySQL database to store and retrieve the relevant information.

jobs.csv

job title,job description,date,location,applicants

Full Stack Developer,Java SpringBoot ReactJS,07/06/2021,Melbourne,"james, bond, donald, duck"

Java Developer,Java SpringBoot,03/06/2021,Sydney,"james, bond"

React Developer,ReactJS,01/06/2021,Brisbane,donald

Full Stack Developer,Java SpringBoot ReactJS,07/05/2021,Perth,"james, donald"


Backend: 

project-name : display-jobs

Import the Java/Spring Boot project in backend in Intellij/Eclipse.

Change the file location in DisplayJobsApplication>readCSV() method to the location of jobs.csv file in your local machine. 

Change the database details in application.properties file.
	spring.datasource.url, spring.datasource.username, spring.datasource.password

Run DisplayJobsApplication, the application will be up and running on port 8080


Frontend:

project-name : display-jobs

Import the project to VSC code

Execute the command npm start on the terminal, the application will be up and running on port 3000


In your browser, check http://localhost:3000 to see the application.

http://localhost:3000 - Welcome Page

http://localhost:3000/jobs - To view the list of jobs

http://localhost:3000/jobs/:jobId - To view details of a particular job, where jobId=1 will display details of first job
