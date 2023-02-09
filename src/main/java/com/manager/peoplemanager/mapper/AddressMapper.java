package com.manager.peoplemanager.mapper;

import com.manager.peoplemanager.dto.request.AddressDTO;
import com.manager.peoplemanager.entity.Address;
import com.manager.peoplemanager.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);


    Address toModel(AddressDTO addressDTO);

    AddressDTO toDTO(Address address);    //--> toDTO
}
