
# Java JDBC CRUD Console Application

This is a simple console-based Java application that demonstrates **CRUD operations** (Create, Read, Update, Delete) using **MySQL** and **JDBC**.

---

## 📌 Features

- Create (Add) new users
- Read (View) all users
- Update existing users
- Delete users
- Automatically creates the table if not exists

---

## 🛠️ Technologies Used

- Java (JDK 17 or higher recommended)
- JDBC (Java Database Connectivity)
- MySQL (Tested with MySQL 8+)

---

## 🔧 Database Configuration

Make sure you have a **MySQL database** running and update the credentials in the code:

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
private static final String USER = "root";
private static final String PASS = "@yus#369";
```

Create the database manually before running the app:

```sql
CREATE DATABASE testdb;
```

---

## 🚀 How to Run

1. Clone this repository or copy the code into your IDE.
2. Make sure MySQL is running.
3. Set your database credentials.
4. Compile and run the program:

```Terminal/powershell
javac -cp ".;mysql-connector-j-9.3.0.jar" CrudApp.java
java -cp ".;mysql-connector-j-9.3.0.jar" CrudApp.java
```

---

## 📋 Sample Output

```
****** Operations in Database ******
1. Add  2. View  3. Update  4. Delete  5. Exit
Choose option: 1
Enter name: Rahul
Enter email: Rahul@gmail.com
User added.
```