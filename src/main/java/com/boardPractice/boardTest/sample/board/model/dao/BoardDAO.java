package com.boardPractice.boardTest.sample.board.model.dao;

import com.boardPractice.boardTest.sample.board.model.dto.LikeDTO;
import com.boardPractice.boardTest.sample.board.model.entity.Board;
import com.boardPractice.boardTest.sample.board.model.entity.Like;

public interface BoardDAO {

    Board getBoard(Long bid);
    Board createBoard(Board board);

    Board updateBoard( Board board);

    void deleteBoard(Long bid);

    Like likeBoard(Like like);
    boolean checkLike(Like like);
}
