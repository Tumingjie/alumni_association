package service.impl;

import dao.AlumniContentDao;
import pojo.AlumniContent;
import service.AlumniContentService;

import java.util.List;

public class AlumniContentServiceImpl implements AlumniContentService {
    AlumniContentDao alumniContentDao;

    public void setAlumniContentDao(AlumniContentDao alumniContentDao) {
        this.alumniContentDao = alumniContentDao;
    }

    @Override
    public int addAlumniContent(AlumniContent alumniContent) {
        return alumniContentDao.addAlumniContent(alumniContent);
    }

    @Override
    public AlumniContent getAlumniContentById(int id) {
        return alumniContentDao.getAlumniContentById(id);
    }

    @Override
    public int deleteAlumniContentById(int id) {
        return alumniContentDao.deleteAlumniContentById(id);
    }

    @Override
    public int updateAlumniContent(AlumniContent alumniContent) {
        return alumniContentDao.updateAlumniContent(alumniContent);
    }

    @Override
    public int getCount(String methods) {
        return alumniContentDao.getCount(methods);
    }

    @Override
    public List<AlumniContent> listAlumniContentByLink(String link,int start) {
        return alumniContentDao.listAlumniContentByLink(link,start);
    }
}
