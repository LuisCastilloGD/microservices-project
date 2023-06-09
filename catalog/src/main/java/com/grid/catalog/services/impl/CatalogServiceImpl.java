package com.grid.catalog.services.impl;

import com.grid.catalog.exceptions.ArticleNotFoundedException;
import com.grid.catalog.models.Article;
import com.grid.catalog.repositories.ArticleRepository;
import com.grid.catalog.services.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final ArticleRepository articleRepository;

    @Override
    public Article getArticleByUniqueId(final String uniqueId) {
        return articleRepository.findByUniqId(uniqueId)
                             .orElseThrow(ArticleNotFoundedException::new);
    }

    @Override
    public List<Article> getArticlesBySku(final String sku) {
        return articleRepository.findBySku(sku)
                                .stream()
                                .toList();

    }
}
