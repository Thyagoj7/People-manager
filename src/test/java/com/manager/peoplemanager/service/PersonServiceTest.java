package com.manager.peoplemanager.service;

import com.manager.peoplemanager.dto.request.PersonAddressDTO;
import com.manager.peoplemanager.dto.request.PersonDTO;
import com.manager.peoplemanager.dto.response.MessageResponseDTO;
import com.manager.peoplemanager.entity.Person;
import com.manager.peoplemanager.entity.PersonAddress;
import com.manager.peoplemanager.repository.PersonAddressRepository;
import com.manager.peoplemanager.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.manager.peoplemanager.utils.PersonUtils.createFakeDTO;
import static com.manager.peoplemanager.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;
    @Mock
    private PersonAddressRepository personAddressRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonAddressDTO personAddressDTO = createFakeDTO();
        PersonAddress expectedSavedPerson = createFakeEntity();

        Mockito.when(personAddressRepository.save(any(PersonAddress.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.createPerson(personAddressDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }

}
