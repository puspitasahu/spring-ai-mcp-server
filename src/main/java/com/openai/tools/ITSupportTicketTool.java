package com.openai.tools;

import com.openai.entity.SupportTicket;
import com.openai.service.SupportTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ITSupportTicketTool{
    private final SupportTicketService supportTicketService;

    @Tool(description = "Create  a support ticket with issue description and email")
    public SupportTicket createSupportTicket(
            @ToolParam(description = "Issue description") String description,
            @ToolParam(description = "User Email")String email){
        return supportTicketService.createSupportTicket(description,email);
    }

    @Tool(description="Add comment to a support ticket")
    public String addComment(@ToolParam(description = "Ticket ID")Long id,
                             @ToolParam(description = "Comment Text") String comment){
        return supportTicketService.addComments(id,comment);
    }

    @Tool(description = "Escalate a support ticket to high priority")
    public String escalateIssue(@ToolParam(description = "Ticket ID") Long id){
        return supportTicketService.escalateIssue(id);
    }

    @Tool(description = "Get details of a support ticket by its ID")
    public SupportTicket getTicketDetails(@ToolParam(description = "Ticket ID") Long id){
        return supportTicketService.getTicketDetails(id);

    }

    @Tool(description = "List all support tickets")
    public List<SupportTicket> getAllTickets(){
        return supportTicketService.getAllTickets();

    }
}
