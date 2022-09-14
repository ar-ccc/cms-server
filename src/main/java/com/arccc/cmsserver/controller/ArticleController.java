package com.arccc.cmsserver.controller;

import com.arccc.cmsserver.domain.Article;
import com.arccc.cmsserver.service.ArticleService;
import com.arccc.cmsserver.utils.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public Result list(@RequestParam Map<String ,String > param){
        IPage<Article> list= articleService.listForParam(param);
        return Result.ok().data(list);
    }

}
