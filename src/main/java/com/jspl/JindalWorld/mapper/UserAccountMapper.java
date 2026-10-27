package com.jspl.JindalWorld.mapper;


import com.jspl.JindalWorld.dto.UsertAccountResponse;
import com.jspl.JindalWorld.entity.UserAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

    public UsertAccountResponse toResponse(UserAccount userAccount);
}
