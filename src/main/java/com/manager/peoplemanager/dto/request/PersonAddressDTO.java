package com.manager.peoplemanager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonAddressDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    private String birthDate;

    private List<AddressDTO> address;
}
