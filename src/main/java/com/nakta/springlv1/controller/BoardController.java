package com.nakta.springlv1.controller;

import com.nakta.springlv1.dto.BoardRequestDto;
import com.nakta.springlv1.dto.BoardResponseDto;
import com.nakta.springlv1.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {

    private BoardService boardService;

    @PostMapping("/board")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard();
    }

    @GetMapping("/board")
    public List<BoardResponseDto> getAllBoard() {
        return boardService.getAllBoard();
    }
    @GetMapping("/board/{id}")
    public BoardResponseDto getOneBoard(@PathVariable Long id) {
        return boardService.getOneBoard();
    }

    @PutMapping("/board/{id}")
    public BoardResponseDto modifyBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.modifyBoard();
    }

    @DeleteMapping("/board/{id}")
    public BoardResponseDto deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard();
    }

}
