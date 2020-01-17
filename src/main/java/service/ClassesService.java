package service;

import org.apache.ibatis.annotations.Param;
import pojo.Classes;

import java.util.List;

public interface ClassesService {
    int addClasses(Classes classes);

    Classes getClassesById(@Param("csId")int id);

    int deleteClassesById(@Param("csId")int id);

    int updateClasses(Classes classes);

    List<Classes> listClassesByDepartmentName(@Param("whichName")String name);
}

