package io.goorm.mybatis.board.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Board {

    private Long seq;

    private String title;

    private String contents;
    
}
