package com.boardPractice.boardTest.sample.board.model.dto;

import com.boardPractice.boardTest.sample.board.model.entity.Like;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
@Getter
public class LikeDTO  {
    private Long likeid;
    private Long userid;
    private Long bid;


    @Builder
    public LikeDTO(Long likeid, Long userid, Long bid){
        this.likeid = likeid;
        this.userid = userid;
        this.bid = bid;
    }

    public Like toEntity(){
        return Like.builder()
                .likeid(likeid)
                .build();
    }
}
