package com.zhiyou100.service;

import com.zhiyou100.dao.SpitDao;
import com.zhiyou100.model.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author:Rain
 * @date 2019/11/2 16:48
 * @desc
 */
@Service
@Transactional
public class SpitService {
    @Autowired
    SpitDao spitDao;

    @Autowired
    MongoTemplate mongoTemplate;

    public Page<Spit> findByParentId(String parentid, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return spitDao.findByParentid(parentid, pageable);
    }

    public void thumUp(String spitId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is("1"));
        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"spit");
    }
}
