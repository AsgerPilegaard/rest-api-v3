Create the executable JAR file using gradle.
```
./mvnw clean install
```

Build the docker image.
The Dockerfile assumes maven has been used to build the java project.
and the recently created executable JAR file is referenced from the dockerfile.
```
docker build -t spring-rest-api .
```

Run the docker image and host it on port 8080.
```
docker run -p 8080:8080 spring-rest-api
```

Companies sunshine scenarios:
```
curl -u "user:123" http://localhost:8080/companies/list
curl -u "user:123" http://localhost:8080/companies/get/company1
curl -u "admin:123" -X POST -H "Content-Type: application/json" -d '{"companyName": "company3", "country": "Denmark", "phoneNumber": "12345678"}' http://localhost:8080/companies/add --verbose
curl -u "admin:123" -X PUT -H "Content-Type: application/json" -d '{"companyName": "company3", "country": "Germany", "phoneNumber": "12345678"}' http://localhost:8080/companies/update --verbose
curl -u "admin:123" -X DELETE http://localhost:8080/companies/delete/company1 --verbose
```

Companies failing scenarios:
```
curl -u "user:123" -X DELETE http://localhost:8080/companies/delete/company1 --verbose
curl -u "admin:123" -X POST -H "Content-Type: application/json" -d '{"companyName": "company1", "country": "Denmark", "phoneNumber": "12345678"}' http://localhost:8080/companies/add --verbose
```

Owners sunshine scenarios: 
```
curl -u "admin:123" http://localhost:8080/owners/list
curl -u "admin:123" http://localhost:8080/owners/get/owner1
curl -u "admin:123" -X POST -H "Content-Type: application/json" -d '{"name": "owner3", "socialSecurityNumber": "101020101234"}' http://localhost:8080/owners/add --verbose
curl -u "admin:123" -X DELETE http://localhost:8080/owners/delete/owner1 --verbose
```


References
https://www.baeldung.com/spring-security-basic-authentication


https://howtodoinjava.com/spring-boot2/security-rest-basic-auth-example/
https://github.com/lokeshgupta1981/Spring-security/tree/master/Spring-security-with-spring-boot

Getting started using:

Spring web application:
https://spring.io/guides/gs/rest-service/#initial
Spring application in docker:
https://spring.io/guides/topicals/spring-boot-docker/

Make mvnw work
```
mvn -N wrapper:wrapper
```

install maven:
https://maven.apache.org/install.html


Simple Spring Api with Auth
https://medium.com/@abhinavv.singh/implementing-user-authentication-in-a-spring-boot-application-a-detailed-step-by-step-guide-b15a9877569b
Spring boot role based auth
https://howtodoinjava.com/spring-security/spring-boot-role-based-authorization/


Spring boot and docker:
https://spring.io/guides/topicals/spring-boot-docker/
Curl with credentials:
https://stackoverflow.com/questions/13048954/how-to-login-to-a-spring-security-login-form-using-curl

securing web app:
https://spring.io/guides/gs/securing-web/
Basic Auth Sping Boot:
https://chanakambkarunarathna.medium.com/basic-authentication-for-springboot-rest-api-application-with-handlerinterceptor-3e2cc4480b9c

Amiya
https://www.geeksforgeeks.org/authentication-and-authorization-in-spring-boot-3-0-with-spring-security/

https://dzone.com/articles/securing-spring-data-rest-with-preauthorize