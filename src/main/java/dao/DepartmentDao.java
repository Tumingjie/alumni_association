package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Classes;
import pojo.Department;

import java.util.List;

public interface DepartmentDao {
    int addDepartment(Department department);

    Department getDepartmentById(@Param("dtId")int id);

    int deleteDepartmentById(@Param("dtId")int id);

    int updateDepartment(Department department);

    List<Department> listDepartment();

}
