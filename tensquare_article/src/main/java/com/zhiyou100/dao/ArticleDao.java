package com.zhiyou100.dao;

import com.zhiyou100.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author:Rain
 * @date 2019/11/2 10:13
 * @desc
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

    @Modifying // 不加报错,JPA 默认操作,增删改时使用, 在调用的地方必须加事务，没有事务不能正常执行
    @Query(value = "UPDATE tb_article SET state=1 WHERE id = ?", nativeQuery = true)
    public void updateState(String id);

    @Modifying
    @Query(value = "UPDATE tb_article SET thumbup=thumbup+1 WHERE id = ?", nativeQuery = true)
    public void addThumbup(String id);
}