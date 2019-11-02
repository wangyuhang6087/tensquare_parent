package com.zhiyou100.recruit.service;

import com.zhiyou100.recruit.dao.EnterpriseDao;
import com.zhiyou100.recruit.dao.RecruitDao;
import com.zhiyou100.recruit.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Rain
 * @date 2019/10/31 18:46
 * @desc
 */
@Service
public class EnterpriseService {

    @Autowired
   EnterpriseDao enterpriseDao;

    public List<Enterprise> findByIshotEquals(String ishot) {
        return enterpriseDao.findByIshotEquals(ishot);
    }
}
