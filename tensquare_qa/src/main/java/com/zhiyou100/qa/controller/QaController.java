package com.zhiyou100.qa.controller;

import com.alibaba.fastjson.JSONArray;
import com.zhiyou100.qa.model.Problem;
import com.zhiyou100.qa.service.QaService;
import com.zhiyou100.util.PageResult;
import com.zhiyou100.util.ResultObject;
import com.zhiyou100.util.StatusCode;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author:Rain
 * @date 2019/11/1 10:42
 * @desc
 */
@RestController
@RequestMapping("/problem")
public class QaController {

    @Autowired
    QaService qaService;

    @GetMapping("/{label}")
    public ResultObject newlist(@PathVariable String label){
        List<Problem> data = qaService.newlist(label);

        return new ResultObject(true, StatusCode.OK,"查询最新问答列表成功",data);
    }

    @GetMapping("/search/{problemId}")
    public ResultObject findByPorblemId(@PathVariable String problemId){
        Problem data = qaService.findById(problemId);

        return new ResultObject(true, StatusCode.OK,"查询单个问题为 :　",data);
    }



    @GetMapping("/waitlist/{labelid}/{page}/{size}")
    public ResultObject waitlist(@PathVariable String labelid, @PathVariable int page, @PathVariable int size){
        Page<Problem> pageData = qaService.waitlist(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>((int) pageData.getTotalElements(), pageData.getContent());
        return new ResultObject(true, StatusCode.OK, "查询等待列表成功", pageResult);
    }

    @GetMapping("/hotlist/{labelid}/{page}/{size}")
    public ResultObject hotlist(@PathVariable String labelid, @PathVariable int page, @PathVariable int size){
        Page<Problem> pageData = qaService.hotlist(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>((int) pageData.getTotalElements(), pageData.getContent());
        return new ResultObject(true, StatusCode.OK, "查询热门列表成功", pageResult);
    }

}
