package com.jspl.JindalWorld.repository;

import com.jspl.JindalWorld.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,Long> {

}
