# **Payment Application**

A secure, user-friendly payment application designed to manage user accounts, handle transactions, and check balances. Built with Angular, Java Spring Boot, and MySQL.

## **Table of Contents**

- Features
- Tech Stack
- Architecture
- Installation
- Usage
- Project Structure
- API Endpoints
- Security
- Future Improvements

### **Features**

- **User Management**: Allows users to sign up, log in, update, and delete accounts.
- **Account Management**: Users can create accounts, view balances, update account information, and delete accounts.
- **Transactions**: Users can transfer money between accounts and check transaction status.

### **Tech Stack**

- **Frontend**: Angular (TypeScript) - Provides the user interface for interacting with the payment application.
- **Backend**: Java Spring Boot - Manages business logic, security, and API endpoints.
- **Database**: MySQL - Stores user, account, and transaction information.
- **Security**: Spring Security (BCrypt encryption) - Protects user credentials and sensitive endpoints.

### **Architecture**

The application follows a client-server architecture:

- **Frontend (Angular)**: Makes HTTP requests to interact with the backend and presents data to users.
- **Backend (Spring Boot)**: Exposes RESTful API endpoints to handle business logic.
- **Database (MySQL)**: Stores all data related to users, accounts, and transactions.

![napkin-selection (3)](https://github.com/user-attachments/assets/1b8cf9b6-0cc6-419a-8068-6d241c04f1b5)
![napkin-selection (4)](https://github.com/user-attachments/assets/f04b82f6-45f1-43cb-a9d0-18ae85363db2)
![napkin-selection (5)](https://github.com/user-attachments/assets/3de0afed-0275-4dd0-a5f9-84a16049704a)

### **Installation**

#### **Prerequisites**

- **Java 17+**
- **Node.js and Angular CLI**
- **MySQL**
- **Maven**

#### **Backend Setup**

**Clone the repository**:  
git clone &lt;repository_url&gt;

cd Project1

1. **Configure MySQL Database**:
    - Create a MySQL database (e.g., payment_db).

Update application.properties in src/main/resources with database credentials:  
properties  
spring.datasource.url=jdbc:mysql://localhost:3306/payment_db

spring.datasource.username=your_mysql_username

spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update

**Build and Run the Application**:  
mvn clean install

mvn spring-boot:run

#### **Frontend Setup**

Navigate to the frontend directory (usually frontend):  
cd frontend

Install dependencies and start the Angular server:  
<br/>npm install

ng serve

1. The frontend will run on <http://localhost:4200>.

### **Usage**

- Access the frontend via <http://localhost:4200>.
- Use Postman or another API client for testing backend APIs directly.

### **Project Structure**

#### **Backend (Spring Boot)**

- **Controllers**: Handles HTTP requests and maps them to specific services.
- **Models**: Defines entities such as User, Account, and Transaction.
- **Services**: Contains business logic for handling user and account-related operations.
- **Repositories**: Interacts with the MySQL database using Spring Data JPA.
- **Config**:

#### **Frontend (Angular)**

- **Components**: UI components for each section (e.g., login, account details).
- **Services**: Handles HTTP requests to the backend API.
- **Routing**: Manages navigation within the application.

### **API Endpoints**

#### **User Management**

- POST /api/payment/users/signup - Sign up a new user
- POST /api/payment/users/login - Log in a user
- GET /api/payment/users - Retrieve all users
- GET /api/payment/users/{id} - Retrieve user by ID
- PUT /api/payment/users/update/{id} - Update user details by ID
- DELETE /api/payment/users/{id} - Delete user by ID

#### **Account Management**

- GET /api/payment/accounts - Retrieve all accounts
- GET /api/payment/accounts/{id} - Retrieve account by ID
- POST /api/payment/accounts/create - Create a new account
- PUT /api/payment/accounts/update/{id} - Update account details by ID
- DELETE /api/payment/accounts/{id} - Delete account by ID
- GET /api/payment/accounts/balance/{id} - Check balance by account ID

#### **Transaction Management**

- GET /api/payment/transactions - Retrieve all transactions
- POST /api/payment/transfer/accountNumber - Transfer funds between accounts

### **Security**

- **Password Encryption**: Uses BCrypt hashing for secure password storage.
- **Spring Security Configuration**: Controls access to specific endpoints.
  - Example: /api/payment/accounts/balance/\*\* is restricted to authenticated users.
- **Cross-Origin Requests**: Configured for development with @CrossOrigin(origins = "<http://localhost:4200>").
- **JWT Authentication**: Replace basic Spring Security with JWT-based authentication for better session management.

### **Future Improvements**

- **Notifications**: Send email/SMS notifications for transaction updates.
- **JWT Authentication**: Replace basic Spring Security with JWT-based authentication for better session management.
- **Enhanced Transaction Logs**: Capture additional metadata (e.g., IP address, transaction history) for audit purposes.
- **Role-Based Access Control**: Differentiate between user roles (e.g., Admin, User).

### **Contributing**

1. Fork the repository.
2. Create a feature branch (git checkout -b feature/feature-name).
3. Commit changes (git commit -m 'Add feature').
4. Push to the branch (git push origin feature/feature-name).
5. Open a pull request.

### **Contact**

[chintavishnupriya45@gmail.com](mailto:chintavishnupriya45@gmail.com)

[udayaudayarr@gmail.com](mailto:udayaudayarr@gmail.com)

[princepanjiyar02@gmail.com](mailto:princepanjiyar02@gmail.com)
