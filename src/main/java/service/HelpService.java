package service;

import org.apache.ibatis.annotations.Param;
import pojo.Help;

import java.util.List;

public interface HelpService {
    int addHelp(Help help);

    Help getHelpById(@Param("hId")int id);

    int deleteHelpById(@Param("hId")int id);

    int updateHelp(Help help);

    List<Help> listHelp();

    List<String> listLink();
}
