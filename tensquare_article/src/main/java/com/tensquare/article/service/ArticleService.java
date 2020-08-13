package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tensquare_parent
 * @description:
 * @author: Mr.Jiang
 * @create: 2020-08-13 17:16
 **/
@Service
public class ArticleService  {
    @Autowired
    private ArticleDao articleDao;
    public List<Article> findAll(){
       return articleDao.selectList(null);
    }
}
