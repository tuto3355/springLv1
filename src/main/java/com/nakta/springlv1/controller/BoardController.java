package com.nakta.springlv1.controller;

import com.nakta.springlv1.dto.BoardRequestDto;
import com.nakta.springlv1.dto.BoardResponseDto;
import com.nakta.springlv1.service.BoardService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {

    private final JdbcTemplate jdbcTemplate;

    public BoardController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/board")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        BoardService boardService = new BoardService(jdbcTemplate);
        return boardService.createBoard(requestDto);
    }

    @GetMapping("/board")
    public List<BoardResponseDto> getAllBoard() {
        BoardService boardService = new BoardService(jdbcTemplate);
        return boardService.getAllBoard();
    }
    @GetMapping("/board/{id}")
    public BoardResponseDto getOneBoard(@PathVariable Long id) {
        BoardService boardService = new BoardService(jdbcTemplate);
        return boardService.getOneBoard(id);
    }

    @PutMapping("/board/{id}")
    public Long modifyBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        BoardService boardService = new BoardService(jdbcTemplate);
        return boardService.modifyBoard(id, requestDto);
    }

    @DeleteMapping("/board/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        BoardService boardService = new BoardService(jdbcTemplate);
        return boardService.deleteBoard(id);
    }

}
