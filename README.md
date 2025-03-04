API Automation Testing with RestAssured 

This project is an API automation framework using **RestAssured** and **TestNG** to validate API requests and responses.

Features: 
- REST API Testing using **RestAssured**  
- Test execution & reporting with **TestNG**  
- Dependency management using **Maven**  
- Structured approach with **ConfigReader** for configuration  
- Error handling and validation for API responses  

---

**Setup & Installation**

Prerequisites  
Ensure you have the following installed:
- Java 
- Eclipse 
- Maven  
- Git  

 Clone the Repository  
Run the following command to clone the project: git clone https://github.com/youssefyasser98/API-Automation.git cd API-Automation


Open in Eclipse  
1. Open **Eclipse**  
2. Click **File > Import > Existing Maven Projects**  
3. Select the cloned **API-Automation** folder  
4. Click **Finish**  

 Install Dependencies  
Run the following command to download dependencies: mvn clean install

 Run Tests  
To execute the test cases, use:


---

Test Scenarios Covered
- Create a User** (POST `/api/users`)  
- Retrieve a User** (GET `/api/users/{id}`)  
- Update a User** (PUT `/api/users/{id}`)  

Each test validates the response and ensures the API works correctly.




