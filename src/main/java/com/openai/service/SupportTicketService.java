package com.openai.service;

import com.openai.entity.Category;
import com.openai.entity.Priority;
import com.openai.entity.SupportTicket;
import com.openai.entity.TicketStatus;
import com.openai.repo.SupportTicketRepository;
import com.openai.util.TicketHelper;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportTicketService{
    private final SupportTicketRepository ticketRepository;

    //Create a new support ticket based on the description and customer email
    public SupportTicket createSupportTicket(String description,String email){
        SupportTicket ticket = new SupportTicket();
        ticket.setTitle(TicketHelper.generateTitle(description));
        ticket.setDescription(description);
        ticket.setCustomerEmail(email);
        ticket.setPriority(TicketHelper.detectPriority(description));
        ticket.setCategory(TicketHelper.detectCategory(description));
        ticket.setStatus(TicketStatus.OPEN);
        ticket.setAssignedTo(TicketHelper.assignEngineer(ticket.getCategory()));
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setUpdatedAt(LocalDateTime.now());
        ticket.setSlaDeadline(TicketHelper.calculateSLA(ticket.getPriority()));
        ticketRepository.save(ticket);
        return ticket;
    }
    //Get details of a support ticket by its ID
    public SupportTicket getTicketDetails(Long id){
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id :" + id));
    }
    //Escalate a support ticket to high priority
    public String escalateIssue(Long id){
        SupportTicket supportTicket = getTicketDetails(id);
        supportTicket.setIsEscalated(true);
        supportTicket.setPriority(Priority.HIGH);
        supportTicket.setUpdatedAt(LocalDateTime.now());
        ticketRepository.save(supportTicket);
        return  "Ticket " + id + "escalated to HIGH priority";
    }
    //Add a comment to a support ticket
    public String addComments(Long id,String comment){
        SupportTicket supportTicket = getTicketDetails(id);
        supportTicket.getComments().add(comment);
        supportTicket.setUpdatedAt(LocalDateTime.now());
        ticketRepository.save(supportTicket);
        return  "comment added to ticket " + id;
    }
    //Get A list of all supportTickets
    public List<SupportTicket> getAllTickets(){
        return ticketRepository.findAll();
    }
}
