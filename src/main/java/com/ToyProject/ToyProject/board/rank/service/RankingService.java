package com.ToyProject.ToyProject.board.rank.service;

import com.ToyProject.ToyProject.board.entity.Board;
import com.ToyProject.ToyProject.board.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Slf4j
@Service
@Transactional
public class RankingService {
    @Autowired
    private BoardRepository repository;

    // Todo : 오름차순 PageNation
    public List<Board> getTopRankedPosts(int limit){

        PageRequest pageable = PageRequest.of(0,limit, Sort.by(Sort.Direction.DESC, "view"));
        Page<Board> topPosts = repository.findAll(pageable);

        return topPosts.getContent();
    }

    // Todo : ranking System

    @Scheduled(cron = "0/10 * * * * *")
    public void calculateAndSetRanks() {
        List<Board> rankedPosts = repository.findAllByOrderByViewDesc();

        for (int i = 0; i < rankedPosts.size(); i++) {
            rankedPosts.get(i).setRank(i + 1);
        }
        repository.saveAll(rankedPosts);
        log.info("[Sccess Ranking System]");
    }
}
