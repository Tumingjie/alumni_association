package service;

import org.apache.ibatis.annotations.Param;
import pojo.News;

import java.util.List;

public interface NewsService {
    int addNews(News news);

    News getNewsById(@Param("nId")int id);

    int deleteNewsById(@Param("nId")int id);

    int updateNews(News news);

    List<News> listNews();

    List<String> listLink();
}
