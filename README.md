# 📚 Library Management System

Welcome to the **Library Management System**! This is a Java-based project that simulates the basic functionality of a library system, where admins can manage books and users can borrow them. The project supports admin authentication, book management, user management, and book borrowing with return dates.

---

## 🚀 Features

- **Admin Login/Sign-Up**: Admin can log in and manage books in the library 📚.
- **Book Management**: Add new books, display all available books 📖.
- **User Login/Sign-Up**: Users can register, log in, and borrow books 👤.
- **Borrowing System**: Users can purchase (borrow) books for a limited time 🕰️.
- **Logging**: Utilizes Java's `Logger` for better traceability 📝.
- **Exception Handling**: Custom exceptions for unavailable books ⚠️.

---

## 🛠️ Technologies Used

- **Java**: The core language for this project.
- **Collections**: HashMap, HashSet, etc., for data storage.
- **LocalDate**: For handling issue and return dates of borrowed books.
- **Logging**: For tracking user and admin activities.
- **Custom Exceptions**: For handling book availability issues.

---


   ## 🧑‍💻 Usage

Once you start the application, you'll be prompted with the following options:

### For Admin:
- **Login**: Admin can log in using a username and password.
- **Add Books**: Admin can add new books to the library.
- **Display Books**: Admin can view all books in the library.

### For User:
- **Login**: Users can log in using their credentials.
- **Sign-Up**: New users can create an account.
- **Borrow Books**: Users can borrow books from the library (with issue and return dates).
- **View Borrowed Books**: Users can view the list of books they have borrowed.

---

## ⚡️ Sample Flow

### Admin Flow:
1. **Admin logs in** 👨‍💻.
2. **Admin adds books** to the library 📚.
3. **Admin displays all books** in the library 📖.

### User Flow:
1. **User logs in** 👤.
2. **User browses available books** 📚.
3. **User borrows books** 🕰️ (with issue and return dates).
4. **User views borrowed books** 📖.

---

## 📝 Logging and Tracking

- Activities are logged using Java's `Logger` class 📝.
- Custom exception handling provides clear error messages for book unavailability ⚠️.

## 👥 Contributing

Feel free to fork the repository, make changes, and open a pull request! Contributions are welcome 🙌.
