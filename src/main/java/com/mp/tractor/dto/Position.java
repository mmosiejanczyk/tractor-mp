package com.mp.tractor.dto;

import com.mp.tractor.code.CardinalPosition;
import com.mp.tractor.exception.InvalidPositionException;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    int x;
    int y;
    CardinalPosition cardinalPosition;

    public Position(String position) {
        position = position.replace("(", "");
        position = position.replace(")", "");
        var splitPositions = position.split(",", -1);
        if (splitPositions.length != 3) {
            throw new InvalidPositionException("Initial position is malformed");
        }
        try {
            this.x = Integer.parseInt(splitPositions[0]);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidPositionException("X position %s is invalid".formatted(splitPositions[0]));
        }
        try {
            this.y = Integer.parseInt(splitPositions[1]);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidPositionException("Y position %s is invalid".formatted(splitPositions[1]));
        }

        try {
            this.cardinalPosition = CardinalPosition.valueOf(splitPositions[2]);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new InvalidPositionException("Cardinal position %s is invalid".formatted(splitPositions[2]));
        }
    }

    @Override
    public String toString() {
        return "(%d,%d,%s)".formatted(x, y, cardinalPosition.name());
    }


    public void toLeft() {
        this.cardinalPosition = this.cardinalPosition.getLeftPosition();
    }

    public void toRight() {
        this.cardinalPosition = this.cardinalPosition.getRightPosition();
    }

    public boolean isValidMove() {
        return this.x + this.cardinalPosition.getXMovement() >= 0 && this.y + this.cardinalPosition.getYMovement() >= 0;
    }

    public void move() {
        this.x += this.cardinalPosition.getXMovement();
        this.y += this.cardinalPosition.getYMovement();
    }
}
