package com.boardPractice.boardTest.sample.board.model.dao;

import com.boardPractice.boardTest.sample.board.model.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDAOImpl implements BoardDAO{

    BoardRepository boardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
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
}
