package service.impl;

import dao.MediumDao;
import pojo.Medium;
import service.MediumService;

import java.util.List;

public class MediumServiceImpl implements MediumService{
    MediumDao mediumDao;

    public void setMediumDao(MediumDao mediumDao) {
        this.mediumDao = mediumDao;
    }

    @Override
    public int addMedium(Medium medium) {
        return mediumDao.addMedium(medium);
    }

    @Override
    public Medium getMediumById(int id) {
        return mediumDao.getMediumById(id);
    }

    @Override
    public int deleteMediumById(int id) {
        return mediumDao.deleteMediumById(id);
    }

    @Override
    public int updateMedium(Medium medium) {
        return mediumDao.updateMedium(medium);
    }

    @Override
    public List<Medium> listMedium() {
        return mediumDao.listMedium();
    }

    @Override
    public List<String> listLink() {
        return mediumDao.listLink();
    }
}
