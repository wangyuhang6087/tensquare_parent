package com.zhiyou100.base.dao;

/**
 * @author:Rain
 * @date 2019/10/31 14:00
 * @desc
 */

import com.zhiyou100.base.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * JPA层 必须写接口,不用写该接口的实现类
 * 声明该接口是JPA类型的接口 -->继承JPA的接口
 * JpaRepository<T,ID>:
 * <T,ID> T 领域实体 -->　要封装的实体类
 *        ID 该实体类所对应的主键类型
 *  JpaSpecificationExecutor  接口可以完成
 *
 */
public interface LabelDao extends JpaRepository <Label,String>
        , JpaSpecificationExecutor<Label> {
    List<Label> findByRecommendEquals(String recommend);
}
