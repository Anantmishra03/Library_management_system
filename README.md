# 📚 Library Management System (JSP)

A web-based Library Management System developed using JavaServer Pages (JSP). This project enables librarians to manage books, students, and transactions like issuing and returning books. It features a simple and user-friendly interface and ensures smooth library operations.

---

## 🔧 Technologies Used

- **Frontend:** HTML, CSS, JSP
- **Backend:** Java (Servlets, JSP)
- **Database:** MySQL
- **Server:** Apache Tomcat

---

## ✨ Features

- 🔐 Admin login/logout
- 🏠 Home dashboard with navigation
- ➕ Add new books to the library
- ➕ Register new students
- 📖 Issue books to students
- 🔄 Return books
- 📊 View statistics (e.g., number of books issued/returned)

---

## 📁 Project Structure

📁 library-management-jsp/
├── home.jsp # Admin dashboard
├── login.jsp # Login page
├── logout.jsp # Logout logic
├── newBook.jsp # Add a new book
├── newStudent.jsp # Register a new student
├── issueBook.jsp # Issue a book
├── returnBook.jsp # Return an issued book
├── statistics.jsp # View usage statistics


---

## 🚀 Getting Started

### 1. Clone the Repository

git clone https://github.com/Anantmishra03/Library_management_system

2. Setup the Database
Create a MySQL database (e.g., library_db)

Use the following schema as a starting point:

CREATE TABLE books (
  book_id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100),
  author VARCHAR(100),
  publisher VARCHAR(100),
  quantity INT
);

CREATE TABLE students (
  student_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  department VARCHAR(100),
  year INT,
  contact VARCHAR(15)
);

CREATE TABLE issue_books (
  issue_id INT AUTO_INCREMENT PRIMARY KEY,
  book_id INT,
  student_id INT,
  issue_date DATE,
  FOREIGN KEY (book_id) REFERENCES books(book_id),
  FOREIGN KEY (student_id) REFERENCES students(student_id)
);

CREATE TABLE return_books (
  return_id INT AUTO_INCREMENT PRIMARY KEY,
  issue_id INT,
  return_date DATE,
  FOREIGN KEY (issue_id) REFERENCES issue_books(issue_id)
);

3. Configure Database Connection
Update your database configuration file (DBConnection.java or wherever you're managing connections) with your MySQL credentials.

String url = "jdbc:mysql://localhost:3306/library_db";
String user = "your-username";
String password = "your-password";

4. Deploy the Project
Import the project into Eclipse or IntelliJ
Add the project to Apache Tomcat server
Run the server

5. Access the Application
Open your browser and go to:

http://localhost:8080/library-management-jsp/login.jsp


📸 Screenshots (optional)
Screenshots of login, dashboard, issue book pages, etc.
<img width="1268" height="657" alt="Screenshot 2025-08-01 223620" src="https://github.com/user-attachments/assets/faed8111-59ec-4ae4-a455-470fc9f7e2c2" />
<img width="1886" height="851" alt="Screenshot 2025-08-01 222938" src="https://github.com/user-attachments/assets/352c7293-b7d5-4452-8353-c5c2f64ebed2" />
<img width="1798" height="833" alt="Screenshot 2025-08-01 223155" src="https://github.com/user-attachments/assets/3b99100f-0b40-4b2b-87cb-bf35db63c8bd" />
<img width="1898" height="863" alt="Screenshot 2025-08-01 222843" src="https://github.com/user-attachments/assets/c43d09bc-8b9c-48eb-a91d-01222dda8236" />
<img width="1379" height="788" alt="Screenshot 2025-08-01 223459" src="https://github.com/user-attachments/assets/e812ef06-33b2-4c56-b489-173754561d26" />
<img width="1213" height="767" alt="Screenshot 2025-08-01 223512" src="https://github.com/user-attachments/assets/7e5ecaa2-557f-451f-9a3f-9430bd1c331c" />
<img width="1484" height="846" alt="Screenshot 2025-08-01 223529" src="https://github.com/user-attachments/assets/742ff50c-e149-474b-a65a-70ea3020d82d" />




👤 Author
Anant mishra

GitHub: @Anantmishra03

Email: anant3380@gmail.com

📄 License
This project is licensed under the MIT License - see the LICENSE file for details.

🙌 Acknowledgments
JSP & Servlet Tutorials by Oracle
Stack Overflow & Open Source contributors
MySQL Documentation
