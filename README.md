# SampleService
This is a simple Spring Boot project.

There are three basic entities:

Person
id
name
lastName
address
cellphone
cityName
name and lastName combination is unique
Position
id
name
Employee
id
person: a foreign key to a person
position: a foreign key to a position
salary
Relationship between Person and Employee is one to one

Relationship between Position and Employee is one to many

Ids for all entities are generated automatically

REST Services
GET /employees
Gets all the employees if no parameter is set.
If param name is set, gets all the employees with the same name

If param position is set, gets all the employees with the same position

GET /employees/{id}
Gets the data of the employee identifies with id
GET /employeesByPosition
Gets all the employees grouped by position, ordered by salary from high to low
POST /employees
Saves an employee
PUT /employees/{id}
Updates the employee identifies with id.
DELETE /employees/{id}
Deletes the employee identifies with id.
GET /people
Gets all the records of entity Person
GET /people/{id}
Gets the data of the person identifies with id
POST /people
Saves a person
PUT /people/{id}
Updates the person identifies with id.
DELETE /people/{id}
Deletes the person identifies with id.
GET /positions
Gets all the records of entity Position
GET /positions/{id}
Gets the data of the position identifies with id
POST /positions
Saves a position
PUT /positions/{id}
Updates the position identifies with id.
DELETE /positions/{id}
Deletes the position identifies with id.
