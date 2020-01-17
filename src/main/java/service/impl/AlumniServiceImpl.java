package service.impl;

import dao.AlumniDao;
import pojo.Alumni;
import service.AlumniService;

import java.util.List;

public class AlumniServiceImpl implements AlumniService {
    AlumniDao alumniDao;

    public void setAlumniDao(AlumniDao alumniDao) {
        this.alumniDao = alumniDao;
    }

    @Override
    public int addAlumni(Alumni alumni) {
        return alumniDao.addAlumni(alumni);
    }

    @Override
    public Alumni getAlumniById(int id) {
        return alumniDao.getAlumniById(id);
    }

    @Override
    public int deleteAlumniById(int id) {
        return alumniDao.deleteAlumniById(id);
    }

    @Override
    public int updateAlumni(Alumni alumni) {
        return alumniDao.updateAlumni(alumni);
    }

    @Override
    public List<Alumni> listAlumni() {
        return alumniDao.listAlumni();
    }

    @Override
    public List<String> listLink(){return alumniDao.listLink(); }
}
