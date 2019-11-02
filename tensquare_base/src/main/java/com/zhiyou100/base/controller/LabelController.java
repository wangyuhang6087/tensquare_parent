package com.zhiyou100.base.controller;

import com.zhiyou100.base.model.Label;
import com.zhiyou100.base.service.LabelService;
import com.zhiyou100.util.PageResult;
import com.zhiyou100.util.ResultObject;
import com.zhiyou100.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author:Rain
 * @date 2019/10/31 13:52
 * @desc
 */
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired  // 实现类
    private LabelService labelService;

    /**
     * 查全部
     */
    @GetMapping
    public ResultObject findAll(){
        List<Label> data = labelService.findAll();
        return new ResultObject(true, StatusCode.OK,"查询成功",data);
    }

    /**
     * 查询一个标签
     */
    @GetMapping("/{labelId}")
    public ResultObject findById(@PathVariable String labelId){
        Label data = labelService.findById(labelId);
        return new ResultObject(true, StatusCode.OK,"查询成功",data);
    }

    /**
     * 添加标签
     */
    @PostMapping
    public  ResultObject add(@RequestBody Label label){
        labelService.add(label);
        return new ResultObject(true, StatusCode.OK,"添加成功");

    }

    /**
     * 删除标签
     */
    @DeleteMapping("/{labelId}")
    public  ResultObject deleteById(@PathVariable String labelId){
       labelService.deleteById(labelId);
        return new ResultObject(true, StatusCode.OK,"删除成功");
    }

    /**
     * 修改标签
     */
    @PutMapping("/{labelId}")
    public  ResultObject update(@PathVariable String labelId,@RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new ResultObject(true, StatusCode.OK,"更新成功");
    }

       /**
     * 模糊查询
     */
    @PostMapping("/search")
    public  ResultObject search(@RequestBody Label label){
        List<Label> data = labelService.findAllByKeyword(label);
        return new ResultObject(true, StatusCode.OK,"模糊查询成功",data);
    }


    /**
     * 模糊查询+分页
     */
    @PostMapping("/search/{page}/{size}")
    public  ResultObject searchByPage(@RequestBody Label label,@PathVariable int page,@PathVariable int size){
        Page<Label> pageobj = labelService.findByKeywordAndPage(label, page, size);
        PageResult<Label> labelPageResult = new PageResult<Label>((int)pageobj.getTotalElements(),pageobj.getContent());
        return new ResultObject(true, StatusCode.OK,"模糊查询+分页..成功",labelPageResult);
    }

    /**
     * 推荐标签列表
     * @return
     */
    @GetMapping("/toplist")
    public ResultObject toplist(){
        //  固定recommmend为 1
        List<Label> data  = labelService.findByRecommendEquals("1");
        return new ResultObject(true,StatusCode.OK,"查询推荐列表成功",data);
    }
}
