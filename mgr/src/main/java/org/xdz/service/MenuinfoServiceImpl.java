package org.xdz.service;

import org.springframework.stereotype.Service;
import org.xdz.mapper.MenuinfoMapper;
import org.xdz.pojo.MenuInfo;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MenuinfoServiceImpl implements MenuinfoService{
    @Resource
    private MenuinfoMapper menuinfoMapper;
    @Override
    public List<MenuInfo> select(Integer roleId) {
        return menuinfoMapper.select(roleId);
    }
}
