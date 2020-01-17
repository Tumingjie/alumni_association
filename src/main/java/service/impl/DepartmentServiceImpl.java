package service.impl;

import dao.DepartmentDao;
import pojo.Classes;
import pojo.Department;
import service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public int addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentDao.getDepartmentById(id);
    }

    @Override
    public int deleteDepartmentById(int id) {
        return departmentDao.deleteDepartmentById(id);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }

    @Override
    public List<Department> listDepartment() {
        return departmentDao.listDepartment();
    }

}
