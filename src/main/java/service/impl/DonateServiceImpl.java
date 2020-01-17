package service.impl;


import dao.DonateDao;
import pojo.Donate;
import service.DonateService;

import java.util.List;

public class DonateServiceImpl implements DonateService {
    DonateDao donateDao;
    public void setDonateDao(DonateDao donateDao) {
        this.donateDao = donateDao;
    }
    @Override
    public int addDonate(Donate donate) {
        return donateDao.addDonate(donate);
    }

    @Override
    public Donate getDonateById(int id) {
        return donateDao.getDonateById(id);
    }

    @Override
    public int deleteDonateById(int id) {
        return donateDao.deleteDonateById(id);
    }

    @Override
    public int updateDonate(Donate donate) {
        return donateDao.updateDonate(donate);
    }

    @Override
    public List<Donate> listDonate() {
        return donateDao.listDonate();
    }

    @Override
    public List<String> listLink() {
        return donateDao.listLink();
    }
}
