package org.xdz.service;

import org.xdz.pojo.MenuInfo;

import java.util.List;

public interface MenuinfoService {
    List<MenuInfo> select(Integer roleId);
}
