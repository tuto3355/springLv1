package com.nakta.springlv1.repository;

import com.nakta.springlv1.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    public List<Board> findAllByOrderByModifiedAtDesc();
//    public Board findAllByTitleOrderByCreatedAtAsc(String title);
}