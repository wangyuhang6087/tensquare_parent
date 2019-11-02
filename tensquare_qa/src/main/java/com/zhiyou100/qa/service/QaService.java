package com.zhiyou100.qa.service;

import com.zhiyou100.qa.dao.QaDao;
import com.zhiyou100.qa.model.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
 * @date 2019/11/1 10:46
 * @desc
 */
@Service
public class QaService {

    @Autowired
    QaDao qaDao;


    public List<Problem> newlist(String label) {
        return qaDao.newlist(label);
    }

    public Problem findById(String problemId) {
        return   qaDao.findById(problemId).get();
    }

    public Page<Problem> waitlist(String labelid, int page, int size){
        Pageable pageable = PageRequest.of(page-1, size);
        return qaDao.waitlist(labelid, pageable);
    }

    public Page<Problem> hotlist(String labelid, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1,size);
        return qaDao.hotlist(labelid,pageable);
    }
}
