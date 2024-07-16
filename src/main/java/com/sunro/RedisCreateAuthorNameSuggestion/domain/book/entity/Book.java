package com.sunro.RedisCreateAuthorNameSuggestion.domain.book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.Cacheable;


@Entity
@Getter
@Table(name = "books")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    private int likeCount;

    @Cacheable(value = "book", key = "#id")
    public int getLikeCount(){
        return likeCount;
    }

    public void updateCount(int likeCount) {
        this.likeCount += 1;

    }
}
