package com.sunro.RedisCreateAuthorNameSuggestion.domain.book.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BoardWriteReq {

     private String title;
     private String description;
}
