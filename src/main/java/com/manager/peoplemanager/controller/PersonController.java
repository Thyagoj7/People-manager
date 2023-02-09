package com.manager.peoplemanager.controller;

import com.manager.peoplemanager.dto.request.AddressDTO;
import com.manager.peoplemanager.dto.request.PersonAddressDTO;
import com.manager.peoplemanager.dto.request.PersonDTO;
import com.manager.peoplemanager.dto.response.MessageResponseDTO;
import com.manager.peoplemanager.entity.PersonAddress;
import com.manager.peoplemanager.exception.PersonNotFoundException;
import com.manager.peoplemanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    //Criar Pessoa
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonAddressDTO personAddressDTO) {
        return personService.createPerson(personAddressDTO);
    }

    //Editar Pessoa
        @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonAddressDTO personAddressDTO) throws PersonNotFoundException {
        return personService.updateById(id, personAddressDTO);
    }

    //Listar uma pessoa
        @GetMapping("/{id}")
    public PersonAddressDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    //Listar todas as pessoas
        @GetMapping
    public List<PersonAddressDTO> listAll(){
        return personService.listAll();
    }




    @PutMapping("/address/{id}")
    public MessageResponseDTO createAddress(@PathVariable Long id, @RequestBody @Valid AddressDTO addressDTO) throws PersonNotFoundException {
        return personService.criarEndereçoParaPessoa(id, addressDTO);
    }

//    @GetMapping
//    public List<PersonDTO> listAll(){
//        return personService.listAll();
//    }
//
//    @GetMapping("/{id}")
//    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
//        return personService.findById(id);
//    }
//
//
//    @PutMapping("/{id}")
//    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
//        return personService.updateById(id, personDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
//        personService.delete(id);
//    }


}
