package service;

import org.apache.ibatis.annotations.Param;
import pojo.Medium;

import java.util.List;

public interface MediumService {
    int addMedium(Medium medium);

    Medium getMediumById(@Param("mId")int id);

    int deleteMediumById(@Param("mId")int id);

    int updateMedium(Medium medium);

    List<Medium> listMedium();

    List<String> listLink();
}
