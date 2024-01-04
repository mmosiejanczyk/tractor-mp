package com.mp.tractor.service;

import com.mp.tractor.code.CardinalPosition;
import com.mp.tractor.code.Command;
import com.mp.tractor.dto.Position;
import com.mp.tractor.dto.TractorCommand;
import com.mp.tractor.exception.InvalidMoveException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class TractorServiceTest {

    @InjectMocks
    TractorService tractorService;

    @Test
    void testMoveTractor_invalid_move() {
        var tractorCommand = new TractorCommand();
        tractorCommand.setCommands(List.of(Command.A));
        tractorCommand.setPosition(new Position(0, 0, CardinalPosition.S));
        Assertions.assertThrows(InvalidMoveException.class, () -> tractorService.moveTractor(tractorCommand));
    }

    @Test
    void testMoveTractor_move_up() {
        var tractorCommand = new TractorCommand();
        tractorCommand.setCommands(List.of(Command.A));
        tractorCommand.setPosition(new Position(0, 0, CardinalPosition.N));
        var finalPosition = tractorService.moveTractor(tractorCommand);
        Assertions.assertEquals(1, finalPosition.getX());
        Assertions.assertEquals(0, finalPosition.getY());
        Assertions.assertEquals(CardinalPosition.N, finalPosition.getCardinalPosition());
    }

    @Test
    void testMoveTractor_move_left() {
        var tractorCommand = new TractorCommand();
        tractorCommand.setCommands(List.of(Command.G));
        tractorCommand.setPosition(new Position(0, 0, CardinalPosition.N));
        var finalPosition = tractorService.moveTractor(tractorCommand);
        Assertions.assertEquals(0, finalPosition.getX());
        Assertions.assertEquals(0, finalPosition.getY());
        Assertions.assertEquals(CardinalPosition.O, finalPosition.getCardinalPosition());
    }

    @Test
    void testMoveTractor_move_Right() {
        var tractorCommand = new TractorCommand();
        tractorCommand.setCommands(List.of(Command.D));
        tractorCommand.setPosition(new Position(0, 0, CardinalPosition.N));
        var finalPosition = tractorService.moveTractor(tractorCommand);
        Assertions.assertEquals(0, finalPosition.getX());
        Assertions.assertEquals(0, finalPosition.getY());
        Assertions.assertEquals(CardinalPosition.E, finalPosition.getCardinalPosition());
    }
}
