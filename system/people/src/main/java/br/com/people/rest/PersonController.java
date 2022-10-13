package br.com.people.rest;

import br.com.people.dto.PersonDto;
import br.com.people.dto.response.PersonResponse;
import br.com.people.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @Operation(summary = "Cadastra Pessoa")
    @PostMapping(path = "/pessoa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPerson(@Valid  @RequestBody final PersonDto personDto) {
       Long id = personService.save(personDto);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
       return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Obtém Pessoa")
    @GetMapping(path = "/pessoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> getPerson(@PathVariable final Long id) {
        var personResponseOptional = personService.getPerson(id);
        if (personResponseOptional.isPresent()) {
            return ResponseEntity.ok(personResponseOptional.get());
        }
        return ResponseEntity.noContent().build();
    }


}
