package com.boardPractice.boardTest.sample.board.model.entity;

import com.boardPractice.boardTest.sample.board.model.dto.LikeDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name="TLIKE")
public class Like  extends BaseTimeEntity{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long likeid;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;

    @ManyToOne
    @JoinColumn(name="bid")
    private Board board;

    @Builder
    public Like (Long likeid, User user, Board board){
        this.likeid = likeid;
        this.user = user;
        this.board = board;
    }

    public LikeDTO toDto(Like like){
        return LikeDTO.builder()
                .likeid(likeid)
                .userid(user.getUserid())
                .bid(board.getBid())
                .build();
    }
}
