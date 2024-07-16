package com.sunro.RedisCreateAuthorNameSuggestion.domain.book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;


/**
 * Redis는 원자적으로 실행되기 떄문에 @Transactional이 필요없다.
 * 만약 여러 개의 Redis연산을 한 트랜잭션으로 묶어야 한다면 사용할 수 있다.
 */
@Service
@RequiredArgsConstructor
public class RedisService{

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * Redis 값을 등록/수정합니다.
     *
     * @param {String} key : redis key
     * @param {String} value : redis value
     * @return {void}
     */
    public void setValues(String key, String value) {
        ValueOperations<String, Object> values = redisTemplate.opsForValue();

        values.set(key, value);
    }

    /**
     * Redis 값을 등록/수정합니다.
     *
     * @param {String} key : redis key
     * @param {String} value : redis value
     * @param {Duration} duration: redis 값 메모리 상의 유효시간.
     * @return {void}
     */
    public void setValues(String key, String value, Duration duration) {
        ValueOperations<String, Object> values = redisTemplate.opsForValue();
        values.set(key, value, duration);
    }

    public String getValue(String key) {
        ValueOperations<String, Object> values = redisTemplate.opsForValue();
        if (values.get(key) == null) {
            return "";
        }
        return String.valueOf(values.get(key));
    }

    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }
}
