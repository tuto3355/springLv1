package com.nakta.springlv1.service;

import com.nakta.springlv1.dto.BoardRequestDto;
import com.nakta.springlv1.dto.BoardResponseDto;
import com.nakta.springlv1.entity.Board;
import com.nakta.springlv1.repository.BoardRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        Board newboard = boardRepository.save(board);
        return new BoardResponseDto(newboard);
    }
    public List<BoardResponseDto> getAllBoard() {
        return boardRepository.findAll().stream().map(BoardResponseDto::new).toList();
    }
    public BoardResponseDto getOneBoard(Long id) {
        Board board = findById(id);
        return new BoardResponseDto(board);
    }
    @Transactional
    public Long modifyBoard(Long id, BoardRequestDto requestDto) {
        Board board = findById(id);
            if (board.getPassword().equals(requestDto.getPassword())) {
                board.update(requestDto);
                return id;
            } else {
                throw new IllegalArgumentException("비밀번호가 일치하지 않음");
            }
    }
    public Long deleteBoard(Long id) {
        Board board = findById(id);
        boardRepository.deleteById(id);
        return id;
    }

    private Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }
}