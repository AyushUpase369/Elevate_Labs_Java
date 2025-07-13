# 📊 Expense Tracker with Monthly Analytics

A simple desktop application built with **Java**, **JavaFX**, **SQLite**, and **JFreeChart** to manage your expenses and visualize monthly analytics.

---

## ✅ Features

- Add expense entries with name, amount, and month.
- Store data locally in an SQLite database.
- View a bar chart of monthly expense totals.
- Clean, minimal JavaFX UI.

---

## 🧱 Tech Stack

- Java (17 or later)
- JavaFX SDK 21+ (GUI)
- SQLite (via `sqlite-jdbc`)
- JFreeChart (for charts)

---

## 📁 Folder Structure

```
Expense_Tracker/
│
├── src/                        # Java source files
│   ├── Main.java
│   ├── DBUtil.java
│   ├── ExpenseDAO.java
│   ├── ExpenseForm.java
│   └── ExpenseChart.java
│
├── lib/                        # External libraries (JARs)
│   ├── sqlite-jdbc-3.36.0.3.jar
│   └── jfreechart-1.5.3.jar
│
├── database/                   # Local SQLite database
│   └── expenses.db
│
├── out/                        # Compiled classes
│
└── README.md
```

---

## 🛠️ Setup Instructions

### 1. ✅ Prerequisites

- Java 17+ installed
- JavaFX SDK (download from [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/))
- VS Code or any editor (optional)

---

### 2. 🔧 Compile the Code

```powershell
$javafxLib = "lib\javafx-sdk-24.0.1\lib"
$sqliteJar = "lib\sqlite-jdbc-3.36.0.3.jar"
$jfreechartJar = "lib\jfreechart-1.5.3.jar"


javac -d out `
--module-path $javafxLib `
--add-modules javafx.controls `
-cp "$sqliteJar" `
src/*.java
```

---

### 3. ▶️ Run the Application

```powershell

java -cp "out;$sqliteJar" `
--module-path $javafxLib `
--add-modules javafx.controls `
--enable-native-access=ALL-UNNAMED `
Main
```

---

## 📦 Notes

- The app creates `expenses.db` inside the `database/` folder.
- If the table does not exist, it's created automatically.
- No internet connection is needed — it's a fully offline app.

---

## 🧑‍💻 Author

**Ayush Upase**  
📧 [Email](mailto:ayushupase369@gmail.com)

---