package com.zhiyou100.recruit.controller;

import com.zhiyou100.recruit.model.Enterprise;
import com.zhiyou100.recruit.service.EnterpriseService;
import com.zhiyou100.util.ResultObject;
import com.zhiyou100.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:Rain
 * @date 2019/10/31 18:44
 * @desc
 */
@RestController
@RequestMapping("/enterprise")
public class EmterpriseController {

    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping("/search/hotlist")
    public ResultObject hotlist() {
        // 热门企业列表: 固定ishot字段值1
        List<Enterprise> data = enterpriseService.findByIshotEquals("1");
        System.out.println(data);
        return new ResultObject(true, StatusCode.OK,"查询热门成功",data);
    }
}
