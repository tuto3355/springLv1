package com.nakta.springlv1.entity;

import com.nakta.springlv1.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Board {
    private Long id;
    private String title;
    private String userName;
    private String content;
    private String password;
    private String date;

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.userName = requestDto.getUserName();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
        this.date = requestDto.getDate();
    }
}
