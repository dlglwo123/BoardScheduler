package com.ToyProject.ToyProject.board.mapper;

import com.ToyProject.ToyProject.board.dto.BoardDto;
import com.ToyProject.ToyProject.board.entity.Board;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board PostToBoard(BoardDto.Post post);
    BoardDto.Response BoardToResponse(Board board);
}
