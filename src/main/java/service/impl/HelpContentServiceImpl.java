package service.impl;

import dao.HelpContentDao;
import pojo.HelpContent;
import service.HelpContentService;

import java.util.List;

public class HelpContentServiceImpl implements HelpContentService {
    HelpContentDao helpContentDao;
    public void setHelpContentDao(HelpContentDao helpContentDao) {
        this.helpContentDao = helpContentDao;
    }

    @Override
    public int addHelpContent(HelpContent helpContent) {
        return helpContentDao.addHelpContent(helpContent);
    }

    @Override
    public HelpContent getHelpContentById(int id) {
        return helpContentDao.getHelpContentById(id);
    }

    @Override
    public int deleteHelpContentById(int id) {
        return helpContentDao.deleteHelpContentById(id);
    }

    @Override
    public int updateHelpContent(HelpContent helpContent) {
        return helpContentDao.updateHelpContent(helpContent);
    }

    @Override
    public int getCount(String methods) {
        return helpContentDao.getCount(methods);
    }

    @Override
    public List<HelpContent> listHelpContentByLink(String link,int start) {
        return helpContentDao.listHelpContentByLink(link,start);
    }
}
