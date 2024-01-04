
# MyLite - Learning Database Management with Java Swing

MyLite is a simple Java Swing application developed for educational purposes to gain hands-on experience in database management, query execution, and user authentication. This project utilizes Java, Java Swing (JSwing), and a MySQL database to create a basic GUI application with user authentication functionality.


## Setup Instructions
### Prerequisites
    1. Java Development Kit (JDK): Ensure you have JDK installed on your system. You can download it from Oracle's website.

    2. MySQL Database: Install MySQL on your machine and create a new database for MyLite. Make sure to have an authorized username and password to access the database.

    3. Download JDBC to your machine and add it to the build path for whichever IDE you run this on.
### Database Setup
    1. Create a new MySQL database for MyLite: CREATE DATABASE mylite;
    2. Create a user table with the specified columns:
        USE mylite;

        CREATE TABLE users (
            userEmail VARCHAR(255) PRIMARY KEY,
            userPassword VARCHAR(255),
            userName VARCHAR(255),
            userPhone VARCHAR(20),
            userAddress VARCHAR(255)
        );


## Installation

1. Clone the MyLite repository to your local machine: ```git clone https://github.com/ikediufomadu/MyLite.git```
2. Open the project in your preferred Java IDE.
3. Provide the necessary database credentials in the Login.java file:
    ```final String databaseName = "mylite";
        final String DB_URL = "jdbc:mysql://localhost:3306/" + databaseName;
        final String USERNAME = "your_username";
        final String PASSWORD = "your_password";
    ```
4. Build and run the application.
5. The GUI will prompt you to log in using an email and password registered in the database.
## Table Structure
The user table in the MySQL database should have the following structure:
```
CREATE TABLE users (
    userEmail VARCHAR(255) PRIMARY KEY,
    userPassword VARCHAR(255),
    userName VARCHAR(255),
    userPhone VARCHAR(20),
    userAddress VARCHAR(255)
);
```

The table has five columns:
* userEmail: Email address of the user (Primary Key).
* userPassword: Password associated with the user.
* userName: User's name.
* userPhone: User's phone number.
* userAddress: User's address.
Feel free to customize the table structure based on your application requirements.

## Disclaimer
MyLite is a learning project and may not adhere to all security best practices. It is recommended not to use real or sensitive information in the application.