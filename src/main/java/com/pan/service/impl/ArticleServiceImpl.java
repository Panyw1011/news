package com.pan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pan.mapper.ArticleMapper;
import com.pan.pojo.Article;
import com.pan.pojo.PageBean;
import com.pan.service.ArticleService;
import com.pan.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        article.setCreateUser(id);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId, String state) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");

        PageBean<Article> ap = new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);

        List<Article> al = articleMapper.list(categoryId,state,id);
        Page<Article> p = (Page<Article>) al;
        ap.setTotal(p.getTotal());
        ap.setItems(p.getResult());
        return ap;
    }

    @Override
    public Article findArticleById(Integer id) {
        Article article = articleMapper.findById(id);
        return article;
    }

    @Override
    public void update(Article article) {
        articleMapper.update(article);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);
    }
}
