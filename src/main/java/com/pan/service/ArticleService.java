package com.pan.service;

import com.pan.pojo.Article;
import com.pan.pojo.PageBean;

public interface ArticleService {
    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId, String state);

    Article findArticleById(Integer id);

    void update(Article article);

    void delete(Integer id);
}
