package com.boardPractice.boardTest.sample.board.model.entity;

import com.boardPractice.boardTest.sample.board.model.dao.BoardDAO;
import com.boardPractice.boardTest.sample.board.model.dto.BoardDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "TBOARD")
public class Board extends BaseTimeEntity{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="BID")
    private Long bid;
    @Column(name="TITLE")
    private String title;
    @Column(name="CONTENTS")
    private String contents;
    @Column(name="LIKECOUNT")
    private int likeCount;
    @Column(name="USERID")
    private Long userid;

    @Builder
    public Board(Long bid, String title, String contents, int likeCount, Long userid){
        this.bid = bid;
        this.title = title;
        this.contents = contents;
        this.likeCount = likeCount;
        this.userid = userid;
    }

    public BoardDTO toDTO(Board b){
        return BoardDTO.builder()
                .bid(bid)
                .title(title)
                .contents(contents)
                .likeCount(likeCount)
                .userid(userid)
                .build();
    }



}
