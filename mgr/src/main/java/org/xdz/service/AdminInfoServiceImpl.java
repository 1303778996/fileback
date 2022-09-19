package org.xdz.service;

import org.springframework.stereotype.Service;
import org.xdz.mapper.AdminInfoMapper;
import org.xdz.pojo.AdminInfo;
import org.xdz.qo.AdminQo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminInfoServiceImpl implements AdminInfoService{
    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Override
    public AdminInfo login(String name) {
        return  adminInfoMapper.selByName(name);
    }

    @Override
    public int count(AdminQo adminQo) {
        int count = adminInfoMapper.count(adminQo);
        return count;
    }

    @Override
    public List<AdminInfo> selectAll(AdminQo adminQo) {
        List<AdminInfo> adminInfos = adminInfoMapper.selectAll(adminQo);
        return adminInfos;
    }

    @Override
    public int insert(AdminQo adminQo) {
        int insert = adminInfoMapper.insert(adminQo);
        return insert;
    }

    @Override
    public int updateState(int adminId) {
        return adminInfoMapper.updateState(adminId);
    }

    @Override
    public int upPwd(int adminId) {
        return adminInfoMapper.upPwd(adminId);
    }

    @Override
    public int change(AdminQo adminQo) {
        return adminInfoMapper.change(adminQo);
    }
}
