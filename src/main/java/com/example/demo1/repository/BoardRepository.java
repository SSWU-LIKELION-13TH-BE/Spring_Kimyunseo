package com.example.demo1.repository;

import com.example.demo1.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long> {
    Optional<Board> findByBoardId(Long boardId);

    void deleteByBoardId(Long boardId);
}