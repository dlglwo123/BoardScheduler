package com.ToyProject.ToyProject.board.rank.controller;

import com.ToyProject.ToyProject.board.entity.Board;
import com.ToyProject.ToyProject.board.rank.service.RankingService;
import com.ToyProject.ToyProject.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rank")
public class RankingController {

    @Autowired
    private RankingService service;

    @GetMapping("/top")
    public ResponseEntity<List<Board>> getTopRankedPosts(@RequestParam(name = "limit", defaultValue = "10") int limit) {
        List<Board> topPosts = service.getTopRankedPosts(limit);

        return ResponseEntity.ok(topPosts);
    }
}
