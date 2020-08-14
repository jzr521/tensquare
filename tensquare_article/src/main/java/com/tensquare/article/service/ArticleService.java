package com.tensquare.article.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    @Autowired
    private IdWorker idWorker;

    public  Article findById(String articleId) {
        return articleDao.selectById(articleId);
    }


    public List<Article> findAll(){
       return articleDao.selectList(null);
    }

    public void save(Article article) {
        //使用分布式id生成器
        String id =idWorker.nextId() +"";
        article.setId(id);
        //初始化数据
        article.setVisits(0);
        article.setThumbup(0);
        article.setComment(0);
        //新增
        articleDao.insert(article);


    }

    public void updateById(Article article) {
            articleDao.updateById(article);
    }

    public void deleteById(String articleId) {
        articleDao.deleteById(articleId);
    }

    public Page<Article> findByPage(Map<String, Object> map, Integer page, Integer size) {
        //设置查询条件
        EntityWrapper<Article> wrapper = new EntityWrapper<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            // if (map.get(key) != null) {
            //     wrapper.eq(key, map.get(key));
            // }

            //第一个参数是否把后面的条件加入到查询条件中
            //和上面的if判断的写法是一样的效果，实现动态sql
            wrapper.eq(map.get(key) != null, key, map.get(key));
        }

        //设置分页参数
        Page<Article> pageData = new Page<>(page, size);

        //执行查询
        //第一个是分页参数，第二个是查询条件
        List<Article> list = articleDao.selectPage(pageData, wrapper);

        pageData.setRecords(list);

        //返回
        return pageData;
    }

}
