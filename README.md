# Authentication-Utility-SHA512-And-Salt-JAVA

This project Aims to provide utility to people looking
to implement a secure authentication system in their project or application. We provide simple
wrapper functions “AddUser(username, password)” and “VerifyUser(username, password)” just
like an API. We take peoples username and password as an input, and generate a random string
of 20 bytes long which will be added to user’s password and then a hash value of that total string
would be generated using Secure Hashing Algorithm which is 512 bits long then will be stored
on our database.

We do not store users password in our database, we calculate users passwords and salt hashes on
the fly and match them with our own stored in database to authenticate them, This is why SHA
is secure. Moreover Users with the same password don't really have the same passwords
internally since salt generated is random.

## How to use
Look into src/authentication.java file. It contains example. Call following functions in your project.
- AddUser(username, password) : to add user in database
- VerifyUser(username, password) : to verify if user is logging in with correct password or not

## Dependencies
### Technologies used
- Eclipse IDE
- SHA-512
- JAVA 17.0.1
- Oracle database SQL*Plus 21c
- JDBC (ojdbc11.jar)

### JAVA libraries and APIs
- In file hashing.java
  - java.math.BigInteger
  - java.security.MessageDigest
  - java.security.NoSuchAlgorithmException
  - java.security.SecureRandom

- In file addUser.java & verifyUser.java
  - java.sql.Connection
  - java.sql.DriverManager
  - java.sql.PreparedStatement
  - java.sql.ResultSet
  - java.sql.Statement
