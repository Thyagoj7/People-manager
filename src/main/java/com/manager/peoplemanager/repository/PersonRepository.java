package com.manager.peoplemanager.repository;


import com.manager.peoplemanager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface PersonRepository extends JpaRepository<Person, Long> {
}
