package com.mp.tractor.dto;

import com.mp.tractor.code.Command;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TractorCommand {
    Position position;
    List<Command> commands;
}
