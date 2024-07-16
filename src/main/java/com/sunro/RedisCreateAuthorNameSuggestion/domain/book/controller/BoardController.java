package com.sunro.RedisCreateAuthorNameSuggestion.domain.book.controller;

import com.sunro.RedisCreateAuthorNameSuggestion.domain.book.dto.BoardWriteReq;
import com.sunro.RedisCreateAuthorNameSuggestion.domain.book.entity.Book;
import com.sunro.RedisCreateAuthorNameSuggestion.domain.book.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    public Book create(@RequestBody BoardWriteReq boardWriteReq) {

        Book book = boardService.create(boardWriteReq);

        return book;
    }


    @GetMapping("/like/{id}")
    public Book like(@PathVariable Long id) {
        Book book = boardService.likeCountUpOrDown(id);

        return book;
    }







}
