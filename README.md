## Eureka Server
```http://localhost:8761/```

## API Gateway
```http://localhost:8083/quiz```

## Config Server
```http://sanjayas-mbp.home:8085/application/default```

## User Service
* Use Config Client
* Resilience4J Circuit breaker used for fault tolerance
* ```http://localhost:8091/actuator/health```
* Only Client in set in UserService
* Only from userService hotelService and ratingService API can call
* Couldn't able to directly call the hotelService and ratingService API

## Jmeter for mac
* download and navigate to bin directory
* ./jmeter (run this command in terminal)

## Okta Developer
* ```https://dev-54450627-admin.okta.com/```
