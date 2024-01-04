package com.mp.tractor.code;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public enum CardinalPosition {

    O(-1, 0),
    N(0, 1),
    E(1, 0),
    S(0, -1);

    static {
        var cardinalPositions = values();
        for (int i = 1; i <= 4; i++) {
            CardinalPosition current = cardinalPositions[i % 4];
            current.leftPosition = cardinalPositions[i - 1];
            current.rightPosition = cardinalPositions[(i + 1) % 4];
        }
    }

    final int xMovement;
    final int yMovement;
    CardinalPosition leftPosition;
    CardinalPosition rightPosition;

}
