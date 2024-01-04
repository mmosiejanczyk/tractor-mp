package com.mp.tractor.service;

import com.mp.tractor.dto.Position;
import com.mp.tractor.dto.TractorCommand;
import com.mp.tractor.exception.InvalidMoveException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TractorService {

    public Position moveTractor(TractorCommand tractorCommand) {
        var position = tractorCommand.getPosition();
        tractorCommand.getCommands().forEach(command -> {
            switch (command) {
                case A -> {
                    if (position.isValidMove()) {
                        position.move();
                    } else {
                        throw new InvalidMoveException("Sequence moves would go out of field");
                    }
                }
                case G -> position.toLeft();
                case D -> position.toRight();
            }
        });
        return position;
    }


}
