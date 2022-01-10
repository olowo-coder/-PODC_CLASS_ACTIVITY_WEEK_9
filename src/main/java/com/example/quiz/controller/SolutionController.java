package com.example.quiz.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class SolutionController {

    WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8899")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build();

    @GetMapping("{id}")
    public Flux<Object> findById(@PathVariable Integer id) {
        return webClient.get()
                .uri("/getsolutions/" + id)
                .retrieve()
                .bodyToFlux(Object.class);
    }
}
