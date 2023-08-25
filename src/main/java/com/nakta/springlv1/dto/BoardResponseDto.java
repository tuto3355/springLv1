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
}