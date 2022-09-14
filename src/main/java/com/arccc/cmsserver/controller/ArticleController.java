package com.arccc.cmsserver.controller;

import com.arccc.cmsserver.domain.Article;
import com.arccc.cmsserver.service.ArticleService;
import com.arccc.cmsserver.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public Result list(Map<String ,String > param){
        List<Article>  list= articleService.listForParam(param);
        return Result.ok().data(list);
    }
}
