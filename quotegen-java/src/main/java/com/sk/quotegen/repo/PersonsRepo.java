package com.sk.quotegen.repo;

import com.sk.quotegen.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepo extends JpaRepository<Persons, Integer> {

    Persons findByPid(int pid);

    Persons findByUsernameAndPasscode (String username, String password );

}
