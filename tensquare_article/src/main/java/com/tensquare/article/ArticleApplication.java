package com.tensquare.article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @program: tensquare_parent
 * @description:
 * @author: Mr.Jiang
 * @create: 2020-08-13 16:54
 **/
@SpringBootApplication
@MapperScan("com.tensquare.article.dao")
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class,args);
    }
    @Bean
    public IdWorker createIdWorker() {
        return new IdWorker(1, 1);
    }
}
