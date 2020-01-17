package service.impl;

import dao.FigureContentDao;
import pojo.FigureContent;
import service.FigureContentService;

import java.util.List;

public class FigureContentServiceImpl implements FigureContentService {
    FigureContentDao figureContentDao;

    public void setFigureContentDao(FigureContentDao figureContentDao) {
        this.figureContentDao = figureContentDao;
    }

    @Override
    public int addFigureContent(FigureContent figureContent) {
        return figureContentDao.addFigureContent(figureContent);
    }

    @Override
    public FigureContent getFigureContentById(int id) {
        return figureContentDao.getFigureContentById(id);
    }

    @Override
    public int deleteFigureContentById(int id) {
        return figureContentDao.deleteFigureContentById(id);
    }

    @Override
    public int updateFigureContent(FigureContent figureContent) {
        return figureContentDao.updateFigureContent(figureContent);
    }

    @Override
    public List<FigureContent> listFigureContentByLink(String link,int start) {
        return figureContentDao.listFigureContentByLink(link,start);
    }

    @Override
    public int getCount(String methods) {
        return figureContentDao.getCount(methods);
    }
}
