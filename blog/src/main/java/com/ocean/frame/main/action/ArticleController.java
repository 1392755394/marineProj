package com.ocean.frame.main.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ocean.frame.main.entity.Article;
import com.ocean.frame.main.service.ArticleService;

@Controller
@RequestMapping("article")
public class ArticleController {
    
    private final Logger log = LoggerFactory.getLogger(Article.class);
    
    @Autowired
    private ArticleService articleService;

    @RequestMapping("articleList")
    public String articleList(){
                
        System.out.println("come in article list");
        return "";
    }
    
    @RequestMapping("addArticle")
    public String addArticle(Article article){
        
        log.info("添加文章");
        Long articleId = this.articleService.addArticle(article);
//        return  (null!=articleId?String.valueOf(articleId):0);
        System.out.println(articleId);
        return "";
    }
    
    
}