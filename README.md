# Getting Started
## Employee API

This API provides a set of endpoints to manage employee data. It allows you to perform basic CRUD (Create, Read, Update, Delete) operations on employee records, as well as retrieve employee information based on various criteria.

### Prerequisites
- Java JDK: Ensure you have the Java Development Kit (JDK) installed on your system. You can verify if Java is installed by opening a terminal or command prompt and running the command java -version. If you don't have Java installed, you can download it from the Oracle website or adopt an OpenJDK distribution.

- Maven: You need to have Maven installed. If you don't have it, you can download and install it from the official Apache Maven website.

- IDE (Optional): While not strictly necessary, an Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse can make development much easier.

- Docker

### Steps

**Obtain the project code:**

Download code from github:
    
```bash
    git clone <repository-url>
```

**Import the project into your IDE (optional):**

- If you're using an IDE, import the Maven project. This will allow you to navigate the code, edit it, and run it from the IDE.

- Build the project with Maven:

  Open a terminal or command prompt and navigate to the project's root directory.

  Run the command `mvn clean package -P dev` to clean the project, compile the code, run the tests, and package it into an executable JAR file.

- Run the service

  Once the build is successful, a JAR file will be created in the target directory.

  Run the service with the command `java -jar target/emploees-0.0.1-SNAPSHOT.jar`.


**Build the project with Docker:**

  - Open a terminal or command prompt and navigate to the project's root directory.

  - Run the command `docker pull postgres:latest` to download the latest postgres image.
    
  - Run the command `docker pull openjdk:17-jdk` to download openjdk image.

    ![docker-images](/evidences/docker_images.png)

  - Run the command `docker compose -f ./docker-compose.yaml up --build` to build and deploy services.
    ![docker-images](/evidences/docker_containers.png)

**Try the service:** 

You can try the service in two ways

  - In this folder, you have a Postman collection `EmployeeCollection.postman_collection.json`, you can copy it and import it to the Postman application. 
  - Accessing Swagger documentation: [SWAGGER](http://localhost:8080/v1/swagger-ui/index.html)

![swagger](/evidences/swagger.png)

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
        "job": "Contadora"
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
        "job": "Abogado"
      },
      // ... more employees
    ]
    ```
    
**Evidence**

![get-all-employees](/evidences/get_all_employees.png)

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
      "job": "Desarrolladora Web"
      },
      {
      "firstName": "Carlos",
      "secondName": null,
      "firstLastName": "López",
      "secondLastName": "Rodríguez",
      "age": "45",
      "gender": "MALE",
      "birthDate": "25-11-1978",
      "job": "Gerente de Proyecto"
      },
      // ... more employees
    ]
    ```
    
**Evidence**
![save-employees](/evidences/save_employees.png)

#### 3. Update an Existing Employee

*   **Endpoint:** `PUT /employees/{id}`
*   **Description:** Updates an existing employee record.
*   **Request Body:**

    ```json
    {
      "firstName": "Miguel",
      "secondName": "Luis",
      "firstLastName": "Sánchez",
      "secondLastName": "Díaz",
      "age": 52,
      "gender": "MALE",
      "birthDate": "05-06-1971",
      "job": "Abogado"
    }
    ```

*   **Response:**

    ```json
    {
      "id": 2,
      "firstName": "Miguel",
      "secondName": "Luis",
      "firstLastName": "Sánchez",
      "secondLastName": "Díaz",
      "age": 52,
      "gender": "MALE",
      "birthDate": "05-06-1971",
      "job": "Abogado"
    }
    ```

**Evidence**
![update-employees](/evidences/update_employee.png)

#### 4. Delete an Employee

*   **Endpoint:** `DELETE /employees/{id}`
*   **Description:** Deletes an employee record.
*   **Response:** (No content)

**Evidence**
![save-employees](/evidences/delete_employee.png)

### Error Handling

The API returns appropriate HTTP status codes to indicate the success or failure of a request. In case of an error, the response body may contain additional details about the error.
