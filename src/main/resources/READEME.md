Instructions for creating a Java Spring Boot application | Project - online shop
=======

The application can be run by 2 ways:
-----------

1. Downloading the JAR file that is included in the Github repository and running the Java application from the console.
2. Using the git clone command and the URL of the repository.

---

First way
-----------

1. Configure the database

Make sure that you have installed the appropriate database on which the application runs. For example, this could be PostgreSQL, MySQL, H2, etc. Configure the database access data based on the provided file in the repository

-_**application.properties EXAMPLE**_-

which is located in the project. You can set information such as database URL, username, password, etc.


2. Run the application

Run the application by executing the command 

-**java -jar target/name_file.jar**-

where name_file.jar is the name specified in the repository which is **Challenge-0.0.1**

3. Check the action of the application

Open a web browser and go to http://localhost:8080 (or another address if you changed the port in the configuration). You should see a welcome page or other page that indicates that the application is working properly.

Second way
-----------

1. Clone the repository

Clone the repository containing the Java Spring Boot application code (online shop) to your local environment. You can do this using the _**git clone command**_ and the URL of the repository.

2. Configure the database

Make sure that you have installed the appropriate database on which the application runs. For example, this could be PostgreSQL, MySQL, H2, etc. Configure the database access data based on the provided file in the repository 

-_**application.properties EXAMPLE**_- 

which is located in the project. You can set information such as database URL, username, password, etc. 

3. Run the application

Navigate to the directory where the repository was cloned and execute the Maven command to launch the application.

-_**mvn spring-boot:run**_-

This command will build the application and start the Spring Boot application server on the local host and default port.

4. Check the action of the application

Open a web browser and go to http://localhost:8080 (or another address if you changed the port in the configuration). You should see a welcome page or other page that indicates that the application is working properly.