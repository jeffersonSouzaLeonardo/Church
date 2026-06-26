package com.br.church.memberManager.infra.inbound.rest;

import com.br.church.memberManager.infra.inbound.rest.dto.PersonRequestDTO;
import com.br.church.memberManager.infra.inbound.rest.dto.PersonResponseDTO;
import com.br.church.memberManager.ports.inbound.PersonCreateUserCase;
import com.br.church.memberManager.ports.inbound.PersonDeleteUseCase;
import com.br.church.memberManager.ports.inbound.PersonFindAllUseCase;
import com.br.church.memberManager.ports.inbound.PersonFindNameUseCase;
import com.br.church.memberManager.ports.inbound.PersonUpdateUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonCreateUserCase personCreateUserCase;
    private final PersonFindAllUseCase personFindAllUseCase;
    private final PersonDeleteUseCase personDeleteUseCase;
    private final PersonFindNameUseCase personFindNameUseCase;
    private final PersonUpdateUseCase personUpdateUseCase;

    public PersonController(PersonCreateUserCase personCreateUserCase, PersonFindAllUseCase personFindAllUseCase,
                            PersonDeleteUseCase personDeleteUseCase, PersonFindNameUseCase personFindNameUseCase,
                            PersonUpdateUseCase personUpdateUseCase) {
        this.personCreateUserCase = personCreateUserCase;
        this.personFindAllUseCase = personFindAllUseCase;
        this.personDeleteUseCase = personDeleteUseCase;
        this.personFindNameUseCase = personFindNameUseCase;
        this.personUpdateUseCase = personUpdateUseCase;
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> create(@Valid @RequestBody PersonRequestDTO inputDTO){
        PersonResponseDTO personResponseDTO = personCreateUserCase.create(inputDTO);
        return ResponseEntity.ok(personResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDTO>> getAll(@RequestHeader HttpHeaders headers){
        return ResponseEntity.ok(personFindAllUseCase.findAll());
    }

    @GetMapping("/{idOrName}")
    public ResponseEntity<List<PersonResponseDTO>> findName(@PathVariable String name){
        return ResponseEntity.ok(personFindNameUseCase.findName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> update(@PathVariable Long id, @Valid @RequestBody PersonRequestDTO inputDTO){
        return ResponseEntity.ok(personUpdateUseCase.update(id, inputDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        personDeleteUseCase.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

