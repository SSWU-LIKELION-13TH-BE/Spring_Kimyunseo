package com.example.demo1.service;

import com.example.demo1.dto.BoardDTO;
import com.example.demo1.entity.Board;
import com.example.demo1.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Optional<Board> getBoard(Long boardId) {
        return boardRepository.findByBoardId(boardId);
    }

    public void postBoard(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public void putBoard(BoardDTO boardDTO) {
        Board board = Board.builder()
                .boardId(boardDTO.getBoardId())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(boardDTO.getWriter())
                .postDate(LocalDate.now())
                .build();
        boardRepository.save(board);
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        boardRepository.deleteByBoardId(boardId);
    }
}