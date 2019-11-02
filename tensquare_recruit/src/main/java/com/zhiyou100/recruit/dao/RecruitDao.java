package com.zhiyou100.recruit.dao;

import com.zhiyou100.recruit.model.Recruit;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author:Rain
 * @date 2019/10/31 19:33
 * @desc
 */
public interface RecruitDao extends JpaRepository<Recruit,String >
        , JpaSpecificationExecutor<Recruit> {
    List<Recruit> findTop2ByStateIsOrderByCreatetimeDesc(String state);

    List<Recruit> findByTypeOrderByCreatetimeDesc(String s);
}
