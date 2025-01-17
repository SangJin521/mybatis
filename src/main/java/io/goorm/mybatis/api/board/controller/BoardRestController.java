package io.goorm.mybatis.api.board.controller;

import io.goorm.mybatis.api.board.service.BoardService;
import io.goorm.mybatis.board.model.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BoardRestController {

    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public String index() {
        return "api index";
    }

    @GetMapping("/boards")
    public List<Board> list() {

        List<Board> list = boardService.getBoards();

        log.debug("list size : " + list.size());
        log.debug("test ");
        return list;
    }

    //상세보기
    @GetMapping("/board/{seq}")
    public Board get(@PathVariable Long seq) {
            log.debug("seq : " + seq);

            return boardService.getBoardById(seq);
    }

    //등록
    @PostMapping("/boards")
    public int post(@RequestBody Board board) {

        log.debug("title : " + board.getTitle());
        log.debug("contents : " + board.getContents());
        log.debug("reguser : " + board.getRegUser());

        return boardService.createBoard(board);
    }

    //수정
    @PutMapping("/boards")
    public Board put(@RequestBody Board board) {

        log.debug("seq : " + board.getSeq());
        log.debug("title : " + board.getTitle());
        log.debug("contents : " + board.getContents());
        log.debug("reguser : " + board.getRegUser());

        return boardService.updateBoard(board);
    }

    //삭제
    @DeleteMapping("/boards/{seq}")
    public boolean delete(@PathVariable Long seq) {

        log.debug("seq : " + seq);

        return boardService.deleteBoard(seq);
    }
}
