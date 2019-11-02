package com.zhiyou100.controller;

import com.zhiyou100.model.Spit;
import com.zhiyou100.service.SpitService;
import com.zhiyou100.util.ResultObject;
import com.zhiyou100.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:Rain
 * @date 2019/11/1 16:46
 * @desc
 */
@RestController
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    SpitService spitService;

    @GetMapping("/comment/{parentid}/{page}/{size}")
    public ResultObject findByParentId(@PathVariable String parentid,@PathVariable int page,@PathVariable int size){
        Page<Spit> data = spitService.findByParentId(parentid,page,size);
        return  new ResultObject(true, StatusCode.OK,"查询成功",data);
    }

    @PutMapping("/thumbup/{spitId}")
    public ResultObject thumbup(@PathVariable String spitId){
        spitService.thumUp(spitId);
        return new ResultObject(true,StatusCode.OK,"点赞成功");
    }
}
