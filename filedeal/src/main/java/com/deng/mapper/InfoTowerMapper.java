package com.deng.mapper;


//import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author：dengwenxin-wb
 * @Project：filedeal
 * @name：InfoTowerMapper
 * @Date：2024/2/2 14:57
 */

@Repository("infoTowerMapper")
public interface InfoTowerMapper {

    @Insert("LOAD DATA LOCAL INFILE #{filePath} INTO TABLE ${tabelName} " +
            "FIELDS TERMINATED BY ',' " +
            "ENCLOSED BY '\"' " +
            "LINES TERMINATED BY #{line} " +
            "IGNORE 1 LINES " +
            "(@tower_id, @tower_code, @lng, @lat, " +
            " @line_name) SET " +
            "tower_id = @tower_id, tower_code = @tower_code, lng = @lng, lat = @lat, " +
            "line_name = @line_name")
    void load(@Param("filePath") String filePath, @Param("tabelName") String tabelName, @Param("line") String line,
              @Param("ignore") Integer ignore,@Param("field") List<String> field);
//    void load(@Param("map")Map<String, Object>map);
}
