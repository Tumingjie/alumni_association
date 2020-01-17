package service.impl;

import dao.HelpDao;
import pojo.Help;
import service.HelpService;

import java.util.List;

public class HelpServiceImpl implements HelpService {
    HelpDao helpDao;

    public void setHelpDao(HelpDao helpDao) {
        this.helpDao = helpDao;
    }

    @Override
    public int addHelp(Help help) {
        return helpDao.addHelp(help);
    }

    @Override
    public Help getHelpById(int id) {
        return helpDao.getHelpById(id);
    }

    @Override
    public int deleteHelpById(int id) {
        return helpDao.deleteHelpById(id);
    }

    @Override
    public int updateHelp(Help help) {
        return helpDao.updateHelp(help);
    }

    @Override
    public List<Help> listHelp() {
        return helpDao.listHelp();
    }

    @Override
    public List<String> listLink() {
        return helpDao.listLink();
    }
}
