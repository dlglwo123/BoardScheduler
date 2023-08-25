package com.ToyProject.ToyProject.board.repository;

import com.ToyProject.ToyProject.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findAllByOrderByViewDesc();
}
