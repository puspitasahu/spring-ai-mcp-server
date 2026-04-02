package com.openai.tools;

import com.openai.service.SupportTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ITSupportTicketTool{
    private final SupportTicketService service;
}
