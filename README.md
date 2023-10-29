Create the executable JAR file using maven.
```
./mvnw clean install
```

Build the docker image.
```
docker build -t company-api .
```

Run the docker image and host it on port 8080.
```
docker run -p 8080:8080 company-api
```

Curl the running api.
Companies sunshine scenarios:
```
curl -u "user:123" -X GET http://localhost:8080/companies/list
curl -u "user:123" -X GET http://localhost:8080/companies/get/company1
curl -u "admin:123" -X POST -H "Content-Type: application/json" -d '{"companyName": "company3", "country": "Denmark", "phoneNumber": "12345678"}' http://localhost:8080/companies/add --verbose
curl -u "admin:123" -X PUT -H "Content-Type: application/json" -d '{"companyName": "company3", "country": "Germany", "phoneNumber": "12345678"}' http://localhost:8080/companies/update --verbose
curl -u "admin:123" -X DELETE http://localhost:8080/companies/delete/company1 --verbose
```

Companies failing scenarios:
```
curl -u "user:123" -X DELETE http://localhost:8080/companies/delete/company1 --verbose
curl -u "admin:123" -X POST -H "Content-Type: application/json" -d '{"companyName": "company2", "country": "Denmark", "phoneNumber": "12345678"}' http://localhost:8080/companies/add --verbose
```

Owners sunshine scenarios: 
```
curl -u "admin:123" -X GET http://localhost:8080/owners/list
curl -u "admin:123" -X GET http://localhost:8080/owners/get/owner1
curl -u "admin:123" -X POST -H "Content-Type: application/json" -d '{"name": "owner3", "socialSecurityNumber": "101020101234"}' http://localhost:8080/owners/add --verbose
curl -u "admin:123" -X DELETE http://localhost:8080/owners/delete/owner1 --verbose
```

Owners failing scenarios:
```
curl -u "user:123" -X GET http://localhost:8080/owners/get/owner1
```