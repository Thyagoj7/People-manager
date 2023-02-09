package com.manager.peoplemanager.repository;


import com.manager.peoplemanager.entity.PersonAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long> {
}
