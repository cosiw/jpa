package com.boardPractice.boardTest.sample.board.model.service;

import com.boardPractice.boardTest.sample.board.model.dao.BoardDAO;
import com.boardPractice.boardTest.sample.board.model.dto.BoardDTO;
import com.boardPractice.boardTest.sample.board.model.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO){
        this.boardDAO = boardDAO;
    }


    @Override
    public BoardDTO getBoard(Long bid) {
        Board board = boardDAO.getBoard(bid);

        BoardDTO boardDTO =  new BoardDTO(board.getBid(), board.getTitle(), board.getContents(), board.getUserid(), board.getLikeCount());

        return boardDTO;
    }

    @Override
    public BoardDTO createBoard(BoardDTO boardDTO) {
        // DTO to Entity
        Board boardEntity = boardDTO.toEntity();
        // INSERT
        Board board = boardDAO.createBoard(boardEntity);
        // Entity to DTO
        BoardDTO resultDTO = board.toDTO(board);

        return resultDTO;

    }

    @Override
    public BoardDTO updateBoard(BoardDTO boardDTO) {

        Board boardEntity = boardDTO.toEntity();

        Board board = boardDAO.updateBoard(boardEntity);

        BoardDTO result = board.toDTO(board);

        return result;
    }

    @Override
    public void deleteBoard(Long bid) {

        boardDAO.deleteBoard(bid);
    }


}
