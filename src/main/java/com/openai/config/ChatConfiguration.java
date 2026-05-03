package com.openai.config;

import com.openai.service.RealTimeDataTool;
import com.openai.tools.ITSupportTicketTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Configuration
public class ChatConfiguration {

  @Bean
  public List<ToolCallback> toolCallbacks(ITSupportTicketTool itSupportTicketTool, RealTimeDataTool realTimeDataTool){
      return List.of(ToolCallbacks.from(itSupportTicketTool,realTimeDataTool));
  }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

