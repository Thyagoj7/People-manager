package com.manager.peoplemanager.utils;

import com.manager.peoplemanager.dto.request.PersonAddressDTO;
import com.manager.peoplemanager.dto.request.PersonDTO;
import com.manager.peoplemanager.entity.Address;
import com.manager.peoplemanager.entity.Person;
import com.manager.peoplemanager.entity.PersonAddress;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    private static final String NAME = "Rodrigo";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonAddressDTO createFakeDTO() {
        return PersonAddressDTO.builder()
                .name(NAME)
                .birthDate("01-10-2010")
                .address(Collections.singletonList(AddressUtils.createFakeDTO()))
                .build();
    }

    public static PersonAddress createFakeEntity() {
        return PersonAddress.builder()
                .id(PERSON_ID)
                .name(NAME)
                .birthDate(BIRTH_DATE)
                .address(Collections.singletonList(AddressUtils.createFakeEntity()))
                .build();
    }
}
