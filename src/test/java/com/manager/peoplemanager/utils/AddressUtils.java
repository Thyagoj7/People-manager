package com.manager.peoplemanager.utils;

import com.manager.peoplemanager.dto.request.AddressDTO;
import com.manager.peoplemanager.entity.Address;

public class AddressUtils {
    private static final String PUBLIC_PLACE = "1199999-9999";
    private static final String ZIP_CODE= "RUA A";
    private static final long NUMBER = 10;
    private static final String CITY = "Rio de Janeiro";
    private static final long ID = 1L;


    public static AddressDTO createFakeDTO() {
        return AddressDTO.builder()
                .publicPlace(PUBLIC_PLACE)
                .zipCode(ZIP_CODE)
                .number(NUMBER)
                .city(CITY)
                .build();
    }

    public static Address createFakeEntity() {
        return Address.builder()
                .id(ID)
                .publicPlace(PUBLIC_PLACE)
                .zipCode(ZIP_CODE)
                .number(NUMBER)
                .city(CITY)
                .build();
    }
}
