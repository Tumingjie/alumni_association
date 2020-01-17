package service;

import org.apache.ibatis.annotations.Param;
import pojo.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);

    Student getStudentById(@Param("sId")int id);

    int deleteStudentById(@Param("sId")int id);

    int updateStudent(Student student);

    List<Student> listStudent();

    List<String> listLink();
}
