package com.mp.tractor.code;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public enum CardinalPosition {

    O(0, -1),
    N(1, 0),
    E(0, 1),
    S(-1, 0);

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
