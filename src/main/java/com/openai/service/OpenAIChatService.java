package com.openai.service;

import com.openai.tools.ITSupportTicketTool;
//import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

/*
@Service
public class OpenAIChatService{

    private final ChatClient chatClient;
    private final RealTimeDataTool realTimeDataTool;
    private final ITSupportTicketTool itSupportTicketTool;

    public OpenAIChatService(ChatClient chatClient,RealTimeDataTool realTimeDataTool,ITSupportTicketTool itSupportTicketTool){
        this.chatClient = chatClient;
        this.realTimeDataTool=realTimeDataTool;
        this.itSupportTicketTool = itSupportTicketTool;
    }

    public String askToAIStream(String message){
        return chatClient.prompt(message)
                .system("""
                        You are an IT support assistant.
                        Help users create, update, and manage support tickets.
                        Extract details like email, issue, and ticket id from user input
                        """)
                .tools(realTimeDataTool,itSupportTicketTool)
                .call()
                .content();

    }
}
*/

