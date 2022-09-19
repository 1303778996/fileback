package org.xdz.mapper;

import org.apache.ibatis.annotations.Param;

public interface MgrLogMapper {
    int insert(@Param("id")int id,@Param("url") String url);
}
