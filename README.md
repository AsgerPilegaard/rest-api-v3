# How to initiate the Rest API
Execute the following commands in a terminal with the project root as your current directory. 
1. Create the executable JAR file using maven.
```
./mvnw clean install
```

2. Build the docker image.
```
docker build -t company-api .
```

3. Run the docker image and host it on port 8080.
```
docker run -p 8080:8080 company-api
```

## Debugging initiation
1. If *maven install* does not work, ensure that maven is [installed](https://maven.apache.org/install.html) and ensure maven wrapper is configured correctly by running
```
mvn -N wrapper:wrapper
```

2. If *docker build* does not work, ensure that you have a docker engine [installed](https://docs.docker.com/engine/install/) and that the engine is running.

3. If *docker run* does not work and the error states that the port is used. Verify that your IDE is not running the application on the port and that no other container already uses the port: 
```
docker ps
docker stop <container-id>
```


# Query the Rest API
## Companies sunshine scenarios:
```
curl -u "user:123" http://localhost:8080/companies/list
curl -u "user:123" http://localhost:8080/companies/get/company1
curl -u "admin:123" -X POST -H "Content-Type: application/json" -d '{"companyName": "company3", "country": "Denmark", "phoneNumber": "12345678"}' http://localhost:8080/companies/add --verbose
curl -u "admin:123" -X PUT -H "Content-Type: application/json" -d '{"companyName": "company3", "country": "Germany", "phoneNumber": "12345678"}' http://localhost:8080/companies/update --verbose
curl -u "admin:123" -X DELETE http://localhost:8080/companies/delete/company1 --verbose
```

## Companies failing scenarios:
```
curl -u "user:123" -X DELETE http://localhost:8080/companies/delete/company1 --verbose
curl -u "admin:123" -X POST -H "Content-Type: application/json" -d '{"companyName": "company1", "country": "Denmark", "phoneNumber": "12345678"}' http://localhost:8080/companies/add --verbose
```

## Owners sunshine scenarios: 
```
curl -u "admin:123" http://localhost:8080/owners/list
curl -u "admin:123" http://localhost:8080/owners/get/owner1
curl -u "admin:123" -X POST -H "Content-Type: application/json" -d '{"name": "owner3", "socialSecurityNumber": "101020101234"}' http://localhost:8080/owners/add --verbose
curl -u "admin:123" -X DELETE http://localhost:8080/owners/delete/owner1 --verbose
```