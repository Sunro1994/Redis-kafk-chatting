package com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.entity;

import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.constant.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private Type type;
    private String roomId;
    private String sender;
    private String message;
}
