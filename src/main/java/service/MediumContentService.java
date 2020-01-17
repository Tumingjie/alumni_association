package service;

import org.apache.ibatis.annotations.Param;
import pojo.MediumContent;

import java.util.List;

public interface MediumContentService {

    int addMediumContent(MediumContent mediumContent);

    MediumContent getMediumContentById(@Param("mcId")int id);

    int deleteMediumContentById(@Param("mcId")int id);

    int updateMediumContent(MediumContent mediumContent);

    List<MediumContent> listMediumContentByLink(@Param("mcLink")String link,int start);

    int getCount(@Param("methods") String methods);
}
