# DesafioDecrypto
App builded as independent Microservice, with MySQL 8, Java 19 and Spring Boot 3 as base.

--------------------------------------------------------------------------------------------------------

==========================
* Pre-Requierements: 
==========================

Docker (Optional) [https://www.docker.com/get-started/]
Java JDK:  19 [https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html]
DB Engine: MySQL 8 [https://dev.mysql.com/downloads/installer/]

After have MySQL 8 installed:
- Execute .sql DDL files into it in order to create tables. (Can be done through cmd or any software manager like mysql Workbench, dbeaver, heidi,etc

After have installed Java JDK 19:
- Find your java jdk BIN folder (normally: C:\Program Files\Java\jdk-19\bin)
- After know where is your java jdk 19 installed, go to the root folder of the project, you have a batch file called: "Start App", open with any text editor
- Replace the line: PATH = "C:\Program Files\Java\jdk-19\bin" with yours.

Now edit config file: 
- Go to: "ms-db\src\main\resources" and open file: "application-test.properties"
- Inside this file need edit "EXAMPLE" word with your info:

DBCP_MSDB_URL=jdbc:mysql://localhost:3306/EXAMPLE?useSSL=false&serverTimezone=UTC-3
DBCP_MSDB_USER=EXAMPLE
DBCP_MSDB_PASS=EXAMPLE

Start the application:
- go to the root folder again and double click on "Start App" batch file.

--------------------------------------------------------------------------------------------------------

==========================
* Useful Links: 
==========================

Main url: https://desafiocrypto-mdveloper.onrender.com/
Swagger: https://desafiocrypto-mdveloper.onrender.com/swagger-ui/index.html#/

--------------------------------------------------------------------------------------------------------

==========================
* Extras implemented/done:
==========================
- Some extra endpoints to generate more data randomly
- Postman Collection adjunted
- Unit test (simple and basic to cover controller and services)
- Checkstyle
- Pre-load database wipe+random data for fast test

--------------------------------------------------------------------------------------------------------

==========================
* Endpoints: 
==========================
[GET]
/comitentes/stats
- Endpoint used to get the full total distribution of comitentes by country and market

[GET]
/comitentes/stats1
- This endpoint was used to test performance between send a Map and json auto-serialize it. While "stats" EP map it manually and then send it,
when was using LAZY method on relation, with more than 10k comitentes start see 10-15ms ~ less response time with this method, now using FetchType EAGER no difference.
PS: EAGER bcoz we always need all info from both tables.

[GET]
/comitentes/createMercados?count=10
- A extra endpoint to create fast and easy new Meracdos with random info inside.

[GET]
/comitentes/createComitentes?count=5000
- A extra endpoint to create fast and easy new Comitentes with random info and asign them to a random Mercado

--------------------------------------------------------------------------------------------------------

==========================
* Muestras de performance:
==========================

General concepts and information:
Deploy its at US, Database at Canada server) so the path would be:
	current test PC -> Our deployment at "Render" US-EAST -> DB at Canada -> Back to deployment -> Back to current test PC


1) JMeter:
Inside "Tests/performance/Reports" folder have local and deploy test done using JMeter.
This performance test with JMeter was done to stress test the app with 1.100 request per second.

Local test with db: tolerance time was shorter to test if app works fine. Set to 800ms
Deploy test with db: based on "normal answers time" sum of all + JMeter proccess, I set tolerance time to 45000ms
Deploy test without db: tolerance time to 1000ms

2) Inside "tests/Postman" you have the collection export to test it too and check full response time from postman

3) Inside "tests/performance" you have local-application.txt file with some non-relevant info bcoz change due to PC specifications,etc.

Info can be checked at index.html of each report inside "Response Times"

--------------------------------------------------------------------------------------------------------