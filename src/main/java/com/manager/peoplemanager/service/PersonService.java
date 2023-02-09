package com.manager.peoplemanager.service;

import com.manager.peoplemanager.dto.request.AddressDTO;
import com.manager.peoplemanager.dto.request.PersonAddressDTO;
import com.manager.peoplemanager.dto.response.MessageResponseDTO;
import com.manager.peoplemanager.entity.Address;
import com.manager.peoplemanager.entity.PersonAddress;
import com.manager.peoplemanager.exception.PersonNotFoundException;
import com.manager.peoplemanager.mapper.AddressMapper;
import com.manager.peoplemanager.mapper.PersonAddressMapper;
import com.manager.peoplemanager.mapper.PersonMapper;
import com.manager.peoplemanager.repository.AddressRepository;
import com.manager.peoplemanager.repository.PersonAddressRepository;
import com.manager.peoplemanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private PersonRepository personRepository;
    private AddressRepository addressRepository;

    private PersonAddressRepository personAddressRepository;

    //Instancia da variavel mapper
    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;
    private final PersonAddressMapper personAddressMapper = PersonAddressMapper.INSTANCE;


    @Autowired
    public PersonService(PersonRepository personRepository, AddressRepository addressRepository, PersonAddressRepository personAddressRepository ) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.personAddressRepository = personAddressRepository;
    }
//    @Autowired
//    public PersonService(AddressRepository addressRepository){
//        this.addressRepository = addressRepository;
//    }
//
    //Criar uma pessoa (Funcionando)
    public MessageResponseDTO createPerson(PersonAddressDTO personAddressDTO) {
        PersonAddress personToSave = personAddressMapper.toModel(personAddressDTO);

        PersonAddress savedPerson = personAddressRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");

    }
    //Editar uma pessoa
    public MessageResponseDTO updateById(Long id, PersonAddressDTO personAddressDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        PersonAddress personToUpdate = personAddressMapper.toModel(personAddressDTO);

        PersonAddress updatedPerson = personAddressRepository.save(personToUpdate);

        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    //Listar uma pessoa
    public PersonAddressDTO findById(Long id) throws PersonNotFoundException {
        PersonAddress personAddress = verifyIfExists(id);

        return personAddressMapper.toDTO(personAddress);
    }

    //Retornar todas as pessoas
    public List<PersonAddressDTO> listAll(){
        List<PersonAddress> allPeople = personAddressRepository.findAll();
        return allPeople.stream()
                .map(personAddressMapper::toDTO)
                .collect(Collectors.toList());
    }
   /* -------------------------------------------------------------------------------------
                                Endereco
    -----------------------------------------------------------------------------------*/

    public Address createAddress(AddressDTO addressDTO)throws PersonNotFoundException {

        Address addressToSave = addressMapper.toModel(addressDTO);

        Address savedAddress = addressRepository.save(addressToSave);

        return savedAddress;

    }
    //Criar um endereço para uma pessoa
    public MessageResponseDTO criarEndereçoParaPessoa(Long id,AddressDTO addressDTO)throws PersonNotFoundException{

        PersonAddressDTO personAddressDTO = null;

        PersonAddress personAddress = verifyIfExists(id);

        Address endereco = createAddress(addressDTO);


        ArrayList<Address> addresses = new ArrayList<Address>();

        addresses.add(endereco);

        personAddress.setAddress(addresses);

        PersonAddress personAddress1  = personAddressRepository.save(personAddress);

        return createMessageResponse(personAddress1.getId()  , "Updated person with ID ");

    }

    //Listar uma pessoa e seu endereço

//    public MessageResponseDTO pessoaAddress(Long id) throws PersonNotFoundException {
//        PersonAddress personAddress = verifyIfExists(id);
//        PersonAddress personAddress1;
//
//        if(personAddress.getAddress().isEmpty()){
//            return createMessageResponse(personAddress.getId()  , "A pessoa ID não constem um endereço ");
//        }else{
//            return createMessageResponse(personAddress.getId()  , "Updated person with ID ");
//        }
//        personAddressMapper.toDTO(personAddress);
//        return null;
//    }

//
//    public PersonDTO findById(Long id) throws PersonNotFoundException {
//        Person person = verifyIfExists(id);
//
//        return personMapper.toDTO(person);
//    }

//
//    //Criar um endereço para uma pessoa
////    public MessageResponseDTO createAddress(Long id, AddressDTO addressDTO) throws PersonNotFoundException {
////        //Long id = personDTO.getId().longValue();
////        //verifyIfExists(id);
////
////        Person person = verifyIfExists(id);
////        personMapper.toDTO(person);
////
////        Address addressToSave = addressMapper.toModel(addressDTO);
////
////        Address savedAddress = addressRepository.save(addressToSave);
////
////
////
////        return createMessageResponse(savedAddress.getId(), "Updated person with ID ");
////    }
//
//
//
//    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
//        verifyIfExists(id);
//
//        Person personToUpdate = personMapper.toModel(personDTO);
//
//        Person updatedPerson = personRepository.save(personToUpdate);
//
//        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
//    }
//
//
//
//
//
//    public List<PersonDTO> listAll(){
//        List<Person> allPeople = personRepository.findAll();
//        return allPeople.stream()
//                .map(personMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    public PersonDTO findById(Long id) throws PersonNotFoundException {
//        Person person = verifyIfExists(id);
//
//        return personMapper.toDTO(person);
//    }
//
    private PersonAddress verifyIfExists(Long id) throws PersonNotFoundException {
        return personAddressRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private PersonAddress verifyIfExistss(Long id) throws PersonNotFoundException {
        return personAddressRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
//
//
//
//
//    public void delete(Long id) throws PersonNotFoundException {
//        verifyIfExists(id);
//        personRepository.deleteById(id);
//    }
//
    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
