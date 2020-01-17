package dao;

import org.apache.ibatis.annotations.Param;
import pojo.HelpContent;

import java.util.List;

public interface HelpContentDao {
    int addHelpContent(HelpContent helpContent);

    HelpContent getHelpContentById(@Param("hcId")int id);

    int deleteHelpContentById(@Param("hcId")int id);

    int updateHelpContent(HelpContent helpContent);

    List<HelpContent> listHelpContentByLink(@Param("hcLink")String link,@Param("start")int start);

    int getCount(@Param("methods") String methods);
}
