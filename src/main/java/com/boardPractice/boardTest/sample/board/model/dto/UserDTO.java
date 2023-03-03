package com.boardPractice.boardTest.sample.board.model.dto;

import com.boardPractice.boardTest.sample.board.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UserDTO {
    private Long userid;
    private String accountid;
    private String password;
    private String nickname;
    private String accountType;
    private int quit;

    @Builder
    public UserDTO(Long userid, String accountid, String password,  String nickname, String accountType, int quit){
        this.userid = userid;
        this.accountid = accountid;
        this.password = password;
        this.nickname = nickname;
        this.accountType = accountType;
        this.quit = quit;
    }

    public User toEntity(){
        return User.builder()
                .userid(userid)
                .accountid(accountid)
                .password(password)
                .nickname(nickname)
                .accountType(accountType)
                .quit(quit)
                .build();
    }
}


















