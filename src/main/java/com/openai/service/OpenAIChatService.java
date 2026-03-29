package com.openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OpenAIChatService{

    private final ChatClient chatClient;
    private final RealTimeDataTool realTimeDataTool;

    public OpenAIChatService(ChatClient chatClient,RealTimeDataTool realTimeDataTool){
        this.chatClient = chatClient;
        this.realTimeDataTool=realTimeDataTool;
    }

    public String askToAIStream(String message){
        return chatClient.prompt(message)
                .tools(realTimeDataTool)
                .call()
                .content();

    }
}

