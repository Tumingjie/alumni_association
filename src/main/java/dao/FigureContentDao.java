package dao;

import org.apache.ibatis.annotations.Param;
import pojo.FigureContent;

import java.util.List;

public interface FigureContentDao {
    int addFigureContent(FigureContent figureContent);

    FigureContent getFigureContentById(@Param("fcId")int id);

    int deleteFigureContentById(@Param("fcId")int id);

    int updateFigureContent(FigureContent figureContent);

    List<FigureContent> listFigureContentByLink(@Param("fcLink")String link,@Param("start")int start);

    int getCount(@Param("methods") String methods);
}
