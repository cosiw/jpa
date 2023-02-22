package com.boardPractice.boardTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.boardPractice.boardTest.sample.board.model.service.*;

@SpringBootTest
class BoardTestApplicationTests {

	@Autowired
	private BoardServiceImpl boardService;
	@Test
	public void save() {
//		Board.RequestDto requestDto = new Board.RequestDto();
//		requestDto.setTitle("제목11");
//		requestDto.setContents("내용11");
//		requestDto.setUseYn("Y");
//		requestDto.setRegisterId(117L);
//		requestDto.setModifyId(117L);
//
//		Assertions.assertNotEquals(0, boardService.save(requestDto));
//		Assertions.assertNotEquals(0, boardService.save(requestDto));
	}

}
