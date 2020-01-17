package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Donate;

import java.util.List;

public interface DonateDao {

    int addDonate(Donate donate);

    Donate getDonateById(@Param("dId")int id);

    int deleteDonateById(@Param("dId")int id);

    int updateDonate(Donate donate);

    List<Donate> listDonate();

    List<String> listLink();
}
