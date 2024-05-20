package com.dan.clientserverdan.controller;

import com.dan.clientserverdan.model.UserModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class RegistrationController {
    private final String SERVER_URL = "http://localhost:9000";

    private final WebClient webClient = WebClient.builder()
            .baseUrl(SERVER_URL)
            .build();

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        return this.webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/register").build())
                .body(BodyInserters.fromValue(userModel))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
