package com.manager.peoplemanager.mapper;

import com.manager.peoplemanager.dto.request.AddressDTO;
import com.manager.peoplemanager.dto.request.PersonAddressDTO;
import com.manager.peoplemanager.dto.request.PersonDTO;
import com.manager.peoplemanager.entity.Address;
import com.manager.peoplemanager.entity.Person;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source ="birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);    //--> toDTO



}
