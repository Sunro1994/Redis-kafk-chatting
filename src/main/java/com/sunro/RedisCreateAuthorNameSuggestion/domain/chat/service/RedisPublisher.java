package com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.service;

import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.dto.ChatRoom;
import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.entity.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;

    public void publish(ChannelTopic topic, ChatMessage message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
