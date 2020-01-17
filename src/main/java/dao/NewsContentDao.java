package dao;

import org.apache.ibatis.annotations.Param;
import pojo.NewsContent;

import java.util.List;

public interface NewsContentDao {
    int addNewsContent(NewsContent newsContent);

    NewsContent getNewsContentById(@Param("ncId")int id);

    int deleteNewContentById(@Param("ncId")int id);

    int updateNewsContent(NewsContent newsContent);

    List<NewsContent> listNewsContentByLink(@Param("ncLink")String link,@Param("start")int start);

    int getCount(@Param("methods") String methods);
}
