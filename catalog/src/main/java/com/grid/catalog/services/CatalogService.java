package com.grid.catalog.services;

import com.grid.catalog.models.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatalogService {

    Article getArticleByUniqueId(String uniqueId);

    List<Article> getArticlesBySku(String sku);

}
