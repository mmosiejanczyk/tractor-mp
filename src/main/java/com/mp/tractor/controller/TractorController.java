package com.mp.tractor.controller;

import com.mp.tractor.code.Command;
import com.mp.tractor.dto.Position;
import com.mp.tractor.dto.TractorCommand;
import com.mp.tractor.exception.InvalidPayloadException;
import com.mp.tractor.service.TractorService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TractorController {

    private final TractorService tractorService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/move", consumes = MediaType.TEXT_PLAIN_VALUE)
    public String computeTractorPosition(@NotNull @RequestBody String tractorRequest) {
        var command = convertRequest(tractorRequest);
        return tractorService.moveTractor(command).toString();
    }


    private TractorCommand convertRequest(String tractorRequest) {
        var lines = tractorRequest.split(System.lineSeparator(), -1);
        if (lines.length != 2) {
            throw new InvalidPayloadException("Payload does not contains 2 lines");
        }

        var initialPosition = new Position(lines[0]);
        var commands = lines[1].chars()
                .mapToObj(e -> (char) e)
                .map(Object::toString)
                .map(Command::valueOf)
                .toList();

        return new TractorCommand(initialPosition, commands);
    }
}
