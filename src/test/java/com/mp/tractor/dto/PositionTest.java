package com.mp.tractor.dto;

import com.mp.tractor.code.CardinalPosition;
import com.mp.tractor.exception.InvalidPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class PositionTest {

    @Test
    void testPosition_invalid_length() {
        var ex = Assertions.assertThrows(InvalidPositionException.class, () -> new Position(""));
        Assertions.assertEquals("Initial position is malformed", ex.getMessage());
    }

    @Test
    void testPosition_invalid_x() {
        var ex = Assertions.assertThrows(InvalidPositionException.class, () -> new Position("(A,A,A)"));
        Assertions.assertEquals("X position A is invalid", ex.getMessage());
    }

    @Test
    void testPosition_invalid_y() {
        var ex = Assertions.assertThrows(InvalidPositionException.class, () -> new Position("(10,A,A)"));
        Assertions.assertEquals("Y position A is invalid", ex.getMessage());
    }

    @Test
    void testPosition_invalid_cardinal() {
        var ex = Assertions.assertThrows(InvalidPositionException.class, () -> new Position("(0,0,A)"));
        Assertions.assertEquals("Cardinal position A is invalid", ex.getMessage());
    }

    @Test
    void testPosition_valid() {
        var position = new Position("(1,4,N)");
        Assertions.assertEquals(1, position.getX());
        Assertions.assertEquals(4, position.getY());
        Assertions.assertEquals(CardinalPosition.N, position.getCardinalPosition());
    }

    @ParameterizedTest
    @EnumSource(CardinalPosition.class)
    void testMove(CardinalPosition cardinalPosition) {
        var position = new Position();
        position.setCardinalPosition(cardinalPosition);
        position.move();
        Assertions.assertEquals(cardinalPosition.getXMovement(), position.getX());
        Assertions.assertEquals(cardinalPosition.getYMovement(), position.getY());
    }

    @Test
    void testIsValidMove_invalid() {
        var position = new Position();
        position.setCardinalPosition(CardinalPosition.S);
        Assertions.assertFalse(position.isValidMove());
    }

    @Test
    void testIsValidMove_valid() {
        var position = new Position();
        position.setCardinalPosition(CardinalPosition.N);
        Assertions.assertTrue(position.isValidMove());
    }

    @Test
    void testToLeft() {
        var position = new Position();
        position.setCardinalPosition(CardinalPosition.N);
        position.toLeft();
        Assertions.assertEquals(CardinalPosition.N.getLeftPosition(), position.getCardinalPosition());
    }

    @Test
    void testToRight() {
        var position = new Position();
        position.setCardinalPosition(CardinalPosition.N);
        position.toRight();
        Assertions.assertEquals(CardinalPosition.N.getRightPosition(), position.getCardinalPosition());
    }
}
