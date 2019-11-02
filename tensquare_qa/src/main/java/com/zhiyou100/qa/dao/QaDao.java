package com.zhiyou100.qa.dao;

import com.zhiyou100.qa.model.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author:Rain
 * @date 2019/11/1 10:47
 * @desc
 */
public interface QaDao extends JpaRepository<Problem,String>
        , JpaSpecificationExecutor<Problem> {

    /**
     * 需要指定  使用原生sql语句
     * @param label
     * @return
     */
    @Query(value = "SELECT *  FROM tb_problem,tb_pl  where id = problemid and labelid = ?",nativeQuery = true)
    List<Problem> newlist(String label);

    /**
     * 增删改,都需要加上注解  @Query 要加上 @Modifying 不然会报错,而且要实现事务,service层加上@Transactional
     */

    // 等待回答列表
    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid=? AND reply=0 ORDER BY createtime DESC", nativeQuery = true)
    Page<Problem> waitlist(String labelid, Pageable pageable);

    @Query(value = "select * from tb_pl ,tb_problem  where labelid = id and  labelid = 1 order by createtime desc ",nativeQuery = true)
    Page<Problem> hotlist(String labelid, Pageable pageable);
}


