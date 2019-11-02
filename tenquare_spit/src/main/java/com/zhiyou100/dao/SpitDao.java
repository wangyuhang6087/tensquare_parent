package com.zhiyou100.dao;

import com.zhiyou100.model.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author:Rain
 * @date 2019/11/2 16:51
 * @desc
 */
public interface SpitDao extends MongoRepository<Spit,String> {

    Page<Spit> findByParentid(String parentid, Pageable pageable);
}
