package org.xdz.mapper;

import org.apache.ibatis.annotations.Param;
import org.xdz.pojo.MenuInfo;

import java.util.List;

public interface MenuinfoMapper {
    List<MenuInfo> select(@Param("id") Integer id);

}
