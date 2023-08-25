package com.ToyProject.ToyProject.board.controller;

import com.ToyProject.ToyProject.board.dto.BoardDto;
import com.ToyProject.ToyProject.board.entity.Board;
import com.ToyProject.ToyProject.board.mapper.BoardMapper;
import com.ToyProject.ToyProject.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private static final String BOARD_URI = "/board";
    private final BoardService service;
    private final BoardMapper mapper;

    // Todo : 게시글 등록
    @PostMapping
    public ResponseEntity postBoard(@RequestBody BoardDto.Post post){

       Board board = service.createBoard(mapper.PostToBoard(post));

       return ResponseEntity.ok("create Board");
    }

    // Todo : 게시글 조회
    @GetMapping("/{Id}")
    public ResponseEntity getBoard(@PathVariable("Id") Long Id){

        Board board = service.getBoard(Id);

        return new ResponseEntity(mapper.BoardToResponse(board), HttpStatus.OK);
    }
}
