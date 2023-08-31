package com.nakta.springlv1.controller;

import com.nakta.springlv1.dto.BoardRequestDto;
import com.nakta.springlv1.dto.BoardResponseDto;
import com.nakta.springlv1.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardRequestDto requestDto, HttpServletRequest req) {
        return ResponseEntity.ok(boardService.createBoard(requestDto, req));
    }

    @GetMapping("/board")
    public ResponseEntity<List<BoardResponseDto>> getAllBoard() {
        return ResponseEntity.ok(boardService.getAllBoard());
    }
    @GetMapping("/board/{id}")
    public ResponseEntity<BoardResponseDto> getOneBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getOneBoard(id));
    }

    @PutMapping("/board/{id}")
    public ResponseEntity<BoardResponseDto> modifyBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto, HttpServletRequest req) {
        return ResponseEntity.ok(boardService.modifyBoard(id, requestDto, req));
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long id, HttpServletRequest req) {
        return ResponseEntity.ok(boardService.deleteBoard(id, req));
    }

}
