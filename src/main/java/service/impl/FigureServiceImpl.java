package service.impl;

import dao.FigureDao;
import pojo.Figure;
import service.FigureService;

import java.util.List;

public class FigureServiceImpl implements FigureService {
    FigureDao figureDao;

    public void setFigureDao(FigureDao figureDao) {
        this.figureDao = figureDao;
    }

    @Override
    public int addFigure(Figure figure) {
        return figureDao.addFigure(figure);
    }
    @Override
    public Figure getFigureById(int id) {
        return figureDao.getFigureById(id);
    }

    @Override
    public int deleteFigureById(int id) {
        return figureDao.deleteFigureById(id);
    }

    @Override
    public int updateFigure(Figure figure) {
        return figureDao.updateFigure(figure);
    }

    @Override
    public List<Figure> listFigure() {
        return figureDao.listFigure();
    }

    @Override
    public List<String> listLink() {
        return figureDao.listLink();
    }
}
