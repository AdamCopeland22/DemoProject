# DemoProject
Pull project into intilj, start up spring by running main in DemoApplication.class. Run requests. 
I built an api to do add people and addresses it runs with requests at the moment you can run them through the browser, curl or postman.
I did manual testing because I wanted to set up a web page and have some selenium tests to test the api but I didnt have time to do so.
I faked the Dao so you didnt need to set up any database and to make it eaiser to run. The data isnt persistent and will be distroyed after spring is shutdown.

###### Adding a person
POST localhost:8080/api/v1/person
Body 
{
    "firstName": "Jon",
    "lastName": "Doe"
}

###### List all people
GET localhost:8080/api/v1/person/

###### Edit person
1. GET localhost:8080/api/v1/person/
2. Look for Id of person you want to delete. 
3. PUT localhost:8080/api/v1/person/"Id of person to update"
Body
{
    "firstName": "Dave",
    "lastName": "Doe"
}

###### Delete person
1. GET localhost:8080/api/v1/person/
2. Look for Id of person you want to delete. 
3. DELETE localhost:8080/api/v1/person/"Id of person to delete"

###### Adding an address
1. GET localhost:8080/api/v1/person
2. Look for Id of persons. 
3. POST localhost:8080/api/v1/address
Body
{
    "id": "UUID of person whos attached to the address.",
    "streetstreet": "22",
    "city": "Limerick",
    "state": "Munster",
    "postalCode": "AAAAAA"
}

###### Edit Address
Full discloser this does not work fully I should have added another param for postcode to distingish between addresses and same for delete address just too late to fix it right now. 
1. PUT localhost:8080/api/v1/address/"Id"
Body 
{
   "id": "UUID of person whos attached to the address.",
    "streetstreet": "22",
    "city": "Cork",
    "state": "Munster",
    "postalCode": "AAAAAA"
}

###### Delete Address
I should have added another param for postcode to distingish between addresses. 
DELETE localhost:8080/api/v1/address/"Id"


