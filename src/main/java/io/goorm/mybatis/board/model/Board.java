package io.goorm.mybatis.board.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Board {

    private Long seq;

    private String title;

    private String contents;

    @JsonProperty("reg_user")
    private String regUser;

    @JsonProperty("reg_date")
    private LocalDateTime regDate;
}
