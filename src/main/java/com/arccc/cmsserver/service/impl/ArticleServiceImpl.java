package com.arccc.cmsserver.service.impl;

import com.arccc.cmsserver.domain.Article;
import com.arccc.cmsserver.service.ArticleService;
import com.arccc.cmsserver.mapper.ArticleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
* @author dengxingda
* @description 针对表【article】的数据库操作Service实现
* @createDate 2022-09-14 15:26:37
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
implements ArticleService{

    @Override
    public IPage<Article> listForParam(Map<String, String> param) {
        String page = param.get("page");
        String count = param.get("pageSize");
        Page<Article> pages;
        if (StringUtils.hasLength(page) && StringUtils.hasLength(count)){
            pages = new Page<>(Long.parseLong(page),Long.parseLong(count));

        }else {
            pages = new Page<>(1,10);
        }
        Page<Article> articlePage = baseMapper.selectPage(pages, new QueryWrapper<>());
        return articlePage;
    }
}
