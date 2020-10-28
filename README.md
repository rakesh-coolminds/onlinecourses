#  Online Learning Portal
It is an online learning portal that will offer pocket friendly, advanced courses to students.

## REST API Endpoints

```
  GET online-courses/{country_code}/courses/{course_id} - View courses by id
  
  Sample Response :
  {
	"course_id": 1,
	"name": "Spring boot",
	"description": "Beginers guide to spring boot",
	"duration_in_months": 2,
	"price_strategies": [
		{
			"id": 1,
			"name": "subscription",
			"duration_in_months": 6
		}
	],
	"price_components": [
		{
			"id": 3,
			"name": "conversion_fee",
			"value": 2.25
		},
		{
			"id": 1,
			"name": "tax",
			"value": 5.11
		},
		{
			"id": 2,
			"name": "base_price",
			"value": 100.75
		}
	]
}
```
## How to  Run

  1. Install [MySQL]
  2. Configure datasource in `application.properties`.
  3. Import tables and mock data into database by executing `sql\dbscript.sql`.
  4. Run `mvn install`.
  5. Run `mvn spring-boot:run`.
  6. The server is running on [localhost:8080]().
