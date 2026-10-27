package com.jspl.JindalWorld.mapper;

import com.jspl.JindalWorld.dto.NewsItemResponse;
import com.jspl.JindalWorld.entity.NewsItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsItemMapper {

//     class_of_dto toDTO(entity);


    NewsItemResponse toResponse(NewsItem newsItem);


}
