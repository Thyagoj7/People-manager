package com.manager.peoplemanager.repository;

import com.manager.peoplemanager.dto.request.AddressDTO;
import com.manager.peoplemanager.dto.request.PersonDTO;
import com.manager.peoplemanager.entity.Address;
import com.manager.peoplemanager.entity.Person;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AddressRepository extends JpaRepository<Address, Long> {


}
