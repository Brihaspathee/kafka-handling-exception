# Sample Kafka Producer/Consumer project with error handling mechanism

## Project Highlights
* Connects to local MySQL when ran in local
* Connects to in memory h2 database for test
* Containerized with logs mapped to local drive
* Connects to MySql Container when ran as a docker container
* Kafka producer produces JSON Message and Consumer consumes the message from kafka topic
* The Producer, Consumer can be run on local and in docker using the Docker Compose
* The Kafka Broker can be run local and in docker
* When run in local Producer and Consumer uses the kafka boostrap server configured in application.yaml
* When run in docker the bootstrap server provided in docker-compose.yaml file is used
* There two Kafka topics in this project
  * Food Order 
  * Food Payment
* For Food Order in the consumer side a specific food order error handler is configured. 
  * If the quantity of food that is ordered is more than a certain value an exception will be generated
  * This exception will be caught by the error handler that is specific to food order. 
  * In this example we just print the error in the console and re-throw that exception for the global error handler to handle
* For Food Payment in the consumer side there is no specific error handler
  * If the payment is less than a certain amount, then an exception is generated
  * Since there is no food payment specific error handler, this exception is directly handled by the global error handler