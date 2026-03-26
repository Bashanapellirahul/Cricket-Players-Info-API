Cricket Players Info API

A Spring Boot REST API to manage and retrieve cricket player statistics for both men and women.
This project demonstrates backend best practices including validation, DTO mapping, JPA, and clean architecture.

⸻

FEATURES
	•	Create player profiles
	•	Fetch all players
	•	Search player by name (case-insensitive)
	•	Filter players by:
	•	Gender
	•	Role (Batsman, Bowler, etc.)
	•	Country
	•	Calculate batting average automatically
	•	Custom validation for business rules
	•	Clean DTO → Entity → Response mapping

⸻

TECH STACK
	•	Java 21
	•	Spring Boot
	•	Spring Data JPA
	•	MySQL
	•	Hibernate
	•	Lombok
	•	Maven
	•	Swagger (OpenAPI)

⸻

PROJECT STRUCTURE

src/main/java/com/CricketersInfo

controller        → REST Controllers
service           → Business logic
repository        → JPA repositories
model             → Entity classes
dto               → Request & Response classes
validation        → Custom validators

⸻

ENTITY FIELDS

playerName
playerAge
country
gender (ENUM)
role (ENUM)
matchType (ENUM)
matches
innings
totalRuns
notOuts
playerAverage
highestScore
noOf4s
noOf6s
createdAt
updatedAt

⸻

BUSINESS LOGIC

Batting Average = Total Runs / (Innings - Not Outs)

⸻

CUSTOM VALIDATION

Rule:
Innings must be less than matches

Implemented using:
@ValidMatchInnings

⸻

API ENDPOINTS
	1.	Create Player
POST /api/players

Request Body:
{
“playerName”: “Virat Kohli”,
“playerAge”: 35,
“country”: “India”,
“gender”: “MEN”,
“role”: “BATSMAN”,
“matchType”: “ODI”,
“matches”: 250,
“innings”: 240,
“totalRuns”: 12000,
“notOuts”: 30,
“highestScore”: 183,
“noOf4s”: 1100,
“noOf6s”: 150
}

⸻

	2.	Get All Players
GET /api/players

⸻

	3.	Get Player by Name
GET /api/players/name?name=virat

⸻

	4.	Filter by Gender
GET /api/players/gender?gender=MEN

⸻

	5.	Filter by Role
GET /api/players/role?role=BATSMAN

⸻

	6.	Filter by Country
GET /api/players/country?country=India

⸻

VALIDATION RULES
	•	Matches must be greater than innings
	•	Enums must match exactly:
MEN, WOMEN
BATSMAN, BOWLER, etc.

⸻

DATABASE DESIGN
	•	Single table for all players
	•	Enums used for:
Gender
Role
Match Type
	•	Lists handled using JPA collections if needed

⸻

SWAGGER UI

http://localhost:8080/swagger-ui/index.html

⸻

SETUP INSTRUCTIONS
	1.	Clone Repository

git clone

⸻

	2.	Configure Database (application.properties)

spring.datasource.url=jdbc:mysql://localhost:3306/cricket_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

⸻

	3.	Run Application

mvn spring-boot:run

⸻

FUTURE ENHANCEMENTS
	•	JWT Authentication
	•	Pagination & Sorting
	•	Advanced filtering
	•	Caching (Redis)
	•	Role-based access control

⸻

KEY LEARNINGS
	•	DTO vs Entity separation
	•	JPA and database mapping
	•	Custom validation in Spring Boot
	•	Enum usage for controlled values
	•	Clean architecture design

⸻

AUTHOR

Rahul Bashanapelli
QA Engineer → Backend Developer
