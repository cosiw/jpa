package com.boardPractice.boardTest.sample.board.model.dao;

import com.boardPractice.boardTest.sample.board.model.entity.Board;
import com.boardPractice.boardTest.sample.board.model.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeRepository extends JpaRepository<Like, Long> {

    @Query(value="SELECT likeid, crtime, bid, userid, modtime FROM tlike WHERE bid = :bid and userid = :userid ", nativeQuery = true)
    public Like selectlike(@Param("bid") Long bid, @Param("userid") Long userid);

}
