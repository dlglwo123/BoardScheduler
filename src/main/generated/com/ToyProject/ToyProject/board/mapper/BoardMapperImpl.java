package com.ToyProject.ToyProject.board.mapper;

import com.ToyProject.ToyProject.board.dto.BoardDto;
import com.ToyProject.ToyProject.board.entity.Board;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-25T17:39:55+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class BoardMapperImpl implements BoardMapper {

    @Override
    public Board PostToBoard(BoardDto.Post post) {
        if ( post == null ) {
            return null;
        }

        Board.BoardBuilder board = Board.builder();

        board.title( post.getTitle() );
        board.detail( post.getDetail() );

        return board.build();
    }

    @Override
    public BoardDto.Response BoardToResponse(Board board) {
        if ( board == null ) {
            return null;
        }

        BoardDto.Response response = new BoardDto.Response();

        response.setTitle( board.getTitle() );
        response.setDetail( board.getDetail() );
        response.setView( board.getView() );
        response.setRank( board.getRank() );

        return response;
    }
}
