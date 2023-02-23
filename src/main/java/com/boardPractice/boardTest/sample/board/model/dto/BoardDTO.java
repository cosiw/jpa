package com.boardPractice.boardTest.sample.board.model.dto;

import com.boardPractice.boardTest.sample.board.model.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BoardDTO {
    private Long bid;
    private String title;
    private String contents;
    private Long userid;
    private int likecount;
    private String crTime;
    private String modTime;
    private String delTime;
    private int likeChecked;

    @Builder
    public BoardDTO(Long bid, String title, String contents, Long userid, int likecount) {
        this.bid = bid;
        this.title = title;
        this.contents = contents;
        this.userid = userid;
        this.likecount = likecount;

    }

    public Board toEntity(){
        return Board.builder()
                .bid(bid)
                .title(title)
                .contents(contents)
                .userid(userid)
                .likecount(likecount)
                .build();

    }
}
