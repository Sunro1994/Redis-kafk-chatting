package com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.controller;

import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.constant.Type;
import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.entity.ChatMessage;
import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.repository.ChatRoomRepository;
import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.service.RedisPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
@Slf4j
public class ChatController {

    private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;

    /**
     * websocket "/pub/chat/message"로 들어오는 메시징 처리
     */

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        log.info("Received message: {}", message);

        if (Type.ENTER.equals(message.getType())) {
            chatRoomRepository.enterChatRoom(message.getRoomId());
            message.setMessage(message.getSender()+"님이 입장하셨습니다.");
            log.info("User {} entered room {}", message.getSender(), message.getRoomId());
        }

            redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()),message);
    }
}
