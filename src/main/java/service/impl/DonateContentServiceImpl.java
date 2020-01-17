package service.impl;

import dao.DonateContentDao;
import pojo.DonateContent;
import service.DonateContentService;

import java.util.List;

public class DonateContentServiceImpl implements DonateContentService {
    DonateContentDao donateContentDao;

    public void setDonateContentDao(DonateContentDao donateContentDao) {
        this.donateContentDao = donateContentDao;
    }

    @Override
    public int addDonateContent(DonateContent donateContent) {
        return donateContentDao.addDonateContent(donateContent);
    }

    @Override
    public DonateContent getDonateContentById(int id) {
        return donateContentDao.getDonateContentById(id);
    }

    @Override
    public int deleteDonateContentById(int id) {
        return donateContentDao.deleteDonateContentById(id);
    }

    @Override
    public int updateDonateContent(DonateContent donateContent) {
        return donateContentDao.updateDonateContent(donateContent);
    }

    @Override
    public int getCount(String methods) {
        return donateContentDao.getCount(methods);
    }

    @Override
    public List<DonateContent> listDonateContentByLink(String link,int start) {
        return donateContentDao.listDonateContentByLink(link,start);
    }
}
