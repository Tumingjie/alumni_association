package service.impl;

import dao.MediumContentDao;
import pojo.MediumContent;
import service.MediumContentService;

import java.util.List;

public class MediumContentServiceImpl implements MediumContentService {
    MediumContentDao mediumContentDao;

    public void setMediumContentDao(MediumContentDao mediumContentDao) {
        this.mediumContentDao = mediumContentDao;
    }

    @Override
    public int addMediumContent(MediumContent mediumContent) {
        return mediumContentDao.addMediumContent(mediumContent);
    }

    @Override
    public MediumContent getMediumContentById(int id) {
        return mediumContentDao.getMediumContentById(id);
    }

    @Override
    public int deleteMediumContentById(int id) {
        return mediumContentDao.deleteMediumContentById(id);
    }

    @Override
    public int updateMediumContent(MediumContent mediumContent) {
        return mediumContentDao.updateMediumContent(mediumContent);
    }

    @Override
    public int getCount(String methods) {
        return mediumContentDao.getCount(methods);
    }

    @Override
    public List<MediumContent> listMediumContentByLink(String link,int start) {
        return mediumContentDao.listMediumContentByLink(link,start);
    }
}
