package service.impl;

import dao.NewsContentDao;
import pojo.NewsContent;
import service.NewsContentService;

import java.util.List;

public class NewsContentServiceImpl implements NewsContentService {

    NewsContentDao newsContentDao;
    public void setNewsContentDao(NewsContentDao newsContentDao) {
        this.newsContentDao = newsContentDao;
    }

    @Override
    public int addNewsContent(NewsContent newsContent) {
        return newsContentDao.addNewsContent(newsContent);
    }

    @Override
    public NewsContent getNewsContentById(int id) {
        return newsContentDao.getNewsContentById(id);
    }

    @Override
    public int deleteNewContentById(int id) {
        return newsContentDao.deleteNewContentById(id);
    }

    @Override
    public int updateNewsContent(NewsContent newsContent) {
        return newsContentDao.updateNewsContent(newsContent);
    }

    @Override
    public List<NewsContent> listNewsContentByLink(String link,int start) {
        return newsContentDao.listNewsContentByLink(link,start);
    }

    @Override
    public int getCount(String methods) {
        return newsContentDao.getCount(methods);
    }
}
