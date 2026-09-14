package com.br.church.controller;

import com.br.church.dto.PersonRequestDTO;
import com.br.church.dto.PersonResponseDTO;
import com.br.church.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> create(@Valid @RequestBody PersonRequestDTO inputDTO) {
        return ResponseEntity.ok(personService.create(inputDTO));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDTO>> getAll(@RequestHeader HttpHeaders headers) {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PersonResponseDTO>> findName(@PathVariable String name) {
        return ResponseEntity.ok(personService.findName(name));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> update(@PathVariable Long id, @Valid @RequestBody PersonRequestDTO inputDTO) {
        return ResponseEntity.ok(personService.update(id, inputDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
