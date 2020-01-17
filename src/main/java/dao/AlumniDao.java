package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Alumni;

import java.util.List;

public interface AlumniDao {
    int addAlumni(Alumni alumni);

    Alumni getAlumniById(@Param("aId")int id);

    int deleteAlumniById(@Param("aId")int id);

    int updateAlumni(Alumni alumni);

    List<Alumni> listAlumni();

    List<String> listLink();//查询所有链接
}
