package br.com.people.rest;

import br.com.people.dto.PersonDto;
import br.com.people.dto.ScoreDto;
import br.com.people.service.ScoreService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Operation(summary = "Add New Score")
    @PostMapping(path = "/score", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> createScore(@RequestBody final ScoreDto scoreDto) {
        Integer id = scoreService.save(scoreDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
