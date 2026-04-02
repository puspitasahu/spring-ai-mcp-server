package com.openai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupportTicket{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String title;
    private String description;
    private String customerEmail;
    private String assignedTo;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Boolean isEscalated=false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime slaDeadline;
    @ElementCollection
    private List<String> comments;

}
