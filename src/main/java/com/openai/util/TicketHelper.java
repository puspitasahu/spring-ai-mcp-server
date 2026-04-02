package com.openai.util;

import com.openai.entity.Category;
import com.openai.entity.Priority;

import java.time.LocalDateTime;

public class TicketHelper{

    public static Priority detectPriority(String text){
        text = text.toLowerCase();
        if(text.contains("production") || text.contains("down")){
            return Priority.HIGH;
        }
        if(text.contains("slow") || text.contains("error")){
            return Priority.MEDIUM;
        }
        return Priority.LOW;
    }

    public static Category detectCategory(String text){
        text = text.toLowerCase();

        if(text.contains("bug") || text.contains("exception")){
            return Category.BUG;
        }
        if(text.contains("feature")){
            return Category.FEATURE;
        }
        if(text.contains("down")){
            return Category.INCIDENT;
        }
        return Category.SUPPORT;
    }

    public static String assignEngineer(Category category){
        return switch(category){
            case BUG -> "backend-team";
            case FEATURE -> "product-team";
            case INCIDENT -> "devops-team";
            default -> "support-team";
        };
    }

    public static LocalDateTime calculateSLA(Priority priority){
        return switch(priority){
            case HIGH -> LocalDateTime.now().plusHours(2);
            case MEDIUM -> LocalDateTime.now().plusHours(8);
            case LOW -> LocalDateTime.now().plusDays(1);
        };
    }

    public static String generateTitle(String desc){
        return desc.length() > 30 ? desc.substring(0,30) + "---" : desc;
    }

}
