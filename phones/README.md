# Web API of a simple phone list

This is a simple project of an web API that shows a workaround of an hibernate criteria query that receives a list of phone numbers then uses it in a Criterion's Restrictions.like in conjuntion with a Restrictions.or.

This project has made using:
 - [Springboot](https://spring.io/projects/spring-boot) 
 -  [H2](https://www.h2database.com/html/main.html) embedded database 
 - Java version 1.8

Before run:
1. Open you project in your IDE (Eclipse, IntelliJ IDEA, etc) as a maven project.
2. In resources folder, open application.properties file and change spring.datasource.url=jdbc:h2:file:/tmp/demo to spring.datasource.url=jdbc:h2:file:[Path to whatever place you want to save database]

    _Ex.: Unix, Linux or Mac - spring.datasource.url=jdbc:h2:file:/[your home user directory]/database
    Windows: spring.datasource.url=jdbc:h2:file:C://tmp/database_

Running the project

1. Inside your IDE, run the class App.java as a regular java console.
2. After starts the project creates some phones records. You can access database and see saved data browsing the following URL:   
http://localhost:8080/h2-console/  
username: sa  
password: password

**OBS.: This project is simplified for learning purposes. So don't expect uses of fancy design patterns here.**
