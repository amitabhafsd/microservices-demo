# Reactive Streams Publisher-Subscriber Flow (ASCII)

```text

                    +----------------------------------+
                    |            PUBLISHER             |
                    +----------------------------------+
                          ^         ^         ^
                          |         |         |
                    (1) Subscribe() |
                                    |
                          +------------------+
                          | (2) Subscription |
                          +------------------+
                                    ^
                                    |
                           (3) Request(n)
                                    ^
                                    |
        +--------------------------------------------------+
        |                                                  |
        |              N onNext(data) events               |
        |                                                  |
        +--------------------------------------------------+

                    +----------------------------------+
                    |            SUBSCRIBER            |
                    +----------------------------------+

                                    |
                                    |
                     (5) onComplete() or onError()
                                    |
                                    v

                         Stream Completed / Failed
```

---

# Step-by-Step Explanation

## 1. Subscribe()

The Subscriber subscribes to the Publisher.

```text
Subscriber ---- subscribe() ----> Publisher
```

---

## 2. Subscription Created

Publisher creates a Subscription object.

```text
Publisher ---- Subscription ----> Subscriber
```

---

## 3. Request(n)

Subscriber requests how many events/data items it can handle.

```text
Subscriber ---- request(n) ----> Publisher
```

This is the core of BACKPRESSURE.

Example:
- request(5)
- request(100)

---

## 4. onNext(data)

Publisher starts sending data events.

```text
Publisher ---- onNext(data) ----> Subscriber
```

This may happen multiple times.

```text
onNext(data1)
onNext(data2)
onNext(data3)
...
onNext(dataN)
```

---

## 5. onComplete() or onError()

When stream finishes:

```text
Publisher ---- onComplete() ----> Subscriber
```

If failure occurs:

```text
Publisher ---- onError() ----> Subscriber
```

---

# Full Reactive Streams Lifecycle

```text

+-------------+
| Subscriber  |
+-------------+
       |
       | subscribe()
       v
+-------------+
| Publisher   |
+-------------+
       |
       | creates Subscription
       v
+-------------+
|Subscription |
+-------------+
       |
       | request(n)
       v
+-------------+
| Publisher   |
+-------------+
       |
       | onNext(data)
       v
+-------------+
| Subscriber  |
+-------------+
       |
       | onComplete()/onError()
       v
+-------------+
| Stream End  |
+-------------+

```

---

# Important Concepts

| Concept | Meaning |
|---|---|
| Publisher | Produces data |
| Subscriber | Consumes data |
| Subscription | Controls data flow |
| request(n) | Backpressure mechanism |
| onNext() | Data event |
| onComplete() | Successful completion |
| onError() | Error signal |

# Docker Command to run

```text
docker run -d --name mongodb -p 27017:27017 mongo
```