package com.arccc.cmsserver;

import com.arccc.cmsserver.domain.Article;
import com.arccc.cmsserver.domain.User;
import com.arccc.cmsserver.service.ArticleService;
import com.arccc.cmsserver.utils.JwtUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@SpringBootTest
class CmsServerApplicationTests {

    @Test
    void tset2(){

//        JwtUtil.createJWT()
    }

//    @Autowired
    private ArticleService articleService;
    @Test
    void contextLoads() {
        List<Article> list = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            list.add(new Article(null,"测试"+i,"测试子标题"+i,"arccc",new Date()));
        }
        articleService.saveBatch(list);
    }

    @Test
    void test1() throws JsonProcessingException {
        ObjectMapper objectMapper =new ObjectMapper();
        User user = new User();
//        user.setId(1);
        user.setName("arccc");
        user.setPassword("1234");
        System.out.println("转换前对象=》"+user);
        String s = objectMapper.writer().writeValueAsString(user);
        System.out.println("转换后对象=》"+s);
        String jwt = JwtUtil.createJWT(s);
        System.out.println(jwt);
    }



}
