Command Query Responsibility Segregation (CQRS) Example

EndPoints
---------

1. `http://localhost:8081/doc/download/Salary/1 [GET]`

This will download file content from DB using MyBATIS (QUERY)

`[
    {
        "employeeID": 83,
        "amount": 49000,
        "docID": 1
    },
    {
        "employeeID": 97,
        "amount": 48000,
        "docID": 1
    },
    {
        "employeeID": 30,
        "amount": 40,
        "docID": 1
    }
]`

2. `http://localhost:8081/doc/upload/Salary [POST]`

This will upload CSV (Multipart file) to DB using JPA (COMMAND)

Please find relevant SQL files(procedure and tables) and CSV file(salaries.sql) from project root.
