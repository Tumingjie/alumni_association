package service.impl;

import dao.ClassesDao;
import pojo.Classes;
import service.ClassesService;

import java.util.List;

public class ClassesServiceImpl implements ClassesService {
    ClassesDao classesDao;

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }

    @Override
    public int addClasses(Classes classes) {
        return classesDao.addClasses(classes);
    }

    @Override
    public Classes getClassesById(int id) {
        return classesDao.getClassesById(id);
    }

    @Override
    public int deleteClassesById(int id) {
        return classesDao.deleteClassesById(id);
    }

    @Override
    public int updateClasses(Classes classes) {
        return classesDao.updateClasses(classes);
    }

    @Override
    public List<Classes> listClassesByDepartmentName(String name) {
        return classesDao.listClassesByDepartmentName(name);
    }
}
