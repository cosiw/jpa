package com.boardPractice.boardTest.sample.board.model.service;

import com.boardPractice.boardTest.sample.board.model.dao.BoardDAO;
import com.boardPractice.boardTest.sample.board.model.dto.BoardDTO;
import com.boardPractice.boardTest.sample.board.model.dto.LikeDTO;
import com.boardPractice.boardTest.sample.board.model.entity.Board;
import com.boardPractice.boardTest.sample.board.model.entity.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO){
        this.boardDAO = boardDAO;
    }


    @Override
    @Transactional
    public BoardDTO getBoard(Long bid) {
        Board board = boardDAO.getBoard(bid);

        BoardDTO boardDTO =  new BoardDTO(board.getBid(), board.getTitle(), board.getContents(), board.getUser().getUserid(), board.getLikecount());

        return boardDTO;
    }

    @Override
    @Transactional
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
    @Transactional
    public BoardDTO updateBoard(BoardDTO boardDTO) {

        Board boardEntity = boardDTO.toEntity();

        Board board = boardDAO.updateBoard(boardEntity);

        BoardDTO result = board.toDTO(board);

        return result;
    }

    @Override
    @Transactional
    public void deleteBoard(Long bid) {

        boardDAO.deleteBoard(bid);
    }

    @Override
    @Transactional
    public LikeDTO likeBoard(LikeDTO likeDTO) {

        Like like = likeDTO.toEntity();
        System.out.println("like" + like.getBoard().getBid());
        // 해당 유저가 이전에 좋아요를 눌렀던 게시물인지 확인
        System.out.println( boardDAO.checkLike(like));
        // 좋아요를 눌렀고, 현재 좋아요 상태일 경우
        // 좋아요를 눌렀지만, 현재 좋아요 상태가 아닐 경우
        // 처음 누를 경우
        return null;
    }


}
