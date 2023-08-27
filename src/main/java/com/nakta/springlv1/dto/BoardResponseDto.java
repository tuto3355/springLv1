package com.nakta.springlv1.dto;

import com.nakta.springlv1.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String userName;
    private String content;
    private String password;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.userName = board.getUserName();
        this.content = board.getContent();
        this.password = board.getPassword();
    }
}
