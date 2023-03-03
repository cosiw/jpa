package com.boardPractice.boardTest.sample.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
public class HeaderDTO {
    private String auth;
    private Long userid;
}
