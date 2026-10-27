package com.jspl.JindalWorld.controller;

import com.jspl.JindalWorld.dto.NewsItemResponse;
import com.jspl.JindalWorld.service.NewsItemService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news-items")
public class NewsItemController {

    private final NewsItemService newsItemService;

    public NewsItemController(NewsItemService newsItemService) {
        this.newsItemService = newsItemService;
    }

    @GetMapping
    public List<NewsItemResponse> getNewsItems(
            @RequestParam(required = false) String tag,
            @RequestParam(defaultValue = "latest") String order
    ) {
        return newsItemService.getNewsItems(tag, order);
    }
}
