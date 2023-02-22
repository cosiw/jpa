package com.boardPractice.boardTest.sample.board.model.dao;

import com.boardPractice.boardTest.sample.board.model.entity.Board;

public interface BoardDAO {

    Board getBoard(Long bid);
    Board createBoard(Board board);

    Board updateBoard( Board board);

    void deleteBoard(Long bid);
}
