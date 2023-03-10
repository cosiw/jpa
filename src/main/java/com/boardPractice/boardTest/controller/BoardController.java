package com.boardPractice.boardTest.controller;

import ch.qos.logback.core.CoreConstants;
import com.boardPractice.boardTest.common.Utils;
import com.boardPractice.boardTest.sample.board.model.dto.BoardDTO;
import com.boardPractice.boardTest.sample.board.model.dto.HeaderDTO;
import com.boardPractice.boardTest.sample.board.model.dto.LikeDTO;
import com.boardPractice.boardTest.sample.board.model.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    private BoardServiceImpl boardService;

    @Autowired
    public BoardController(BoardServiceImpl boardService){

        this.boardService = boardService;
    }
    Utils util = new Utils();

    @GetMapping(value = "/{bid}")
    public ResponseEntity getBoard(@PathVariable Long bid){
        BoardDTO boardDTO = boardService.getBoard(bid);
        return new ResponseEntity(boardDTO, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity createBoard(@RequestBody BoardDTO boardDTO){

        if(boardDTO.getTitle() == null || boardDTO.getContents() == null) {
            System.out.println("bad Request");
            return new ResponseEntity("bad Request", HttpStatus.BAD_REQUEST);
        }
        BoardDTO result = boardService.createBoard(boardDTO);
        System.out.println(result);

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity updateBoard(@RequestBody BoardDTO boardDTO){

        BoardDTO result = boardService.updateBoard(boardDTO);

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping(value ="/{bid}")
    public ResponseEntity deleteBoard(@PathVariable Long bid){

        boardService.deleteBoard(bid);

        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping(value="/like/{bid}")
    public ResponseEntity likeBoard(@RequestHeader(value="Authentication") String auth,@PathVariable Long bid){

        HeaderDTO headerDTO  = util.AuthtoHeader(auth);
        LikeDTO likeDTO = LikeDTO.builder()
                            .userid(headerDTO.getUserid())
                            .bid(bid)
                            .build();

        System.out.println("likeDTO" + likeDTO.getBid());
        System.out.println("likeDTO" + likeDTO.getUserid());
        boardService.likeBoard(likeDTO);

        return new ResponseEntity(HttpStatus.OK);
    }

}
