package com.example.reactive.demo.practice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxDemo {

    public static void main(String[] args) {

        Mono<String> mono = Mono.just("Hello Reactive World");
        mono.subscribe(System.out::println);

        Flux<Integer> flux = Flux.just(1,2,3,4,5);
        flux.subscribe(System.out::println);
    }
}
