package service;

import org.apache.ibatis.annotations.Param;
import pojo.FigureContent;

import java.util.List;

public interface FigureContentService {
    int addFigureContent(FigureContent figureContent);

    FigureContent getFigureContentById(@Param("fcId")int id);

    int deleteFigureContentById(@Param("fcId")int id);

    int updateFigureContent(FigureContent figureContent);

    List<FigureContent> listFigureContentByLink(@Param("fcLink")String link,int start);

    int getCount(@Param("methods") String methods);
}
