Install Docker and then Run the following commnads.



docker run -d --name zookeeper -p 2181:2181 zookeeper

docker run -d --name kafka -p 9092:9092 -e KAFKA_ZOOKEEPER_CONNECT=host.docker.internal:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 confluentinc/cp-kafka





Monitoring and Metrics collection and viewing using prometheus and grafana

Go into ~\microservices-demo\monitoring

docker-compose up -d
This is pull prometheus and grafana and start as per the docker compose yml.