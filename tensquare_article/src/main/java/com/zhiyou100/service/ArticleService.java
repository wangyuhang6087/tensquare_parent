package com.zhiyou100.service;

import com.zhiyou100.dao.ArticleDao;
import com.zhiyou100.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author:Rain
 * @date 2019/11/2 10:10
 * @desc
 */
@Service
@Transactional   // 不加报错, @Modifying增删改需要使用
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    RedisTemplate redisTemplate;

    public void updateState(String id) {
        redisTemplate.delete("article" + id);
        articleDao.updateState(id);
    }

    // 更新缓存
    public void addThumbup(String id) {
        redisTemplate.delete("article" + id);
        articleDao.addThumbup(id);
    }


    public Article findById(String id){
        // 先从缓存中查当前对象
        Article article = (Article)redisTemplate.opsForValue().get("article" + id);
        System.out.println("从当前缓存中查出 :　" + article);
        // 如果没有找到
        if (article == null){
            // 从数据库中查询
            article = articleDao.findById(id).get();
            System.out.println("从数据库中查询出: " + article);
            redisTemplate.opsForValue().set("article" + id,article);
            redisTemplate.opsForValue().set("article" + id,article,10, TimeUnit.SECONDS);
        }
        return article;
    }

}