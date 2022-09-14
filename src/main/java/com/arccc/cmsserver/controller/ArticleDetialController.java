package com.arccc.cmsserver.controller;


import com.arccc.cmsserver.domain.Article;
import com.arccc.cmsserver.domain.ArticleDetails;
import com.arccc.cmsserver.service.ArticleDetailsService;
import com.arccc.cmsserver.service.ArticleService;
import com.arccc.cmsserver.utils.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/articleDetial")
public class ArticleDetialController {
    @Autowired
    private ArticleDetailsService articleDetailsService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") Long id){
        ArticleDetails articleDetails = articleDetailsService.getOne(new QueryWrapper<ArticleDetails>().eq("id", id));
        if (articleDetails==null){
            Article article = articleService.getOne(new QueryWrapper<Article>().eq("id", id));
            articleDetails = new ArticleDetails();
            BeanUtils.copyProperties(article,articleDetails);
            articleDetailsService.save(articleDetails);
        }
        return Result.ok().data(articleDetails);
    }

    @PostMapping("/add")
    public Result add(@RequestBody ArticleDetails articleDetails){
        if (articleDetails.getId()==null) {
            //创建文章
            Article article = new Article();
            //复制基本信息
            BeanUtils.copyProperties(articleDetails,article);
            //TODO 获取用户的id
            article.setAuthor("arccc");
            article.setDate(new Date());
            //保存并获取id
            articleService.save(article);
            //设置id
            articleDetails.setId(article.getId());
            //保存
            articleDetailsService.save(articleDetails);
        }else {
            Article article = articleService.getOne(new QueryWrapper<Article>().eq("id",articleDetails.getId()));
            if (article==null){
                article=new Article();
                article.setAuthor("arccc");
                article.setDate(new Date());
                BeanUtils.copyProperties(articleDetails,article);
                articleService.save(article);
                articleDetails.setId(article.getId());
                articleDetailsService.save(articleDetails);
            }else {
                BeanUtils.copyProperties(articleDetails,article);
                articleService.updateById(article);
                articleDetailsService.updateById(articleDetails);
            }
        }
        return Result.ok();
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        articleService.removeById(id);
        articleDetailsService.removeById(id);
        return Result.ok();
    }
}
