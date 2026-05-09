package com.example.reactive.demo.practice;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class DelayDemo {


    public static void main(String[] args) {

        Flux.range(1,5)
                .delayElements(Duration.ofSeconds(1))
                .subscribe(System.out::println);


        //OR we can visualize the following publisher and subscriber nomenclature

        Flux<Integer> publisher =
                Flux.range(1, 5)
                        .delayElements(Duration.ofSeconds(1));

        publisher.subscribe(System.out::println);

        //another way of subscriber
        publisher.subscribe(
                item -> System.out.println("Next: " + item),
                error -> System.out.println("Error: " + error),
                () -> System.out.println("Completed")
        );


        System.out.println("Non Blocking Main Thread");

        try {
            Thread.sleep(10000);
            System.out.println("Sleep Done");
        } catch (Exception e) {

        }
    }


}
