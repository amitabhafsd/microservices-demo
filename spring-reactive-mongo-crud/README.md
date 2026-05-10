# spring-reactive-mongo-crud

Reactive CRUD project using:
- Spring WebFlux
- MongoDB Reactive
- Mono & Flux

## Run MongoDB

```bash
docker run -d --name mongodb -p 27017:27017 mongo
```

## Start Application

```bash
mvn spring-boot:run
```

## APIs

GET /products
POST /products
PUT /products/{id}
DELETE /products/{id}
