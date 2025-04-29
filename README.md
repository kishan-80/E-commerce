
# Ecommerce Web Application

A simple Spring Boot based RESTful web application for an Ecommerce system where users can register/login, browse products by category, and place orders. Admins can add products to the system.

---

## Features

- User Registration & Login
- Product Listing (All or by Category)
- Place Order with multiple items
- View Order History by User
- Admin Product Management

---

## Tech Stack

- **Backend:** Java, Spring Boot
- **Database:** MySQL (or H2 for testing)
- **Frameworks:** Spring MVC, Spring Data JPA
- **Build Tool:** Maven
- **Others:** Hibernate, Lombok (optional)

---

## Requirements

- Java 17 or later  
- Maven  
- MySQL database  
- IDE: IntelliJ IDEA / Eclipse / VS Code  
- Postman for API testing (optional)

---

## Project Setup & Run Instructions

### Step 1: Clone the Repository
```bash
git clone https://github.com/your-username/ecommerce-springboot.git
cd ecommerce-springboot
```

### Step 2: Configure Database

Update `application.properties` with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Step 3: Build the Project
```bash
mvn clean install
```

### Step 4: Run the Application
```bash
mvn spring-boot:run
```

Application runs at: `http://localhost:8080`

---

## API Endpoints

### User APIs
| Method | Endpoint                        | Description               |
|--------|----------------------------------|---------------------------|
| POST   | `/api/user/register`            | Register a new user       |
| POST   | `/api/user/login`               | Login with email/password |
| GET    | `/api/user/getAllUser`          | Get all users             |

###  Product APIs
| Method | Endpoint                        | Description                   |
|--------|----------------------------------|-------------------------------|
| GET    | `/api/product/getAllProduct`    | List all products             |
| GET    | `/api/product/getProductByCategory?category={name}` | Products by category |
| POST   | `/api/product/addProduct`       | Add a new product (admin)     |

###  Order APIs
| Method | Endpoint                        | Description                         |
|--------|----------------------------------|-------------------------------------|
| POST   | `/api/order/placeOrder/{userId}`| Place an order                      |
| GET    | `/api/order/getOrdersByUserId/{userId}` | Get all orders of a user     |

---


##  Folder Structure

```
src/
├── main/
│   ├── java/com/webApp/Ecommerce/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── repository/
│   │   ├── service/
│   ├── resources/
│       ├── application.properties
```

---

## Future Improvements

- Add JWT authentication for secure login
- Role-based access (Admin/User)
- Frontend (React/Angular)
- Dockerize the app

---
