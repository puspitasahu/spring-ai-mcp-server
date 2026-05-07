package com.openai.dto;

public record TicketResponse(
        Long id,
        String description,
        String email,
        String status
) {}