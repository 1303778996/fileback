package org.xdz.service;

import org.apache.ibatis.annotations.Param;
import org.xdz.pojo.AdminInfo;
import org.xdz.qo.AdminQo;

import java.util.List;

public interface AdminInfoService {
    AdminInfo login(String name);
    int count(AdminQo adminQo);
    List<AdminInfo> selectAll(AdminQo adminQo);
    int insert(AdminQo adminQo);
    int updateState( int adminId);
    int upPwd( int adminId);
    int change(AdminQo adminQo);
}
