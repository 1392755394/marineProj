package com.ocean.main.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ocean.main.common.BaseHibernateTemplate;
import com.ocean.main.dao.ArticleDao;
import com.ocean.main.entity.Article;

//@Component
@Repository
public class ArticleDaoImpl extends BaseHibernateTemplate implements ArticleDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Article> articleList(Article article) {
        
//        List<Article> articleList = this.getHibernateTemplate().find(" From Article ");
        // use ehcache ,necessary sessionfactory model
        Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from Article");
        query.setCacheable(true);
        List<Article> list1 = query.list();
        System.out.println(list1.size());
        List<Article> list2 = query.list();
        System.out.println(list2.size());
        return list1;
    }

    @Override
    public long addArticle(Article article) {
        
        this.getHibernateTemplate().save(article);
        return article.getId();
    }
    
    

}
