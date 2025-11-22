# College Management System

A modern, full-stack web application for managing college student information with a beautiful pink-themed UI and 3D interactive elements.

## Features

- 🎓 **Student Registration & Login** - Secure signup and authentication system
- 📊 **Student Dashboard** - Comprehensive profile view with all student details
- 🎨 **Modern UI Design** - Pink-themed interface with 3D icons and animations
- 💾 **MySQL Database** - Persistent data storage for student information
- 📱 **Responsive Design** - Works seamlessly on all devices
- ✨ **3D Interactive Elements** - Engaging user experience with 3D effects

## Technology Stack

- **Backend**: Spring Boot 4.0.0
- **Frontend**: Thymeleaf, HTML5, CSS3, JavaScript
- **Database**: MySQL
- **Build Tool**: Maven
- **Java Version**: 17

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

## Database Configuration

Update `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=your_password
```

## Installation

1. Clone the repository:
```bash
git clone https://github.com/surajsingh121/college-management-system.git
cd college-management-system
```

2. Configure MySQL database in `application.properties`

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

5. Access the application:
```
http://localhost:8080
```

## Project Structure

```
collegeManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/hospital/collegeManagementSystem/
│   │   │       ├── controller/     # Controllers for routing
│   │   │       ├── model/          # Entity models
│   │   │       ├── repository/     # Data access layer
│   │   │       └── service/         # Business logic
│   │   └── resources/
│   │       ├── static/             # CSS, JS, images
│   │       ├── templates/           # Thymeleaf templates
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## Features in Detail

### Student Registration
- Complete student information form
- Email and Student ID uniqueness validation
- Secure password storage
- Automatic enrollment date assignment

### Student Login
- Email and password authentication
- Session management
- Secure dashboard access

### Student Dashboard
- Personal information display
- Academic information
- Account details
- Quick action buttons
- Beautiful 3D card layouts

## UI/UX Features

- **Pink Color Scheme**: Modern pink gradient backgrounds
- **3D Icons**: Interactive Font Awesome icons with 3D effects
- **Smooth Animations**: CSS transitions and transforms
- **Responsive Layout**: Mobile-first design approach
- **Glassmorphism**: Modern glass-like UI elements

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open source and available under the MIT License.

## Author

Suraj Singh

## Contact

For any queries or support, please open an issue on GitHub.

