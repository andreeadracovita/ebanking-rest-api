# Spring REST API for eBanking Application
This is a Spring REST API for an eBanking Application.

## Database
Hibernate is used to save Java objects in the relational database system.

![alt text](https://github.com/andreeadracovita/ebanking-rest-api/blob/main/src/main/resources/static/dbdiagram.png?raw=true)

## CRUD
The consumer of the REST API can create, update and delete information, as well as retrieve information from the database.

## Security
Spring Security is used for authentication and authorization of the requests.

JWT (JSON Web Token) Authentication is used for authenticating users.

There are currently two unauthenticated requests:
- Login
- Create user

All other requests require authentication and authorization.
Pre-authorization is required in order to complete a request:
```txt
@PreAuthorize("#username == authentication.name")
```

## Customer Resource
Retrieve customer name for given username
```
GET /{username}/customername
```

## EbankingUser Resource
Create a new user account and a customer if not already existing
```
POST /users/create
```
```
{
    "firstName": "First",
    "lastName": "Last",
    "OASI": "1234512345123",
    "username": "FirstLast",
    "passcode": "12345"
}
```

Check if payload username is valid
```
POST /users/username
```
```
{
    "usernameToCheck": "FirstLast"
}
```

Update user account passcode
```
PUT /{username}/passcode
```
```
{
    "passcode": "12345"
}
```

## BankAccount Resource
Retrieve all bank accounts for a given username
```
GET /{username}/accounts
```

Retrieve all checking bank account for a given username
```
GET /{username}/accounts/checking
```

Retrieve all credit bank accounts for a given username
```
GET /{username}/accounts/credit
```

Retrieve all savings bank accounts for a given username
```
GET /{username}/accounts/savings
```

Retrieve all bank accounts with local currency (CHF) for a given username
```
GET /{username}/accounts/local
```

Retrieve all local checking bank accounts for a given username
```
GET /{username}/accounts/checking/local
```

Retrieve all foreign currency (non-CHF) bank accounts for a given username
```
GET /{username}/accounts/foreign
```

Retrieve all paying bank accounts (checking or credit) for a given username
```
GET /{username}/accounts/paying
```

Create a checking bank account with a given currency
```
POST /{username}/account/checking/{currency}
```

Create a savings bank account
```
POST /{username}/account/savings
```

Create a credit bank account
```
POST /{username}/account/credit
```

Delete a bank account
```
DELETE /{username}/accounts/{accountNumber}
```

Update a bank account's name
```
PUT /{username}/accounts/{accountNumber}
```
```
{
    "name": "EUR Account"
}
```

## Card Resource
Retrieve all cards for a given username
```
GET /{username}/cards
```

Retrieve formatted availability date for a given card number
```
GET /{username}/cards/{id}/availabilityDate
```

Create a virtual card for a given bank account number
```
POST /{username}/card/{accountNumber}
```

Activate a card
```
PUT /{username}/cards/{id}/activate
```

Deactivate a card
```
PUT /{username}/cards/{id}/deactivate
```

## Transaction Resource
Retrieve all transactions for a given bank account number
```
GET /{username}/{bankAccountNumber}/transactions
```

Create a transaction
```
POST /{username}/transaction/{source}
```
```
{
    "id": -1,
    "fromAccountNumber": "CH0100001950667791080",
    "toAccountNumber": "CH0100001950667791081",
    "beneficiaryName": "First Last",
    "amount": 10.00,
    "currency": 0,
    "description": ""
}
```

## Further development
- Code duplication in requests can be decreased, as well as unifying multiple requests under the same mapping.
- Further research needs to be made regarding Hibernate and generating tables using @Entity annotation. In particular, join columns needs to be further improved not to exposes data. The whole customer entity is returned instead of only customer_id.
