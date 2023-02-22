package com.boardPractice.boardTest.sample.board.model.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.boardPractice.boardTest.sample.board.model.entity.*;
public interface BoardRepository extends JpaRepository<Board, Long> {



}
