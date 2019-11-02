package com.zhiyou100.controller;

import com.zhiyou100.model.Article;
import com.zhiyou100.service.ArticleService;
import com.zhiyou100.util.ResultObject;
import com.zhiyou100.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:Rain
 * @date 2019/11/2 10:06
 * @desc
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PutMapping("/examine/{articleId}")
    public ResultObject examine(@PathVariable String articleId) {
        articleService.updateState(articleId);
        System.out.println(1/0);
        return new ResultObject(true, StatusCode.OK, "审核成功");
    }

    @PutMapping("/thumbup/{articleId}")
    public ResultObject thumbup(@PathVariable String articleId) {
        articleService.addThumbup(articleId);
        return new ResultObject(true, StatusCode.OK, "点赞成功");
    }

    @GetMapping("/{id}")
    public ResultObject findOne(@PathVariable String id){
        Article data = articleService.findById(id);
        return new ResultObject(true,StatusCode.OK,"查询成功",data);

    }

}