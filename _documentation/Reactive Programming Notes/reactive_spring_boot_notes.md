# Reactive Programming with Spring Boot — Complete ASCII Notes

Based on the video:
https://www.youtube.com/watch?v=bXcFCgQsvAE

---

# What is Reactive Programming?

Reactive Programming is:
- Asynchronous
- Non-blocking
- Event-driven
- Stream-oriented
- Scalable

---

# Traditional Blocking Architecture

```text
+---------+
| Client  |
+---------+
      |
      v
+-------------------+
| Thread Allocated  |
+-------------------+
      |
      v
+-------------------+
| DB/API Call       |
| Thread WAITING    |
+-------------------+
      |
      v
+-------------------+
| Response Returned |
+-------------------+
```

---

# Reactive Non-Blocking Architecture

```text
+---------+
| Client  |
+---------+
      |
      v
+----------------------+
| Event Loop / Netty   |
+----------------------+
      |
      v
+----------------------+
| Async Task Started   |
+----------------------+
      |
      +--------------------+
      | Thread Released    |
      v
+----------------------+
| Result Ready Event   |
+----------------------+
      |
      v
+----------------------+
| Response Sent        |
+----------------------+
```

---

# Mono vs Flux

## Mono

```text
0 or 1 item
```

```java
Mono.just("Amit")
```

## Flux

```text
0 to N items
```

```java
Flux.just(1,2,3,4)
```

---

# Spring MVC vs WebFlux

## Spring MVC

```text
Request ---> Thread ---> Wait ---> Response
```

## Spring WebFlux

```text
Requests ---> Event Loop ---> Async Processing
```

---

# Reactive CRUD Architecture

```text
+------------+
| Client     |
+------------+
      |
      v
+------------+
| Controller |
+------------+
      |
      v
+------------+
| Service    |
+------------+
      |
      v
+----------------------+
| Reactive Repository  |
+----------------------+
      |
      v
+----------------------+
| MongoDB Reactive DB  |
+----------------------+
```

---

# Backpressure

```text
+-------------+     request(5)      +-------------+
| Subscriber  | <------------------ | Publisher   |
+-------------+                     +-------------+
```

---

# Subscription Lifecycle

```text
Create Flux/Mono
       |
       v
subscribe()
       |
       v
Execution Starts
```

---

# Reactive Pipeline

```text
Flux Source
     |
     v
map()
     |
     v
filter()
     |
     v
flatMap()
     |
     v
subscribe()
```

---

# Netty Event Loop

```text
          +----------------------+
          | Event Loop Thread    |
          +----------------------+
             /      |       \
            /       |        \
           v        v         v
      +------+ +------+ +------+
      |Task1 | |Task2 | |Task3 |
      +------+ +------+ +------+
```

---

# Functional Endpoints

```text
+---------+
| Router  |
+---------+
      |
      v
+---------+
| Handler |
+---------+
      |
      v
+----------------+
| ServerResponse |
+----------------+
```

---

# Error Handling

```java
.onErrorReturn("Fallback")
```

---

# Beginner POCs

## Flux Example

```java
Flux.just("A", "B", "C")
    .subscribe(System.out::println);
```

## Mono Example

```java
Mono.just("Reactive")
    .subscribe(System.out::println);
```

## Reactive REST API

```java
@GetMapping("/numbers")
public Flux<Integer> numbers() {
    return Flux.just(1,2,3,4,5);
}
```

---

# Learning Roadmap

```text
Reactive Basics
      |
      v
Mono & Flux
      |
      v
Operators
      |
      v
Spring WebFlux
      |
      v
Reactive MongoDB
      |
      v
Kafka Reactive
      |
      v
Production Reactive Systems
```

---

# Final Summary

Reactive Programming helps applications become:
- Highly scalable
- Non-blocking
- Event-driven
- Resource efficient

Main takeaway:

Think in streams and events instead of threads and waiting.
