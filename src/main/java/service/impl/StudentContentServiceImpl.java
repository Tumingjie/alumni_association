package service.impl;

import dao.StudentContentDao;
import pojo.StudentContent;
import service.StudentContentService;

import java.util.List;

public class StudentContentServiceImpl implements StudentContentService {
    StudentContentDao studentContentDao;

    public void setStudentContentDao(StudentContentDao studentContentDao) {
        this.studentContentDao = studentContentDao;
    }

    @Override
    public int addStudentContent(StudentContent studentContent) {
        return studentContentDao.addStudentContent(studentContent);
    }

    @Override
    public StudentContent getStudentContentById(int id) {
        return studentContentDao.getStudentContentById(id);
    }

    @Override
    public int deleteStudentContentById(int id) {
        return studentContentDao.deleteStudentContentById(id);
    }

    @Override
    public int updateStudentContent(StudentContent studentContent) {
        return studentContentDao.updateStudentContent(studentContent);
    }

    @Override
    public int getCount(String methods) {
        return studentContentDao.getCount(methods);
    }

    @Override
    public List<StudentContent> listStudentContentByLink(String link,int start) {
        return studentContentDao.listStudentContentByLink(link,start);
    }
}
