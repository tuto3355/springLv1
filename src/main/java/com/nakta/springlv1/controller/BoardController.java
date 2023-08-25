package com.nakta.springlv1.controller;

import com.nakta.springlv1.dto.BoardRequestDto;
import com.nakta.springlv1.dto.BoardResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {

    @PostMapping("/board")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        return null;
    }

    @GetMapping("/board")
    public List<BoardResponseDto> getAllBoard() {
        return null;
    }
    @GetMapping("/board/{id}")
    public BoardResponseDto getOneBoard(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/board/{id}")
    public BoardResponseDto modifyBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return null;
    }

    @DeleteMapping("/board/{id}")
    public BoardResponseDto deleteBoard(@PathVariable Long id) {
        return null;
    }

}
