package org.xdz.mapper;

import org.apache.ibatis.annotations.Param;
import org.xdz.pojo.AdminInfo;
import org.xdz.qo.AdminQo;

import java.util.List;

public interface AdminInfoMapper {
    public AdminInfo selByName(@Param("name") String name);
    List<AdminInfo> selectAll(AdminQo adminQo);
    int count(AdminQo adminQo);
    int insert(AdminQo adminQo);
    int updateState( @Param("id") int adminId);
    int upPwd(@Param("id") int adminId);
    int change(AdminQo adminQo);
}
