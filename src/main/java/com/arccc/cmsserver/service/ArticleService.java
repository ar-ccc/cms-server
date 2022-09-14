package com.arccc.cmsserver.service;

import com.arccc.cmsserver.domain.Article;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author dengxingda
* @description 针对表【article】的数据库操作Service
* @createDate 2022-09-14 15:26:37
*/
public interface ArticleService extends IService<Article> {

    IPage<Article> listForParam(Map<String, String> param);
}
