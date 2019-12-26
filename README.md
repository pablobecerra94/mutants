# Mutants

MercadoLibre Technical Challenge

## Endpoints ##

- **Is mutant v1**
	- Method: POST
	- URL: [http://3.18.223.0:8080/api/v1/mutants](http://3.18.223.0:8080/api/v1/mutants)
	- In this version iif there is a string of 5 equal characters, it is taken as a  single sequence of 4 characters (characters 1 to 4)
	- Examples:
		- Request Mutant DNA: 

			 ` {"dna":["ATGCGA", "CAGGGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}`
		- Response:
		
			`200 OK`

		- Request not mutant DNA: 
	
			 ` {"dna":["AATACT", "CCCAGA", "GGGATT", "AATTCC", "GGATCG", "TCACTG"]}`
		- Response:
		
			`403 Forbidden`

		- Request with only one sequence of five equals character: 
	
			 ` {"dna":["AAAAA", "TATCT", "TGGCG", "GTTGT", "ACTGT"]}`
		- Response:
	
			`403 Forbidden`
		

-  **Is mutant v2**
	- Method: POST
	- URL: [http://3.18.223.0:8080/api/v2/mutants](http://3.18.223.0:8080/api/v2/mutants)
	- In this version if there is a string of 5 equal characters, it is taken as a two sequences of 4 characters (characters from 1 to 4 and characters from 2 to 5)
	- Examples:
		- Request Mutant DNA: 

			 ` {"dna":["ATGCGA", "CAGGGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}`
		- Response:
		
			`200 OK`

		- Request not mutant DNA: 
	
			 ` {"dna":["AATACT", "CCCAGA", "GGGATT", "AATTCC", "GGATCG", "TCACTG"]}`
		- Response:
		
			`403 Forbidden`

		- Request with only one sequence of five equals character: 
	
			 ` {"dna":["AAAAA", "TATCT", "TGGCG", "GTTGT", "ACTGT"]}`
		- Response:
	
			`200 OK`

- **Stats**
	- Method: GET
	- URL: [http://3.18.223.0:8080/api/stats](http://3.18.223.0:8080/api/stats)
	- Examples:
		- Response:
		
			`200 OK`

			` {
			'count_human_dna': 13,
			'count_mutant_dna': 25,
			'ratio': 0.5
			} `

		


## Technologies ##

- [Spring Framework](https://spring.io/)
	- Spring boot + web
- [MongoDB](https://www.mongodb.com/es)
- [JUnit](https://junit.org/junit5/)
- [Travis CI](https://travis-ci.org/)



## Setup ##
- Environment
	- [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
	- [Maven](https://maven.apache.org/)
	- [Eclipse IDE](https://www.eclipse.org/downloads/), [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/) or similar
- Run `mvn package` to generate JAR
- Run `java -jar jarName.jar` to run the application



