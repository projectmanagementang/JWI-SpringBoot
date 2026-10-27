
package com.jspl.JindalWorld.service;

import com.jspl.JindalWorld.dto.NewsItemResponse;
import com.jspl.JindalWorld.entity.NewsItem;
import com.jspl.JindalWorld.mapper.NewsItemMapper;
import com.jspl.JindalWorld.repository.NewsItemRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsItemService {

    private final NewsItemRepository newsItemRepository;
    private final NewsItemMapper newsItemMapper;

    @Transactional(readOnly = true)
    public List<NewsItemResponse> getNewsItems(
            String tag,
            String order
    ) {
        Sort.Direction direction = "oldest".equalsIgnoreCase(order)
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        Sort sort = Sort.by(direction, "createdAt");

        List<NewsItem> newsItems;

        if (tag != null && !tag.isBlank()) {
            newsItems = newsItemRepository
                    .findByTagIgnoreCaseAndDeletedAtIsNull(tag);

            newsItems.sort((first, second) ->
                    direction.isAscending()
                            ? first.getCreatedAt().compareTo(second.getCreatedAt())
                            : second.getCreatedAt().compareTo(first.getCreatedAt()));
        } else {
            newsItems = newsItemRepository.findByDeletedAtIsNull(sort);
        }

        return newsItems.stream()
                .map(newsItemMapper::toResponse)
                .toList();
    }
}
