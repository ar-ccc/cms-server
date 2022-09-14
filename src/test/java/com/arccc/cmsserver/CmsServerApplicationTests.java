package com.arccc.cmsserver;

import com.arccc.cmsserver.domain.Article;
import com.arccc.cmsserver.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CmsServerApplicationTests {

    @Autowired
    private ArticleService articleService;
    @Test
    void contextLoads() {
        List<Article> list = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            list.add(new Article(null,"测试"+i,"测试子标题"+i,"arccc",new Date()));
        }
        articleService.saveBatch(list);
    }

}
