package com.ToyProject.ToyProject.board.service;

import com.ToyProject.ToyProject.board.entity.Board;
import com.ToyProject.ToyProject.board.rank.service.RankingService;
import com.ToyProject.ToyProject.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private  BoardRepository repository;
    @Autowired
    private RankingService rankingService;
    public Board createBoard(Board board){

        return repository.save(board);
    }

    public Board getBoard(Long Id){

        Board board = findByBoard(Id);

        board.setView(board.getView() + 1);
        rankingService.calculateAndSetRanks();

        return repository.save(board);
    }

    public Board findByBoard(Long Id){

        Optional<Board> board = repository.findById(Id);

        return board.orElseThrow(() -> new RuntimeException());
    }
}
