# kafka-camel-learning

Used to test and learn integrations with Spring.

Technologies used:
* Spring Boot
* Kafka
* Camel
* Hibernate

Queuer service creates a Book object with the POST call. This book object is pushed to a BOOK_TOPIC in Kafka.
Dequeuer service subscribes to BOOK_TOPIC and saves Books into a H2 database.
