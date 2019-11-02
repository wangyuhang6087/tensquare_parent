package com.zhiyou100.recruit.controller;

import com.zhiyou100.recruit.model.Enterprise;
import com.zhiyou100.recruit.model.Recruit;
import com.zhiyou100.recruit.service.RecruitService;
import com.zhiyou100.util.ResultObject;
import com.zhiyou100.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:Rain
 * @date 2019/10/31 19:16
 * @desc
 */
@RestController
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    RecruitService recruitService;

    @GetMapping("/search/recommend")
    public ResultObject recommend(){
        List<Recruit> data = recruitService.findTop2ByStateIsOrderByCreatetimeDesc("2");
        return new ResultObject(true, StatusCode.OK,"查询推荐职位成功..",data);
    }

    /**
     * 根据条件查询招聘列表
     */
    @PostMapping("/search")
    public  ResultObject search(){
        // 固定type=1
        List<Recruit> data =  recruitService.findByTypeOrderByCreatetimeDesc("1");
        System.out.println(data);
        return new ResultObject(true, StatusCode.OK,"模糊查询成功",data);
    }

    /**
     * 找出任职方式为 1,以创建时间降序
     */
    @GetMapping("/search/type")
    public  ResultObject searchType(){
        List<Recruit> data = recruitService.findByTypeOrderByCreatetimeDesc("0");
        System.out.println(data);
        return new ResultObject(true, StatusCode.OK,"模糊查询成功",data);
    }

}
