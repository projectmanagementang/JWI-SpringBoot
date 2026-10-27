package com.jspl.JindalWorld.repository;

import com.jspl.JindalWorld.entity.NewsItem;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;




@Repository
public interface NewsItemRepository extends MongoRepository<NewsItem, String> {

    List<NewsItem> findByTagIgnoreCaseAndDeletedAtIsNull(String tag);

    List<NewsItem> findByDeletedAtIsNull(Sort sort);
}
