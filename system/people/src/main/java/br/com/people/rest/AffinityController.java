package br.com.people.rest;

import br.com.people.dto.AffinityDto;
import br.com.people.service.AffinityService;
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
public class AffinityController {

    @Autowired
    private AffinityService affinityService;

    @Operation(summary = "Adiciona nova afinidade")
    @PostMapping(path = "/afinidade", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPerson(@RequestBody final AffinityDto affinityDto) {
        String id = affinityService.save(affinityDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

}
