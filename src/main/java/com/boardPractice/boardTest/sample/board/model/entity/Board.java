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
    @Column
    private Long bid;
    @Column
    private String title;
    @Column
    private String contents;
    @Column
    private int likecount;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @Builder
    public Board(Long bid, String title, String contents, int likecount, User user){
        this.bid = bid;
        this.title = title;
        this.contents = contents;
        this.likecount = likecount;
        this.user = user;
    }

    public BoardDTO toDTO(Board b){
        return BoardDTO.builder()
                .bid(bid)
                .title(title)
                .contents(contents)
                .likecount(likecount)
                .userid(user.getUserid())
                .build();
    }



}
