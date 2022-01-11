package com.example.quiz.controller;

import com.example.quiz.services.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class SolutionController {

    SolutionService solutionService;

    @Autowired
    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping
    public ResponseEntity<Object> callGetAllCountries(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", header);
        ResponseEntity<Object> result = restTemplate.exchange(
                "http://localhost:8585/getsolutions",
                HttpMethod.GET, entity, Object.class
        );
        System.out.println(result);
        return result;
    }

    //Hamid
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
