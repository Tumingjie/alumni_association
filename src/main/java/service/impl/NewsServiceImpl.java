package service.impl;

import dao.NewsDao;
import pojo.News;
import service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    NewsDao newsDao;

    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public int addNews(News news) {
        return newsDao.addNews(news);
    }

    @Override
    public News getNewsById(int id) {
        return newsDao.getNewsById(id);
    }

    @Override
    public int deleteNewsById(int id) {
        return newsDao.deleteNewsById(id);
    }

    @Override
    public int updateNews(News news) {
        return newsDao.updateNews(news);
    }

    @Override
    public List<News> listNews() {
        return newsDao.listNews();
    }

    @Override
    public List<String> listLink() {
        return newsDao.listLink();
    }
}
