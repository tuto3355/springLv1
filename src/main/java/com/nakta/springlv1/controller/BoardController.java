package com.nakta.springlv1.controller;

import com.nakta.springlv1.dto.BoardRequestDto;
import com.nakta.springlv1.dto.BoardResponseDto;
import com.nakta.springlv1.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/board")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }

    @GetMapping("/board")
    public List<BoardResponseDto> getAllBoard() {
        return boardService.getAllBoard();
    }
    @GetMapping("/board/{id}")
    public BoardResponseDto getOneBoard(@PathVariable Long id) {
        return boardService.getOneBoard(id);
    }

    @PutMapping("/board/{id}")
    public BoardResponseDto modifyBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.modifyBoard(id, requestDto);
    }

    @DeleteMapping("/board/{id}")
    public String deleteBoard(@PathVariable Long id, @RequestBody String password) {
        return boardService.deleteBoard(id,password);
    }

}
