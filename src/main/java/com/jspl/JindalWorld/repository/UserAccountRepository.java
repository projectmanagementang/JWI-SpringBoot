package com.jspl.JindalWorld.repository;

import com.jspl.JindalWorld.entity.UserAccount;
import org.mapstruct.control.MappingControl;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserAccountRepository extends MongoRepository <UserAccount, Integer> {

    Optional <UserAccount> findByEmail(String email);
}
