package com.nakta.springlv1.repository;

import com.nakta.springlv1.dto.BoardRequestDto;
import com.nakta.springlv1.dto.BoardResponseDto;
import com.nakta.springlv1.entity.Board;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BoardRepository {
    private final JdbcTemplate jdbcTemplate;

    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Board save(Board board) {//왜 얜 Board board??
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO board (title,userName,content,password,date) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(con -> {
                    PreparedStatement preparedStatement = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, board.getTitle());
                    preparedStatement.setString(2, board.getUserName());
                    preparedStatement.setString(3, board.getContent());
                    preparedStatement.setString(4, board.getPassword());
                    preparedStatement.setString(5, board.getDate());
                    return preparedStatement;
                },
                keyHolder);

        Long id = keyHolder.getKey().longValue();
        board.setId(id);

        return board;
    }

    public List<BoardResponseDto> findAll() {
        String sql = "SELECT * FROM board";
        return jdbcTemplate.query(sql, new RowMapper<BoardResponseDto>() {
            @Override
            public BoardResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String userName = rs.getString("userName");
                String content = rs.getString("content");
                String password = rs.getString("password");
                String date = rs.getString("date");
                return new BoardResponseDto(id, title, userName, content, password, date);
            }
        });
    }

    public void modify(Long id, BoardRequestDto requestDto) {
        String sql = "UPDATE board SET title = ?, userName  = ?, content  = ?, " +
                "password  = ?, date  = ? WHERE id = ?";
        jdbcTemplate.update(sql, requestDto.getTitle(), requestDto.getUserName()
                , requestDto.getContent(), requestDto.getPassword(), requestDto.getDate()
                , requestDto.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM board WHERE id = ?";
        jdbcTemplate.update(sql, id);

    }

    public Board findById(Long id) {
        String sql = "SELECT * from board WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if (resultSet.next()) {
                Board board = new Board();
                board.setTitle(resultSet.getString("title"));
                board.setContent(resultSet.getString("content"));
                board.setDate(resultSet.getString("date"));
                board.setPassword(resultSet.getString("password"));
                board.setUserName(resultSet.getString("userName"));
                return board;
            } else {
                return null;
            }

        }, id);
    }


}
