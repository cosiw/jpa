package com.boardPractice.boardTest.sample.board.model.entity;

import com.boardPractice.boardTest.sample.board.model.dto.UserDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity(name="TUSER")
public class User  extends BaseTimeEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long userid;
    @Column
    private String accountid;
    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private String accountType;
    @Column
    private int quit;

    @Builder
    public User(Long userid, String accountid, String password, String nickname, String accountType, int quit){
        this.userid = userid;
        this.accountid = accountid;
        this.password = password;
        this.nickname = nickname;
        this.accountType = accountType;
        this.quit = quit;
    }

    public UserDTO toDTO(User user){
        return UserDTO.builder()
                .userid(userid)
                .accountid(accountid)
                .password(password)
                .nickname(nickname)
                .accountType(accountType)
                .quit(quit)
                .build();
    }
}
