package com.jspl.JindalWorld.repository;

import com.jspl.JindalWorld.entity.UserRole;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRoleRepository extends MongoRepository <UserRole , Integer>{

    List <UserRole> findByUserId(Integer userId);

}
