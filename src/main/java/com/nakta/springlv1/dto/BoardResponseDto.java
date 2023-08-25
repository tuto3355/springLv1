package com.nakta.springlv1.dto;

import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String userName;
    private String content;
    private String password;
    private String date;

    public BoardResponseDto(Long id, String title, String userName, String content, String password, String date) {
        this.id = id;
        this.title = title;
        this.userName = userName;
        this.content = content;
        this.password = password;
        this.date = date;
    }
}
