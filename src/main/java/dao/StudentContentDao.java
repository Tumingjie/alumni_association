package dao;

import org.apache.ibatis.annotations.Param;
import pojo.StudentContent;

import java.util.List;

public interface StudentContentDao {
    int addStudentContent(StudentContent studentContent);

    StudentContent getStudentContentById(@Param("scId")int id);

    int deleteStudentContentById(@Param("scId")int id);

    int updateStudentContent(StudentContent studentContent);

    List<StudentContent> listStudentContentByLink(@Param("scLink")String link,@Param("start")int start);

    int getCount(@Param("methods") String methods);
}
