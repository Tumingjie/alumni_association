package dao;

import org.apache.ibatis.annotations.Param;
import pojo.DonateContent;

import java.util.List;

public interface DonateContentDao {
    int addDonateContent(DonateContent donateContent);

    DonateContent getDonateContentById(@Param("dcId")int id);

    int deleteDonateContentById(@Param("dcId")int id);

    int updateDonateContent(DonateContent donateContent);

    List<DonateContent> listDonateContentByLink(@Param("dcLink")String link,@Param("start")int start);

    int getCount(@Param("methods") String methods);
}
