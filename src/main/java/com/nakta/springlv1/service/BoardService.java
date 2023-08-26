package com.nakta.springlv1.service;

import com.nakta.springlv1.dto.BoardRequestDto;
import com.nakta.springlv1.dto.BoardResponseDto;
import com.nakta.springlv1.entity.Board;
import com.nakta.springlv1.repository.BoardRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
        List<BoardResponseDto> list = boardRepository.findAll();
        list.sort((x,y)-> (y.getDate().compareTo(x.getDate())));
        return list;
    }
    public BoardResponseDto getOneBoard(Long id) {
        Board board = boardRepository.findById(id);
        if (board != null) {
            board.setId(id);
            return new BoardResponseDto(board);
        } else {
            throw new IllegalArgumentException("선택한 게시글 id는 존재하지 않음");
        }
    }
    public Long modifyBoard(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id);
        if (board != null) {
            if (board.getPassword().equals(requestDto.getPassword())) {
                boardRepository.modify(id, requestDto);
                return id;
            } else {
                throw new IllegalArgumentException("비밀번호가 일치하지 않음");
            }
        } else {
            throw new IllegalArgumentException("선택한 게시글 id는 존재하지 않음");
        }
    }
    public Long deleteBoard(Long id) {
        Board board = boardRepository.findById(id);
        if (board != null) {
            boardRepository.delete(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 게시글 id는 존재하지 않음");
        }
    }
}