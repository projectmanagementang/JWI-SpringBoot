package com.jspl.JindalWorld.repository;

import com.jspl.JindalWorld.entity.UserAccount;
import org.mapstruct.control.MappingControl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends MongoRepository <UserAccount, Long> {

    Optional <UserAccount> findByEmail(String email);
}
