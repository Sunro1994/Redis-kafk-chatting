package com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.controller;

import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.constant.MessageType;
import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.entity.ChatMessage;
import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.repository.ChatRoomRepository;
import com.sunro.RedisCreateAuthorNameSuggestion.domain.chat.service.RedisPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.listener.ChannelTopic;
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
        log.info("message={}", message);

        // 채팅방 입장 메시지일 경우
        if (MessageType.ENTER.equals(message.getMessageType())) {
            chatRoomRepository.enterChatRoom(message.getRoomId()); // 채팅방에 입장
            message.toBuilder()
                    .message(message.getSender() + "님 입장")
                    .build();
        }

        ChannelTopic topic = chatRoomRepository.getTopic(message.getRoomId()); // 채팅방 topic 가져오기
        if (topic != null) {
            redisPublisher.publish(topic, message); // 메시지 발행
        } else {
            log.error("ChannelTopic is null for roomId: {}", message.getRoomId());
        }
    }
}
