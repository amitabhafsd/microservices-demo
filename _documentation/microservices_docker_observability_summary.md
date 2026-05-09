# 🚀 Microservices Docker Commands & Observability Stack

## 🔷 1. Zookeeper

### Command

```bash
docker run -d --name zookeeper -p 2181:2181 zookeeper
```

### Purpose

Kafka traditionally depends on Zookeeper for:
- broker coordination
- cluster metadata
- leader election

---

# 🔷 2. Kafka

### Command

```bash
docker run -d --name kafka -p 9092:9092 -e KAFKA_ZOOKEEPER_CONNECT=host.docker.internal:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 confluentinc/cp-kafka
```

### Purpose

Kafka acts as:
- Event Broker
- Async communication layer
- Event-driven architecture backbone

### Architecture Flow

```text
Order Service
     |
     v
   Kafka
     |
     +--> User Service
     |
     +--> Product Service
```

---

# 🔷 3. Elasticsearch (Lite Version)

### Command

```bash
docker run -d --name elasticsearch -p 9200:9200 -e discovery.type=single-node -e xpack.security.enabled=false -e ES_JAVA_OPTS="-Xms512m -Xmx512m" docker.elastic.co/elasticsearch/elasticsearch:8.13.4
```

### Purpose

Elasticsearch is used for:
- centralized logging
- indexing logs
- searching logs

### Important Flags

| Flag | Purpose |
|------|----------|
| discovery.type=single-node | standalone mode |
| xpack.security.enabled=false | disable auth locally |
| ES_JAVA_OPTS | reduce memory usage |

---

# 🔷 4. Kibana (Lite Version)

### Command

```bash
docker run -d --name kibana -p 5601:5601 -e ELASTICSEARCH_HOSTS=http://host.docker.internal:9200 -e NODE_OPTIONS="--max-old-space-size=256" docker.elastic.co/kibana/kibana:8.13.4
```

### Purpose

Kibana is used for:
- log visualization
- dashboards
- searching trace IDs
- debugging

### Important Flags

| Flag | Purpose |
|------|----------|
| ELASTICSEARCH_HOSTS | connects Kibana to ES |
| NODE_OPTIONS | reduce Kibana memory |

---

# 🔷 5. Logstash (Lite Version)

### Command

```bash
docker run -d --name logstash -p 5000:5000 -e LS_JAVA_OPTS="-Xms256m -Xmx256m" -e xpack.monitoring.enabled=false -v C:\MyApplications\JavaProjects\microservices-demo\logstash.conf:/usr/share/logstash/pipeline/logstash.conf docker.elastic.co/logstash/logstash:8.13.4
```

### Purpose

Logstash is used for:
- receiving logs
- processing logs
- forwarding logs to Elasticsearch

### Important Flags

| Flag | Purpose |
|------|----------|
| LS_JAVA_OPTS | reduce memory |
| xpack.monitoring.enabled=false | avoid ES hostname errors |
| -v | mount config file |

### ELK Flow

```text
Spring Boot Logs
       ↓
   Logstash
       ↓
 Elasticsearch
       ↓
    Kibana
```

---

# 🔷 6. Prometheus

### Command

```bash
docker run -d -p 9091:9090 -v C:\MyApplications\JavaProjects\microservices-demo\monitoring\prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
```

### Purpose

Prometheus is used for:
- metrics collection
- CPU/memory monitoring
- API latency monitoring

### Monitoring Flow

```text
Microservices
      |
/actuator/prometheus
      |
      v
 Prometheus
```

---

# 🔷 7. Grafana

### Command

```bash
docker run -d -p 3000:3000 grafana/grafana
```

### Purpose

Grafana is used for:
- metrics dashboards
- charts
- alerts
- monitoring visualization

### Flow

```text
Prometheus ---> Grafana
```

---

# 🔷 8. Zipkin

### Command

```bash
docker run -d -p 9411:9411 openzipkin/zipkin
```

### Purpose

Zipkin is used for:
- distributed tracing
- trace IDs
- request flow visualization
- latency debugging

### Tracing Flow

```text
Gateway
   |
Order Service
   |
User Service
```

Tracked using:
- traceId
- spanId

---

# 🔷 9. Useful Docker Utility Commands

## Running Containers

```bash
docker ps
```

Shows active containers.

---

## All Containers

```bash
docker ps -a
```

Shows running + stopped containers.

---

## View Logs

```bash
docker logs elasticsearch
```

---

## Live Logs

```bash
docker logs -f kibana
```

Used for debugging startup issues.

---

## Stop Containers

```bash
docker stop elasticsearch kibana
```

---

## Remove Containers

```bash
docker rm -f elasticsearch kibana logstash
```

Used for restarting cleanly.

---

# 📊 FINAL OBSERVABILITY STACK

```text
Metrics     → Prometheus + Grafana
Tracing     → Zipkin
Logs        → ELK Stack
Events      → Kafka
Security    → JWT
Gateway     → Spring Cloud Gateway
Discovery   → Eureka
Config      → Config Server
```

---

# 🚀 What You Have Learned

- Microservices
- Event-driven architecture
- JWT Security
- Kafka
- Monitoring
- Distributed Tracing
- Centralized Logging
- Observability Stack
- API Gateway
- Eureka Discovery
- Config Server

---

# 🚀 Major Topics Remaining

1. Dockerizing Microservices
2. Kubernetes
3. CI/CD Pipelines
4. OAuth2 + Keycloak
5. Advanced Kafka Patterns
