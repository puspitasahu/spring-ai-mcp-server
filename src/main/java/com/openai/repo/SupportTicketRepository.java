package com.openai.repo;

import com.openai.entity.SupportTicket;
import com.openai.entity.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportTicketRepository extends JpaRepository<SupportTicket,Long>{
    List<SupportTicket> findByStatus(TicketStatus status);
    List<SupportTicket> findByAssignedTo(String assignedTo);

}
