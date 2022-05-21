# kafkaconnector
Java application to connect to Kafka topics

## How to start Kafka Server?
docker-compose up -d

## How to use a Kafka topic?
Download https://www.apache.org/dyn/closer.cgi?path=/kafka/2.7.0/kafka_2.12-2.7.0.tgz

Go to /bin/window/

Create a topic: 

    kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic helloKafka

Create a producer:

    kafka-console-producer.bat --broker-list localhost:9092 --topic helloKafka

Create a consumer:

    kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic helloKafka

