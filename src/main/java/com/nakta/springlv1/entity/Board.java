package com.nakta.springlv1.entity;

import com.nakta.springlv1.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor

public class Board {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "title", nullable = false, length = 500)
    private String title;
    @Column(name = "userName", length = 500)
    private String userName;
    @Column(name = "content", nullable = false, length = 500)
    private String content;
    @Column(name = "password", nullable = false, length = 500)
    private String password;

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.userName = requestDto.getUserName();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.userName = requestDto.getUserName();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}
