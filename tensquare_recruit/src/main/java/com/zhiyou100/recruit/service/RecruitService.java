package com.zhiyou100.recruit.service;

import com.zhiyou100.recruit.dao.RecruitDao;
import com.zhiyou100.recruit.model.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:Rain
 * @date 2019/10/31 19:30
 * @desc
 */
@Service
public class RecruitService {

    @Autowired
    RecruitDao recruitDao;

    public List<Recruit> findTop2ByStateIsOrderByCreatetimeDesc(String state) {
        return recruitDao.findTop2ByStateIsOrderByCreatetimeDesc(state);  // Desc降序,Asc升序
    }

    public List findAllByKeyword(Recruit recruit) {

        return  recruitDao.findAll(new Specification<Recruit>() {

            @Nullable
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) { // 百分号前后不用拼接 ' '
                List<Predicate> predicates = new ArrayList<>();
                if(recruit != null){
                    // 如果需要根据标签名模糊查询,那么先判断标签名是否为空.
                    if(!("".equals(recruit.getJobname()) || null == recruit.getJobname())){
                        Predicate predicate1 = criteriaBuilder.like(root.get("jobname").as(String.class), "%" + recruit.getJobname() + "%");
                        predicates.add(predicate1);
                    }
                    if(!("".equals(recruit.getEducation()) || null == recruit.getEducation())){
                        Predicate predicate2 = criteriaBuilder.equal(root.get("education").as(String.class), recruit.getEducation());
                        predicates.add(predicate2);
                    }
                    if(!("".equals(recruit.getAddress()) || null == recruit.getAddress())){
                        Predicate predicate3 = criteriaBuilder.equal(root.get("address").as(String.class), recruit.getAddress());
                        predicates.add(predicate3);
                    }
                    Predicate[] predicatesArray = predicates.toArray(new Predicate[predicates.size()]);
                    return criteriaBuilder.and(predicatesArray);
                }
                return null;
            }
        });
    }

    public List<Recruit> findByTypeOrderByCreatetimeDesc(String s) {
        return recruitDao.findByTypeOrderByCreatetimeDesc(s);  // Desc降序,Asc升序
    }
}