package com.boardPractice.boardTest.sample.board.model.dao;

import com.boardPractice.boardTest.sample.board.model.entity.Board;
import com.boardPractice.boardTest.sample.board.model.entity.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDAOImpl implements BoardDAO{

    BoardRepository boardRepository;

    
    LikeRepository likeRepository;
    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository, LikeRepository likeRepository){

        this.boardRepository = boardRepository;
        this.likeRepository = likeRepository;
    }



    @Override
    public Board getBoard(Long bid) {
        Board board = boardRepository.getById(bid);
        return board;
    }

    @Override
    public Board createBoard(Board board){
        boardRepository.save(board);
        return board;
    }

    @Override
    public Board updateBoard(Board board) {
        return boardRepository.save(board);

    }

    @Override
    public void deleteBoard(Long bid) {
        boardRepository.deleteById(bid);
    }

    @Override
    public Like likeBoard(Like like) {
        return null;
    }

    public boolean checkLike(Like like){
        System.out.println(like.getBoard().getBid());
        System.out.println(like.getUser().getUserid());
        Like like1 = likeRepository.selectlike(like.getBoard().getBid(),like.getUser().getUserid());
        System.out.println(like1.getBoard());
        if(true)
            return true;
        else
            return false;
    }
}
