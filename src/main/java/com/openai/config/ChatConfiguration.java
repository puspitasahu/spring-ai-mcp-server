package com.openai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class ChatConfiguration {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder){
        Advisor loggerAdvisor = new SimpleLoggerAdvisor();
        return chatClientBuilder
                .defaultAdvisors(List.of(loggerAdvisor))
                .build();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
