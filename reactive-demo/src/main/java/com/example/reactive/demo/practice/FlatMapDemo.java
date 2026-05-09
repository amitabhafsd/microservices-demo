package com.example.reactive.demo.practice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FlatMapDemo {

    public static void main(String[] args) {

        Flux.just("Amit", "Rahul", "Sourav")
//                .map(name -> convertToUpper(name))
                .flatMap(name -> convertToUpper(name))
                .subscribe(System.out::println);
    }

    static Mono<String> convertToUpper(String name) {
        return Mono.just(name.toUpperCase());
    }

}
