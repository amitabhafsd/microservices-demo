package com.example.reactive.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class NotificationController {

    @GetMapping(value = "/notifications", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Notification> getNotifications() {

        return Flux
                .interval(Duration.ofSeconds(2))
                .map(i ->
                        new Notification(
                                "New Notification #" + i,
                                System.currentTimeMillis()));
    }
}
