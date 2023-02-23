package com.boardPractice.boardTest;

import com.boardPractice.boardTest.sample.board.model.dao.BoardRepository;
import com.boardPractice.boardTest.sample.board.model.dto.BoardDTO;
import com.boardPractice.boardTest.sample.board.model.entity.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.boardPractice.boardTest.sample.board.model.service.*;
import static org.hamcrest.Matchers.is;

import java.util.Optional;

@SpringBootTest
class BoardTestApplicationTests {

	@Autowired
	private BoardServiceImpl boardService;

	@Autowired
	BoardRepository boardRepository;
	@Test
	public void 게시물생성서비스테스트() {
		BoardDTO requestDTO = new BoardDTO();

		requestDTO.setTitle("TitleTest");
		requestDTO.setContents("ContentsTest");
		requestDTO.setUserid(1L);

		Assertions.assertEquals(requestDTO.getTitle(), boardService.createBoard(requestDTO).getTitle());
		Assertions.assertEquals(requestDTO.getContents(), boardService.createBoard(requestDTO).getContents());
		Assertions.assertEquals(requestDTO.getUserid(), boardService.createBoard(requestDTO).getUserid());
	}

	@Test
	public void 게시글삭제서비스테스트() {

		Optional<Board> board = boardRepository.findById(15L);
		Assertions.assertTrue(board.isPresent());

		if(board.isPresent())
		 boardRepository.deleteById(15L);

		Optional<Board> deleteboard = boardRepository.findById(14L);


		Assertions.assertFalse(deleteboard.isPresent());
	}

	@Test
	public void 게시글조회서비스테스트() {
		BoardDTO requestDTO = new BoardDTO();
		requestDTO.setUserid(3L);
		requestDTO.setTitle("getTest");
		requestDTO.setContents("getTestCont");

		BoardDTO insertBoard = boardService.createBoard(requestDTO);
		Optional<Board> board = boardRepository.findById(insertBoard.getBid());
		BoardDTO boardDTO = board.get().toDTO(board.get());

		assertThat(insertBoard).isEqualTo(boardDTO);
	}

	@Test
	public void 게시글수정서비스테스트(){
		BoardDTO insertRequest = BoardDTO.builder()
				.title("생성")
				.contents("웃었어")
				.userid(3L)
				.build();

		BoardDTO insert = boardService.createBoard(insertRequest);

		BoardDTO updateRequest = BoardDTO.builder()
				.bid(insert.getBid())
				.title("수정")
				.contents("가끔")
				.build();

		BoardDTO update = boardService.updateBoard(updateRequest);

		Optional<Board> findBoard = boardRepository.findById(insert.getBid());
		BoardDTO findBoardDTO = findBoard.get().toDTO(findBoard.get());

		assertThat(updateRequest).isEqualTo(findBoardDTO);

	}

}
