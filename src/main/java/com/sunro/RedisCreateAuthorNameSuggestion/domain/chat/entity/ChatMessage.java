package com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.entity;

import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.constant.MessageType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ChatMessage {

    private MessageType messageType;
    private String roomId;
    private String sender;
    private String message;
}
