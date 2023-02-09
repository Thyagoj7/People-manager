package com.manager.peoplemanager.mapper;

import com.manager.peoplemanager.dto.request.AddressDTO;
import com.manager.peoplemanager.dto.request.PersonAddressDTO;
import com.manager.peoplemanager.dto.request.PersonDTO;
import com.manager.peoplemanager.entity.Person;
import com.manager.peoplemanager.entity.PersonAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PersonAddressMapper {

    PersonAddressMapper INSTANCE = Mappers.getMapper(PersonAddressMapper.class);

    @Mapping(target = "birthDate", source ="birthDate", dateFormat = "dd-MM-yyyy")
    PersonAddress toModel(PersonAddressDTO personAddressDTO);

    PersonAddressDTO toDTO(PersonAddress personAddress);

   // AddressDTO  toDTO(PersonAddress personAddress);




}
