package com.zhiyou100.recruit.dao;

import com.zhiyou100.recruit.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author:Rain
 * @date 2019/10/31 19:32
 * @desc
 */
public interface EnterpriseDao extends JpaRepository<Enterprise,String >
        , JpaSpecificationExecutor<Enterprise> {
    List<Enterprise> findByIshotEquals(String ishot);
}
