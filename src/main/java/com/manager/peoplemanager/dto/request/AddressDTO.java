package com.manager.peoplemanager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    @NotEmpty
    @Size(min = 0, max = 100)
    private String publicPlace;

    @NotEmpty
    @Size(min = 0, max = 9)
    private String zipCode;

    @NotNull
    private Long number;

    @NotEmpty
    @Size(min = 0, max = 100)
    private String city;

}
