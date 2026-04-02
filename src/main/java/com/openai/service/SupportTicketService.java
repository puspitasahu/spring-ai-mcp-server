package com.openai.service;

import com.openai.repo.SupportTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupportTicketService{
    private final SupportTicketRepository ticketRepository;
}
