package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Figure;

import java.util.List;

public interface FigureDao {

    int addFigure(Figure figure);

    Figure getFigureById(@Param("fId")int id);

    int deleteFigureById(@Param("fId")int id);

    int updateFigure(Figure figure);

    List<Figure> listFigure();

    List<String> listLink();
}
