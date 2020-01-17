package dao;

import org.apache.ibatis.annotations.Param;
import pojo.AlumniContent;

import java.util.List;

public interface AlumniContentDao {
    int addAlumniContent(AlumniContent alumniContent);

    AlumniContent getAlumniContentById(@Param("acId")int id);

    int deleteAlumniContentById(@Param("acId")int id);

    int updateAlumniContent(AlumniContent alumniContent);

    List<AlumniContent> listAlumniContentByLink(@Param("acLink")String link,@Param("start")int start);

    int getCount(@Param("methods")String methods);
}
