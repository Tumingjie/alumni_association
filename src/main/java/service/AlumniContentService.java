package service;

import org.apache.ibatis.annotations.Param;
import pojo.AlumniContent;

import java.util.List;

public interface AlumniContentService {
    int addAlumniContent(AlumniContent alumniContent);

    AlumniContent getAlumniContentById(@Param("acId")int id);

    int deleteAlumniContentById(@Param("acId")int id);

    int updateAlumniContent(AlumniContent alumniContent);

    List<AlumniContent> listAlumniContentByLink(@Param("acLink")String link,int start);

    int getCount(@Param("methods") String methods);
}
