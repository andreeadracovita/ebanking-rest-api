# Spring REST API for eBanking Application
This is a Spring REST API for an eBanking Application.

## Database
Hibernate is used to save Java objects in the relational database system.

![alt text](https://github.com/andreeadracovita/ebanking-rest-api/blob/main/src/main/resources/static/DatabaseDiagram.png?raw=true)

## CRUD
The consumer of the REST API can create, update and delete information, as well as retrieve information from the database.

### Get Requests
	`GET /{username}/customername/{id}`

## Security
Spring Security is used for authentication and authorization of the requests.

JWT (JSON Web Token) Authentication is used for authenticating users.

There are currently two unauthenticated requests:
- Login
- Create user

All other requests require authentication and authorization.
Pre-authorization is required in order to complete a request:
	`@PreAuthorize("#username == authentication.name")`