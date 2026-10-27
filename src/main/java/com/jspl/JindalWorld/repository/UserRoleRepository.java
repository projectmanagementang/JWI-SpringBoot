package com.jspl.JindalWorld.repository;

import com.jspl.JindalWorld.entity.UserRole;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends MongoRepository <UserRole , Long>{

    List <UserRole> findByUserId(Long userId);

}
