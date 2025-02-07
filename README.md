# Getting Started
## Employee API

This API provides a set of endpoints to manage employee data. It allows you to perform basic CRUD (Create, Read, Update, Delete) operations on employee records, as well as retrieve employee information based on various criteria.

### Prerequisites
- Java JDK: Ensure you have the Java Development Kit (JDK) installed on your system. You can verify if Java is installed by opening a terminal or command prompt and running the command java -version. If you don't have Java installed, you can download it from the Oracle website or adopt an OpenJDK distribution.

- Maven: You need to have Maven installed. If you don't have it, you can download and install it from the official Apache Maven website.

- IDE (Optional): While not strictly necessary, an Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse can make development much easier.

### Steps
- Obtain the project code:

    Download code from github:
    
    ```bash
    git clone <repository-url>
  ```

- Import the project into your IDE (optional):

    If you're using an IDE, import the Maven project. This will allow you to navigate the code, edit it, and run it from the IDE.

- Build the project with Maven:

  Open a terminal or command prompt and navigate to the project's root directory.

  Run the command `mvn clean package` to clean the project, compile the code, run the tests, and package it into an executable JAR file.

- Run the service

  Once the build is successful, a JAR file will be created in the target directory.

  Run the service with the command `java -jar target/your-service-file.jar` (replace your-service-file.jar with the actual name of the JAR file).

- Access the service:

  Access Swagger documentation: [SWAGGER](localhost:8080/swagger-ui-employees.html)

### API Endpoints

#### 1. Get All Employees

*   **Endpoint:** `GET /employees`
*   **Description:** Retrieves a list of all employees.
*   **Response:**

    ```json
    [
      {
        "id": 1,
        "firstName": "Laura",
        "secondName": "Sofía",
        "firstLastName": "Fernández",
        "secondLastName": "Gómez",
        "age": "29",
        "gender": "FEMALE",
        "birthDate": "18-03-1994",
        "position": "Contadora"
      },
      {
        "id": 2,
        "firstName": "Miguel",
        "secondName": "Ángel",
        "firstLastName": "Sánchez",
        "secondLastName": "Díaz",
        "age": "52",
        "gender": "MALE",
        "birthDate": "05-06-1971",
        "position": "Abogado"
      },
      // ... more employees
    ]
    ```

#### 2. Create a New Employee

*   **Endpoint:** `POST /employees`
*   **Description:** Creates a new employee record.
*   **Request Body:**

    ```json
    [
      {
      "firstName": "Ana",
      "secondName": "María",
      "firstLastName": "García",
      "secondLastName": "Pérez",
      "age": "32",
      "gender": "FEMALE",
      "birthDate": "10-05-1991",
      "position": "Desarrolladora Web"
      },
      {
      "firstName": "Carlos",
      "secondName": null,
      "firstLastName": "López",
      "secondLastName": "Rodríguez",
      "age": "45",
      "gender": "MALE",
      "birthDate": "25-11-1978",
      "position": "Gerente de Proyecto"
      },
      // ... more employees
    ]
    ```

*   **Response:**

    ```json
    {
      "id": 3,
      "firstName": "Peter",
      "lastName": "Jones",
      "age": 35,
      "position": "Project Manager"
    }
    ```

#### 3. Update an Existing Employee

*   **Endpoint:** `PUT /employees/{id}`
*   **Description:** Updates an existing employee record.
*   **Request Body:**

    ```json
    {
      "id": 13,
      "firstName": "Ana",
      "secondName": "Sofi",
      "firstLastName": "García",
      "secondLastName": "Pérez",
      "age": "32",
      "gender": "FEMALE",
      "birthDate": "10-05-1991",
      "position": "Desarrolladora Web"
    }
    ```

*   **Response:**

    ```json
    {
      "id": 3,
      "firstName": "Robert",
      "lastName": "Jones",
      "age": 40,
      "position": "Senior Project Manager"
    }
    ```

#### 4. Delete an Employee

*   **Endpoint:** `DELETE /employees/{id}`
*   **Description:** Deletes an employee record.
*   **Response:** (No content)

### Error Handling

The API returns appropriate HTTP status codes to indicate the success or failure of a request. In case of an error, the response body may contain additional details about the error.
