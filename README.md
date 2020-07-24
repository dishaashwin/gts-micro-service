
Table of Contents

• Basic Overview

• Installation

• Usage


1.	Basic Overview

• It is an application to store the work experience of the job seeker or user. Job seeker designation, project skill ids, Start date ,End date, Employer etc., are       collected from the job seeker or user and it will be store in MYSQL database. . They will be able to update the work experience of the user   and also they can delete the the work experience of the job seeker of user.


Install MySQL and create database Schema WorkExperience using the command

   create database workExperience


All the table structure will be created when u start running the project.

Pull the Project from Github and run it 

Go to Github https://github.com/goraitech49/GTSChakuriWorkExperienceService.git and pull the project in the eclipse. 
 
 In the Project open application.properties -> change the credentials for database

 Go to project name right click -> Run as -> Spring boot app

At this time MySQL should also be running so that we can insert data into Table through Swagger UI.





You can use the Postman app to test the apis


POSTMAPPING - /api/v1/users/WorkExperience  (Used to create a new work experience)

•add all the params in the JSON as body and send it . This will post a work experience and it will be saved in MYSQL database.


PUTMAPPING - /api/v1/users/WorkExperience  (Used to update the posted job)

• add all the params in the JSON as body and and send it with existing user id . This will update the work experience if existing or throw an internal error if something is wrong in the params.

GETMAPPING -/api/v1/users/WorkExperience (used to get all the work experiences related to particular user)

Fill the "userid" query param and call the url 
DELETEMAPPING - /api/v1/users/WorkExperience  (Used to delete work experience)

• Fill the "work experience id" queryparam to delete the work experience from database.


After you started the project go to the system browser and open the following url.
http://localhost:9000/chaukuriWorkExperience/swagger-ui.html





You will be able to see the swagger UI and you can test the rest api's from the swagger UI by providing the necessary details.



POSTMAPPING - /api/v1/users/WorkExperience  (Used to create a new work experience)

• Fill all the params in the swagger UI and click on the execute button. This will post a work experince and it will be saved in MYSQL database.


PUTMAPPING - /api/v1/users/WorkExperience  (Used to update the posted job)

• Fill all the params in the swagger UI and click on the execute button. This will update the work experience if existing or throw an internal error if something is wrong in the params.

GETMAPPING -/api/v1/users/WorkExperience (used to get all the work experiences related to particular user

DELETEMAPPING - /api/v1/users/WorkExperience  (Used to delete work experience)

• Fill the work experience id to delete the work experience from database.
