package com.boardPractice.boardTest.sample.board.model.service;

import com.boardPractice.boardTest.sample.board.model.dto.BoardDTO;
import com.boardPractice.boardTest.sample.board.model.entity.Board;

public interface BoardService {
    BoardDTO getBoard(Long bid);
    BoardDTO createBoard(BoardDTO boardDTO);

    BoardDTO updateBoard(BoardDTO boardDTO);
    void deleteBoard(Long bid);
}
